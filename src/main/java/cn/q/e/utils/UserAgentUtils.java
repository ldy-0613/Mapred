package cn.q.e.utils;

import cn.q.e.pojo.UserAgentInfo;
import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class UserAgentUtils {
    /**
     * 解析useragent的字符串、
     * Mozilla%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64%3B%20rv%3A70.0)%20Gecko%2F20100101%20Firefox%2F70.0
     */
    public static UserAgentInfo getUserAgentInfo(String useragent) {
        //1. 解码
        String decode = null;
        try {
            decode = URLDecoder.decode(useragent, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //2. 解析
        UserAgentInfo userAgentInfo = new UserAgentInfo();
        UASparser uaSparser;
        try {
            //2.1 这个对象的本质是去解析useragent，它通过加载jar内部的user_agnet_string.txt文本来查找usergent的规则
            uaSparser = new UASparser(OnlineUpdater.getVendoredInputStream());
            //2.2 解析useragent获取到uasparder的useragentinfo对象
            cz.mallat.uasparser.UserAgentInfo uaInfo = uaSparser.parse(decode);
            //2.3 把uasparser的useragentinfo转换为我们自定义的useragentinfo对象
            userAgentInfo.setOsName(uaInfo.getOsName());
            userAgentInfo.setOsVersion(uaInfo.getOsCompany());
            userAgentInfo.setBrowserName(uaInfo.getUaName().split(" ")[0]);
            userAgentInfo.setBrowserVersion(uaInfo.getBrowserVersionInfo());
            return userAgentInfo;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Test
    public void test() {
        UserAgentInfo userAgentInfo = UserAgentUtils.getUserAgentInfo("Mozilla%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64%3B%20rv%3A70.0)%20Gecko%2F20100101%20Firefox%2F70.0");
        System.out.println(userAgentInfo);
    }
}
