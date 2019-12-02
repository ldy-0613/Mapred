package cn.q.sdk;

import cn.q.sdk.utils.HttpClientUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class TestDemo {

    @Test
    public void test() {
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod("http://192.168.20.112:80/index" +
                ".html");
        try {
            int i = httpClient.executeMethod(getMethod);
            System.out.println("i = " + i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendChargeSuccess1() throws IOException {
        //1. httpclient对象发送请求
        NameValuePair pair1 = new NameValuePair("e_en", "uv");
        NameValuePair pair2 = new NameValuePair("u_ud", "ldy");
        int statusCode = HttpClientUtils.sendGetRequest2("http://192.168.20" +
                ".112:80/index.html", pair1, pair2);
        System.out.println(statusCode);
    }

    @Test
    public void sendChargeSuccess2() {
        //1. httpclient对象发送请求
        Date date = new Date(); // 当前订单的时间
        String oid = UUID.randomUUID().toString().replace("-", "").toUpperCase(); // 生成的订单id
        NameValuePair[] pairs = {
                new NameValuePair("u_mid", "ldy"),
                new NameValuePair("c_time", date.getTime() + ""),
                new NameValuePair("oid", oid),
                new NameValuePair("ver", "1"),
                new NameValuePair("en", "e_cs"),
                new NameValuePair("pl", "jdk"),
                new NameValuePair("sdk", "java")
        };
        int statusCode = HttpClientUtils.sendGetRequest2("http:/   /192.168" +
                ".20" +
                ".112:80/index.html", pairs);
        System.out.println(statusCode);
    }
}
