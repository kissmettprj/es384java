package com.example;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Enumeration;

import java.util.Base64;
 





public class P12 {

    
    public static void main( String[] args ) throws Exception{
    // TODO Auto-generated method stub
		final String KEYSTORE_FILE     = "c:\\ws\\test\\CS\\ecc.p12";
 
        final String KEYSTORE_PASSWORD = "password";
 
        final String KEYSTORE_ALIAS    = "alias";
 
 
 
        // try 
        // {
 
            final KeyStore ks = KeyStore.getInstance("PKCS12");
 
            final FileInputStream fis = new FileInputStream(KEYSTORE_FILE);
 
 
 
            // If the keystore password is empty(""), then we have to set
 
            // to null, otherwise it won't work!!!
 
            char[] nPassword = null;
 
            if ((KEYSTORE_PASSWORD == null) || KEYSTORE_PASSWORD.trim().equals(""))
 
            {
 
                nPassword = null;
 
            }
 
            else
 
            {
 
                nPassword = KEYSTORE_PASSWORD.toCharArray();
 
            }
 
            ks.load(fis, nPassword);
 
            fis.close();
 
            System.out.println("------------------------");
 
            System.out.println("keystore type=" + ks.getType());
 
 
 
            // Now we loop all the aliases, we need the alias to get keys.
 
            // It seems that this value is the "Friendly name" field in the
 
            // detals tab <-- Certificate window <-- view <-- Certificate
 
            // Button <-- Content tab <-- Internet Options <-- Tools menu
 
            // In MS IE 6.
 
            final Enumeration enum1 = ks.aliases();
 
            String keyAlias = null;
 
            if (enum1.hasMoreElements()) // we are readin just one certificate.
 
            {
 
                keyAlias = (String)enum1.nextElement();
 
                System.out.println("alias=[" + keyAlias + "]");
 
            }
 
 
 
            // Now once we know the alias, we could get the keys.
 
            System.out.println("is key entry=" + ks.isKeyEntry(keyAlias));
 
            final PrivateKey prikey = (PrivateKey) ks.getKey(keyAlias, nPassword);
 
            final Certificate cert = ks.getCertificate(keyAlias);
 
            final PublicKey pubkey = cert.getPublicKey();
 
 
 
            System.out.println("cert class = " + cert.getClass().getName());
 
            System.out.println("cert = " + cert);
 
            System.out.println("public key = " + pubkey);
 
            System.out.println("private key = " + prikey);
 
        // } 
        // catch (final Exception e) 
        // {
 
        //     e.printStackTrace();
 

        // }

        // public x coord: 24752672487975418306024396676109002507950822991139013051437819880116151781387474855166890388916120863119956246365416
        // public y coord: 32940948776842709881100035911730617516984256533771431581325439231999276588080650436658948498602056977426967403072541
        //BigInteger -> byte[] -> base64
        BigInteger bigNum1 = new BigInteger("24752672487975418306024396676109002507950822991139013051437819880116151781387474855166890388916120863119956246365416");
        BigInteger bigNum2 = new BigInteger("32940948776842709881100035911730617516984256533771431581325439231999276588080650436658948498602056977426967403072541");
        byte[] num1 = bigNum1.toByteArray();
        byte[] num2 = bigNum2.toByteArray();
        System.out.println("x: "+BytesToStr(num1));
        System.out.println("y: "+BytesToStr(num2));
        
        System.out.println("x: "+Base64.getEncoder().encodeToString(num1));
        System.out.println("y: "+Base64.getEncoder().encodeToString(num2));
    }
    static String BytesToStr(byte[] bs){
        String ret="";
        for (byte b : bs) {
            ret += b+",";
        }
        return ret;
    }
}