package cn.q.sdk.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;

public class HttpClientUtils {
    public static int sendGetRequest1(String uri) {
        try {
            //1. 创建httpclient对象
            HttpClient httpClient = new HttpClient();
            //2. 创建get请求对象
            GetMethod getMethod = new GetMethod(uri);
            //3. httpclient对象发送请求
            int statusCode = httpClient.executeMethod(getMethod);
            return statusCode;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static int sendGetRequest2(String uri, NameValuePair... nvps) {
        try {
            //1. 创建httpclient对象
            HttpClient httpClient = new HttpClient();
            //2. 创建get请求对象
            GetMethod getMethod = new GetMethod(uri);
            getMethod.setQueryString(nvps);
            //3. httpclient对象发送请求
            int statusCode = httpClient.executeMethod(getMethod);
            return statusCode;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
