package cn.q.e.utils;

import cn.q.e.pojo.RegionInfo;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.logging.Logger;

public class IPUtils extends IPSeeker {
    private static final Logger LOGGER = Logger.getGlobal(); // 创建全局的日志记录器
    private static final IPSeeker IP_SEEKER = IPSeeker.getInstance();

    public static RegionInfo getReginInfo4Cz(String ip) {

        //1. 校验ip是否为空或者空串
        if (StringUtils.isNotEmpty(ip)) {
            RegionInfo regionInfo = new RegionInfo();
            //2. 创建IPSeeker
            String addr = IP_SEEKER.getCountry(ip);
            String area = IP_SEEKER.getArea(ip);
            boolean isChina = isChina(addr); // 是否为国内的ip
            // 3. 判断是否为中国ip
            if (isChina) {
                String country = "中国";
                //3.1 获取省的索引位置
                int index = addr.indexOf("省");
                switch (index) {
                    case 2:
                    case 3:// 省
                        String province = addr.substring(0, index); // 获取到省的字符串
                        int index2 = addr.indexOf("市"); // 通过省去查找市的索引
                        String city = "未知";
                        if (index2 != -1) { // 说明查找到了市
                            city = addr.substring(index + 1, index2); // 获取市的字符串
                        }
                        regionInfo.setCountry(country);
                        regionInfo.setProvince(province);
                        regionInfo.setCity(city);
                        break;
                    case -1:
                        index = addr.indexOf("市");
                        if (index == 2) {// 3.2 直辖市
                            String province2 = addr.substring(0, index); // 获取到直辖市的字符串
                            int index3 = addr.indexOf("区"); // 获取到区的索引
                            String city2 = "";
                            if (index3 == -1) { // 没有查找到区
                                index3 = addr.indexOf("县"); // 查找县的索引
                                if (index3 == -1) { // 没有找到县
                                    city2 = "未知"; // 如果没有区也没有县就赋值为未知
                                }
                            }
                            if (!city2.equals("未知"))
                                city2 = addr.substring(index + 1, index3); // 如果有区或者有县，就获取区或者县的名称
                            regionInfo.setCountry(country);
                            regionInfo.setProvince(province2);
                            regionInfo.setCity(city2);
                        } else { // 3.3 自治区和特别行政区
                            String province3 = addr.substring(0, 2); // 截取前两个字符串，保证一定市自治区的或者特别行政区
                            int index3 = 2; // 设置了默认的索引
                            switch (province3) { // 自治区
                                case "内蒙":
                                    province3 = province3 + "古"; // 内蒙特殊情况
                                    index3++;
                                case "新疆":
                                case "西藏":
                                case "广西":
                                case "宁夏":
                                case "香港":
                                case "澳门":
                                    String city3 = "未知"; // 默认初始
                                    if (index3 < addr.length()) { // 说明addr后面有区或者市
                                        city3 = addr.substring(index3); // 给城市赋值，否则就就是未知
                                    }
                                    regionInfo.setCountry(country);
                                    regionInfo.setProvince(province3);
                                    regionInfo.setCity(city3);
                                    break;
                            }
                        }
                        break;
                }
                return regionInfo;
            } else {
                regionInfo.setCountry(addr);
                regionInfo.setProvince(area);
                regionInfo.setCity("未知");
            }
            return regionInfo;
        }
        return null;
    }


    /**
     * 根据ip获取它的地址-淘宝
     */
    public RegionInfo getReginInfo4Taobao(String ip) {
        try {
            //0. 创建uri
            String uri = "http://ip.taobao.com/service/getIpInfo.php";
            //1. 创建httpclient对象
            HttpClient httpClient = new HttpClient();
            //2. 创建get请求对象
            GetMethod getMethod = new GetMethod(uri);
            //2.1 添加一个头信息
            getMethod.addRequestHeader("Content‐Type", "application/x-www-form-urlencoded?charset=utf-8");
            //2.2 添加参数
            NameValuePair[] nvps = {
                    new NameValuePair("ip", ip)
            };
            getMethod.setQueryString(nvps);
            //3. httpclient对象发送请求
            int statusCode = httpClient.executeMethod(getMethod);
            //4. 如果响应成功了我们就获取到响应体
            RegionInfo regionInfo = new RegionInfo();
            if (statusCode == HttpStatus.SC_OK) {
                String responseBodyAsString = getMethod.getResponseBodyAsString();
                //5. 创建json对象
                JSONObject jsonObject = JSONObject.parseObject(responseBodyAsString);
                JSONObject jobj = jsonObject.getJSONObject("data");
                String country = jobj.getString("country");
                String region = jobj.getString("region");
                String city = jobj.getString("city");
                regionInfo.setCountry(country);
                regionInfo.setProvince(region);
                regionInfo.setCity(city);
            }
            return regionInfo;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static boolean isChina(String addr) {
        if (addr.contains("市") || addr.contains("省") || addr.contains("区") || addr.contains("新疆")
                || addr.contains("澳门") || addr.contains("香港") || addr.contains("内蒙古") || addr.contains("西藏")) {
            return true;
        }
        return false;
    }

    @Test
    public void test1() {
        RegionInfo reginInfo = new IPUtils().getReginInfo4Cz("111.111.11" +
                ".111");
        System.out.println(reginInfo);
    }

    @Test
    public void test2() {
        RegionInfo reginInfo = new IPUtils().getReginInfo4Taobao("111.111.11" +
                ".111");
        System.out.println(reginInfo);
    }
}
