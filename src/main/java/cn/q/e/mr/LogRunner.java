package cn.q.e.mr;

import cn.q.e.pojo.GlobalConstants;
import cn.q.e.pojo.LogWritable;
import cn.q.e.utils.LogsUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class LogRunner extends ToolRunner implements Tool {
    private Configuration configuration = new Configuration();

    @Override
    public int run(String[] args) throws Exception {
        Configuration conf = getConf();
        //hadoop jar /xx/xc/css/ss.jar xxx.xx.xx ‐d 2018‐11‐11
        //获取参数存储到conf中
        setArgs(args, conf);
        Job job = Job.getInstance(conf,"etl2hdfs");
        //根据类名获取运行路径
        job.setJarByClass(LogRunner.class);
        //设置map相关
        job.setMapperClass(LogMapper.class);
        job.setMapOutputKeyClass(LogWritable.class);
        job.setMapOutputValueClass(NullWritable.class);

        //设置输入输出路径
        setInputOutputPath(job);
        return job.waitForCompletion(true) ? 0 : 1;
    }

    /**
     * 设置输入和输出的路径
     */
    private void setInputOutputPath(Job job) {
        //1. 获取Configuration对象
        Configuration configuration = job.getConfiguration();
        //2. 获取到日期参数的值
        String running_date = configuration.get(GlobalConstants.RUNNING_DATE_FORMAT);
        //3. 切分一个目录名：2019-11-11 ： 2019/11/11
        String[] yyyy_MM_dd = running_date.split("-");
        String dir = yyyy_MM_dd[0] + "/" + yyyy_MM_dd[1] + "/" + yyyy_MM_dd[2];
        //4. 设置输入路径和输出路径
        try {
            FileInputFormat.setInputPaths(job,
                    new Path(GlobalConstants.INPUT_ETL_PREFIX + dir +"/*"));
            FileOutputFormat.setOutputPath(job, new Path(GlobalConstants.OUTPUT_ETL_PREFIX + dir));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置参数：将日期参数设置到configuration中
     */
    private void setArgs(String[] args, Configuration configuration) {
        //1. 获取到args中的参数
        String running_date = null;
        //2. 校验第1个参数是否合法
        if (args.length == 2 && args[0].equals("-d")) {
            running_date = args[1];
        }else {
            //3. 获取当天，然后通过当天获取昨天
            //3.1 获取到一年中的第几天
            Calendar calendar = Calendar.getInstance();
            int yesterday = calendar.get(Calendar.DAY_OF_YEAR) - 1;
            //3.2 获取到昨天
            calendar.set(Calendar.DAY_OF_YEAR, yesterday);
            Date yesterday_date = calendar.getTime();
            //3.3 转换格式
            running_date = LogsUtils.timestamp2DateString(yesterday_date.getTime() + "");
        }

        //4. 设置日期参数
        configuration.set(GlobalConstants.RUNNING_DATE_FORMAT, running_date);
    }


    @Override
    public void setConf(Configuration configuration) {
        this.configuration = configuration;
//        configuration.addResource(LogRunner.class.getClassLoader().getResource("core-site.xml"));
//        configuration.addResource(LogRunner.class.getClassLoader().getResource("hdfs-site.xml"));
//        configuration.addResource(LogRunner.class.getClassLoader().getResource("yarn-site.xml"));
//        configuration.addResource(LogRunner.class.getClassLoader().getResource("mapred-site.xml"));
    }

    @Override
    public Configuration getConf() {
        return configuration;
    }

    /**
     * args[0] : -d
     * args[1] : 2019-12-02
     */
    public static void main(String[] args) {
        try {
            ToolRunner.run(new Configuration(), new LogRunner(), args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * map
     */
    static class LogMapper extends Mapper<LongWritable, Text, LogWritable, NullWritable> {

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            //1. 一次读一行
            String line = value.toString();
            //2. 直接清洗
            LogWritable log = LogsUtils.getLog(line);
            //3. 输出
            context.write(log, NullWritable.get());
        }
    }
}
