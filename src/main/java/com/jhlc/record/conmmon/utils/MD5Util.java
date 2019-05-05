package com.jhlc.record.conmmon.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


public class MD5Util {

    private static final String HEX_CHARS = "0123456789abcdef";

    /**
     * 日志
     */

    private MD5Util() {
    }

    /**
     * 返回 MessageDigest MD5
     */
    private static MessageDigest getDigest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 返回 MessageDigest MD5
     */
    private static MessageDigest getDigestBySha() {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * MD5加密，并返回作为一个十六进制字节
     */
    public static byte[] md5(byte[] data) {
        return getDigest().digest(data);
    }

    /**
     * SHA-256加密，并返回作为一个十六进制字节
     */
    public static byte[] sha256(byte[] data) {
        return getDigestBySha().digest(data);
    }

    /**
     * MD5加密，并返回作为一个十六进制字节
     * <code>byte[]</code>.
     *
     * @param data Data to digest
     * @return MD5 digest
     */
    public static byte[] md5(String data) {
        byte[] bytes = null;
        try {
            bytes = md5(data.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {

        }
        return bytes;
    }

    /**
     * MD5加密，并返回一个32字符的十六进制值
     */
    public static String md5Hex(byte[] data) {
        return toHexString(md5(data));
    }

    /**
     * MD5加密，并返回一个32字符的十六进制值
     */
    public static String md5Hex(String data) {
        return toHexString(md5(data));
    }

    /**
     * SHA256加密
     */
    public static String sha256Hex(String data) {
        try {
            return toHexString(sha256(data.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {

            return null;
        }
    }

    private static String toHexString(byte[] b) {
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            stringbuffer.append(HEX_CHARS.charAt(b[i] >>> 4 & 0x0F));
            stringbuffer.append(HEX_CHARS.charAt(b[i] & 0x0F));
        }
        return stringbuffer.toString();
    }

    //    public static void main(String[] args) {
//    	String dataSource="137";
//    	String customerName="zs";
//    	String businessNo="05250019000143135043";
//    	String currencyNo="RMB";
//    	String amount="30.00";
//    	String documentNo="50569001900309425607";
//    	String KEY="P_JIAHE";// OPENAPI
//    	String data=dataSource + customerName + businessNo + currencyNo + amount + documentNo + KEY;
//    	System.out.println("密文为："+MD5Util1.sha256Hex(data));
//    }
    public static String getmsg(Map<String, String> map) {
        String data = "";
        String dataSource = map.get("dataSource");
        String customerName = map.get("customerName");
        String businessNo = map.get("businessNo");
        String currencyNo = map.get("currencyNo");
        String amount = map.get("amount");
        String documentNo = map.get("documentNo");
        String KEY = "P_JIAHE";// OPENAPI
        data = dataSource + customerName + businessNo + currencyNo + amount + documentNo + KEY;
        data = sha256Hex(data);
        return data;
    }

    public static String getAppPayMsg(Map<String, String> map) {
        String data = "";
        String dataSource = map.get("dataSource");
        String customerName = map.get("customerName");
        String businessNo = map.get("businessNo");
        String currencyNo = map.get("currencyNo");
        String amount = map.get("amount");
        String KEY = "P_JIAHE";// OPENAPI
        data = dataSource + customerName + businessNo + currencyNo + amount + KEY;
        data = sha256Hex(data);
        return data;
    }

    /**
     * 华泰在线支付密文的拼接
     * Sign:需要转换成大写
     * KEY由华泰线下提供，请求和返回的KEY相同
     * 如果是支付宝支付,微信的支付单据号变成支付宝的
     *
     * @param args
     */
    public static String getHuaTaiMsg(Map<String, String> map) {
        //根据类型获取不同的签名方式
        String type = map.get("type");
        String data = null;
        String channelCode = map.get("channelCode");//渠道编码
        String money = map.get("money");//交易金额
        String orderNo = map.get("orderNo");//订单号
        String tradingTime = map.get("tradingTime");//交易时间
        String payType = map.get("payType");//支付方式
        String WXPaymentNo = map.get("WXPaymentNo");//微信支付单据号
        String thridType = map.get("thridType");//第三方类型
        String batch = map.get("batch");//交易流水号
        String key = map.get("key");//key
        switch (type) {
            case "1":
                //请求华泰支付接口签名方法 Sign=MD5(渠道编码+金额+订单号+交易时间+KEY)
                data = MD5Util.md5Hex(channelCode+money+orderNo+tradingTime+key).toUpperCase();
                break;
            case "2":
                //华泰同步和异步通知接口签名方法：Sign=MD5(渠道编码+订单号+支付方式+微信的支付单据号+KEY)
                data = MD5Util.md5Hex(channelCode+orderNo+payType+WXPaymentNo+key).toUpperCase();
                break;
            case "3":
                //查询支付结果接口签名方法:1:第三方类型为空 Sign=MD5(渠道编码+订单号+KEY)
                data = MD5Util.md5Hex(channelCode+orderNo+key).toUpperCase();
                break;
            case "4":
                //查询支付结果接口签名方法:2:第三方类型不为空 Sign=MD5(渠道编码+订单号+第三方类型+KEY)
                data = MD5Util.md5Hex(channelCode+orderNo+thridType+key).toUpperCase();
                break;
            case "5":
                //支付结果同步通知接口签名方法：Sign=MD5(渠道编码+订单号+第三方类型+交易流水号+KEY)
                data = MD5Util.md5Hex(channelCode+orderNo+thridType+batch+key).toUpperCase();
                break;
            default:
                return "";
        }
        return data;
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("dataSource", "137");
        map.put("customerName", "水电费的是否等");
        map.put("businessNo", "12100019000143176964");
        map.put("currencyNo", "RMB");
        map.put("amount", "3.00");
        map.put("KEY", "P_JIAHE");
        System.out.println(getmsg(map));
    }

}



