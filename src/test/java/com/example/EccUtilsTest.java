package com.example;
 

import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;



import org.junit.Test;

public class EccUtilsTest {
    @Test
    public void test() throws Exception{
        
        try {
            KeyPair keyPair = EccUtils.getKeyPair();
            ECPublicKey pubKey = (ECPublicKey) keyPair.getPublic();
            ECPrivateKey priKey = (ECPrivateKey) keyPair.getPrivate();
            //System.out.println("[pubKey]:\n" + getPublicKey(keyPair));
            //System.out.println("[priKey]:\n" + getPrivateKey(keyPair));
 
            //测试文本
            String content = "abcdefg";
 
            //加密
            byte[] cipherTxt = EccUtils.encrypt(content.getBytes(), pubKey);
            //解密
            byte[] clearTxt = EccUtils.decrypt(cipherTxt, priKey);
            //打印
            System.out.println("content:" + content);
            System.out.println("cipherTxt["+cipherTxt.length+"]:" + new String(cipherTxt));
            System.out.println("clearTxt:" + new String(clearTxt));
 
            //签名
            byte[] sign = EccUtils.sign(content, priKey);
            //验签
            boolean ret = EccUtils.verify(content, sign, pubKey);
            //打印
            System.out.println("content:" + content);
            System.out.println("sign["+sign.length+"]:" + new String(sign));
            System.out.println("verify:" + ret);
 
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[main]-Exception:" + e.toString());
        }
    }
}