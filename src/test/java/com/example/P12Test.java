package com.example;


import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Enumeration;
 

import org.junit.Test;



public class P12Test {
    @Test
    public void test() throws Exception{
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
    
    }
}