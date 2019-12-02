package cn.q.e.pojo;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class LogWritable implements WritableComparable {

    private String ver = EventLogConstant.DEFAULT_VALUE;
    private String en = EventLogConstant.DEFAULT_VALUE;
    private String u_ud = EventLogConstant.DEFAULT_VALUE;
    private String u_mid = EventLogConstant.DEFAULT_VALUE;
    private String u_sd = EventLogConstant.DEFAULT_VALUE;
    private String sdk = EventLogConstant.DEFAULT_VALUE;
    private String c_time = EventLogConstant.DEFAULT_VALUE;
    private String l = EventLogConstant.DEFAULT_VALUE;
    private String b_iev = EventLogConstant.DEFAULT_VALUE;
    private String b_rst = EventLogConstant.DEFAULT_VALUE;
    private String p_url = EventLogConstant.DEFAULT_VALUE;
    private String p_ref = EventLogConstant.DEFAULT_VALUE;
    private String tt = EventLogConstant.DEFAULT_VALUE;
    private String pl = EventLogConstant.DEFAULT_VALUE;
    private String ip = EventLogConstant.DEFAULT_VALUE;
    private String oid = EventLogConstant.DEFAULT_VALUE;
    private String on = EventLogConstant.DEFAULT_VALUE;
    private String cua = EventLogConstant.DEFAULT_VALUE;
    private String cut = EventLogConstant.DEFAULT_VALUE;
    private String pt = EventLogConstant.DEFAULT_VALUE;
    private String ca = EventLogConstant.DEFAULT_VALUE;
    private String ac = EventLogConstant.DEFAULT_VALUE;
    private String kv_key1 = EventLogConstant.DEFAULT_VALUE;
    private String kv_key2 = EventLogConstant.DEFAULT_VALUE;
    private String du = EventLogConstant.DEFAULT_VALUE;
    private String browserName = EventLogConstant.DEFAULT_VALUE;
    private String browserVersion = EventLogConstant.DEFAULT_VALUE;
    private String osName = EventLogConstant.DEFAULT_VALUE;
    private String osVersion = EventLogConstant.DEFAULT_VALUE;
    private String country = EventLogConstant.DEFAULT_VALUE;
    private String province = EventLogConstant.DEFAULT_VALUE;
    private String city = EventLogConstant.DEFAULT_VALUE;

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getU_ud() {
        return u_ud;
    }

    public void setU_ud(String u_ud) {
        this.u_ud = u_ud;
    }

    public String getU_mid() {
        return u_mid;
    }

    public void setU_mid(String u_mid) {
        this.u_mid = u_mid;
    }

    public String getU_sd() {
        return u_sd;
    }

    public void setU_sd(String u_sd) {
        this.u_sd = u_sd;
    }

    public String getSdk() {
        return sdk;
    }

    public void setSdk(String sdk) {
        this.sdk = sdk;
    }

    public String getC_time() {
        return c_time;
    }

    public void setC_time(String c_time) {
        this.c_time = c_time;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getB_iev() {
        return b_iev;
    }

    public void setB_iev(String b_iev) {
        this.b_iev = b_iev;
    }

    public String getB_rst() {
        return b_rst;
    }

    public void setB_rst(String b_rst) {
        this.b_rst = b_rst;
    }

    public String getP_url() {
        return p_url;
    }

    public void setP_url(String p_url) {
        this.p_url = p_url;
    }

    public String getP_ref() {
        return p_ref;
    }

    public void setP_ref(String p_ref) {
        this.p_ref = p_ref;
    }

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOn() {
        return on;
    }

    public void setOn(String on) {
        this.on = on;
    }

    public String getCua() {
        return cua;
    }

    public void setCua(String cua) {
        this.cua = cua;
    }

    public String getCut() {
        return cut;
    }

    public void setCut(String cut) {
        this.cut = cut;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getKv_key1() {
        return kv_key1;
    }

    public void setKv_key1(String kv_key1) {
        this.kv_key1 = kv_key1;
    }

    public String getKv_key2() {
        return kv_key2;
    }

    public void setKv_key2(String kv_key2) {
        this.kv_key2 = kv_key2;
    }

    public String getDu() {
        return du;
    }

    public void setDu(String du) {
        this.du = du;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(this.ver);
        out.writeUTF(this.en);
        out.writeUTF(this.u_ud);
        out.writeUTF(this.u_mid);
        out.writeUTF(this.u_sd);
        out.writeUTF(this.c_time);
        out.writeUTF(this.l);
        out.writeUTF(this.b_iev);
        out.writeUTF(this.b_rst);
        out.writeUTF(this.p_url);
        out.writeUTF(this.p_ref);
        out.writeUTF(this.tt);
        out.writeUTF(this.pl);
        out.writeUTF(this.ip);
        out.writeUTF(this.oid);
        out.writeUTF(this.on);
        out.writeUTF(this.cua);
        out.writeUTF(this.cut);
        out.writeUTF(this.pt);
        out.writeUTF(this.ca);
        out.writeUTF(this.ac);
        out.writeUTF(this.kv_key1);
        out.writeUTF(this.kv_key2);
        out.writeUTF(this.du);
        out.writeUTF(this.browserName);
        out.writeUTF(this.browserVersion);
        out.writeUTF(this.osName);
        out.writeUTF(this.osVersion);
        out.writeUTF(this.country);
        out.writeUTF(this.province);
        out.writeUTF(this.city);
        out.writeUTF(this.sdk);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.ver = in.readUTF();
        this.en = in.readUTF();
        this.u_ud = in.readUTF();
        this.u_mid = in.readUTF();
        this.u_sd = in.readUTF();
        this.c_time = in.readUTF();
        this.l = in.readUTF();
        this.b_iev = in.readUTF();
        this.b_rst = in.readUTF();
        this.p_url = in.readUTF();
        this.p_ref = in.readUTF();
        this.tt = in.readUTF();
        this.pl = in.readUTF();
        this.ip = in.readUTF();
        this.oid = in.readUTF();
        this.on = in.readUTF();
        this.cua = in.readUTF();
        this.cut = in.readUTF();
        this.pt = in.readUTF();
        this.ca = in.readUTF();
        this.ac = in.readUTF();
        this.kv_key1 = in.readUTF();
        this.kv_key2 = in.readUTF();
        this.du = in.readUTF();
        this.browserName = in.readUTF();
        this.browserVersion = in.readUTF();
        this.osName = in.readUTF();
        this.osVersion = in.readUTF();
        this.country = in.readUTF();
        this.province = in.readUTF();
        this.city = in.readUTF();
        this.sdk = in.readUTF();
    }

    @Override
    public String toString() {
        return ver + "\u0001" +
                en + "\u0001" +
                u_ud + "\u0001" +
                u_mid + "\u0001" +
                u_sd + "\u0001" +
                c_time + "\u0001" +
                l + "\u0001" +
                b_iev + "\u0001" +
                b_rst + "\u0001" +
                p_url + "\u0001" +
                p_ref + "\u0001" +
                tt + "\u0001" +
                pl + "\u0001" +
                ip + "\u0001" +
                oid + "\u0001" +
                on + "\u0001" +
                cua + "\u0001" +
                cut + "\u0001" +
                pt + "\u0001" +
                ca + "\u0001" +
                ac + "\u0001" +
                kv_key1 + "\u0001" +
                kv_key2 + "\u0001" +
                du + "\u0001" +
                sdk + "\u0001" +
                browserName + "\u0001" +
                browserVersion + "\u0001" +
                osName + "\u0001" +
                osVersion + "\u0001" +
                country + "\u0001" +
                province + "\u0001" +
                city;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
