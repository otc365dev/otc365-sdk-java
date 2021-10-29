package com.otc365.sdk.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.*;

public class Utils {

    static ObjectMapper mapper = new ObjectMapper();


    public static String HMACSHA256(String data, String key) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

    public static String createBaseString(Map<String, Object> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String baseString = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Object value = params.get(key);
            if (i == keys.size() - 1) {
                baseString = baseString + key + "=" + value;
            } else {
                baseString = baseString + key + "=" + value + "&";
            }
        }
        return baseString;
    }

    public static String md5(String buffer) throws Exception {

        char[] hexDigest = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(buffer.getBytes("UTF-8"));
        byte[] data = md.digest();
        char[] str = new char[32];
        int k = 0;

        for(int i = 0; i < 16; ++i) {
            byte b = data[i];
            str[k++] = hexDigest[b >>> 4 & 15];
            str[k++] = hexDigest[b & 15];
        }

        return new String(str);

    }


    public static String signRSA(String data, String priKeyStr) throws Exception {

        byte[] priKey = Base64.decodeBase64(priKeyStr);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(priKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes(StandardCharsets.UTF_8));
        return Base64.encodeBase64String(signature.sign());
    }

    public static String httpCall(String url,Map<String, Object> params) throws Exception{

        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost request = new HttpPost(url);
        request.setHeader("Content-Type","application/json");
        StringEntity entity = new StringEntity(mapper.writeValueAsString(params), "UTF-8");
        request.setEntity(entity);

        HttpResponse response = client.execute(request);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            return EntityUtils.toString(response.getEntity());
        }else{
            throw new Exception("http call failure,code="+response.getStatusLine().getStatusCode());
        }
    }
}