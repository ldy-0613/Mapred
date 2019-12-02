package cn.q.e.pojo;

public class EventLogConstant {
    /**
     * hbase表相关
     */
    public static final String LOG_HBASE_NAME = "event_logs";

    public static final String LOG_FAMILY_NAME = "info";

    /**
     * 日志相关的列
     */
    public static final String LOG_COLUMN_NAME_IP = "ip";

    public static final String LOG_COLUMN_NAME_SEPARTOR = "\001";

    public static final String LOG_COLUMN_NAME_SERVER_TIME = "s_time";

    public static final String LOG_COLUMN_NAME_EVENT_NAME = "en";

    public static final String LOG_COLUMN_NAME_VERSION = "ver";

    public static final String LOG_COLUMN_NAME_UUID = "u_ud";

    public static final String LOG_COLUMN_NAME_MEMBER_ID = "u_mid";

    public static final String LOG_COLUMN_NAME_SESSION_ID ="u_sd";

    public static final String LOG_COLUMN_NAME_CLIENT_TIME = "c_time";

    public static final String LOG_COLUMN_NAME_LANGUAGE = "l";

    public static final String LOG_COLUMN_NAME_USER_AGENT = "b_iev";

    public static final String LOG_COLUMN_NAME_RESOLUTION= "b_rst";

    public static final String LOG_COLUMN_NAME_CURRENT_URL = "p_url";

    public static final String LOG_COLUMN_NAME_PREFFER_URL = "p_ref";

    public static final String LOG_COLUMN_NAME_TITLE = "tt";

    public static final String LOG_COLUMN_NAME_PLATFORM_NAME = "pl";

    public static final String LOG_SEPARTOR = "?";

    public static final String LOG_CHARSET = "utf-8";

    public static final String PARAM_SEPARTOR = "&";

    public static final String ARG_SEPARTOR = "=";

    public static final Class<LogWritable> CLASS_NAME = LogWritable.class;

    public static final String DEFAULT_VALUE = "未知";

    /**
     * 订单相关
     */
    public static final String LOG_COLUMN_NAME_ORDER_ID = "oid";

    public static final String LOG_COLUMN_NAME_ORDER_NAME = "on";

    public static final String LOG_COLUMN_NAME_CURRENCY_TYPE = "cut";

    public static final String LOG_COLUMN_NAME_CURRENCY_AMOUNT = "cua";

    public static final String LOG_COLUMN_NAME_PAYMENT_TYPE = "pt";

    /**
     * userAgent相关
     */
    public static final String LOG_COLUMN_NAME_BROWSER_NAME = "browserName";

    public static final String LOG_COLUMN_NAME_BROWSER_VERSION = "browserVersion";

    public static final String LOG_COLUMN_NAME_OS_NAME = "osName";

    public static final String LOG_COLUMN_NAME_OS_VERSION = "osVersion";

    /**
     * 地域相关
     */
    public static final String LOG_COLUMN_NAME_COUNTRY = "country";

    public static final String LOG_COLUMN_NAME_PROVINCE = "province";

    public static final String LOG_COLUMN_NAME_CITY = "city";
}
