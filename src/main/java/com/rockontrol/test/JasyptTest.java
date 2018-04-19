package com.rockontrol.test;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

public class JasyptTest {
	public static void main(String[] args){
    	//加密工具
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        //加密配置
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        //自己在用的时候更改此密码
        config.setPassword("rkconfig132");
        //应用配置
        encryptor.setConfig(config);
        //此处为需要加密的密码
        String plaintext="root";
        //加密
        String ciphertext=encryptor.encrypt(plaintext);
        System.out.println(plaintext + " : " + ciphertext);
        
        String ciphertext1=ciphertext;
        //解密
        String plaintext1=encryptor.decrypt(ciphertext1);
        System.out.println(ciphertext1 + " : " + plaintext1);
    }

}
