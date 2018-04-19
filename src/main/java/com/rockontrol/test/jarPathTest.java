package com.rockontrol.test;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;

public class jarPathTest {
	public static void main(String[] args) {
		String path = getPath();
		System.out.println(path);
		String path1 = getPath1();
		System.out.println(path1);
	}

	private static String getPath(){
		URL url = jarPathTest.class.getProtectionDomain().getCodeSource().getLocation();
		String filePath = null;  
        try {
			filePath = URLDecoder.decode(url.getPath(), "utf-8");// 转化为utf-8编码  
		} catch (Exception e) {
			e.printStackTrace();
		}
        if (filePath.endsWith(".jar")) {// 可执行jar包运行的结果里包含".jar"  
            // 截取路径中的jar包名  
            filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);  
        } 
        File file = new File(filePath);  
        filePath = file.getAbsolutePath();//得到windows下的正确路径  
		return filePath;
	}
	private static String getPath1(){
		String filePath = System.getProperty("java.class.path");
		String pathSplit = System.getProperty("path.separator");//windows下是";",linux下是":"
		
		if(filePath.contains(pathSplit)){
			filePath = filePath.substring(0,filePath.indexOf(pathSplit));
		}else if (filePath.endsWith(".jar")) {//截取路径中的jar包名,可执行jar包运行的结果里包含".jar"
			//此时的路径是"E:\workspace\Demorun\Demorun_fat.jar"，用"/"分割不行
			//下面的语句输出是-1，应该改为lastIndexOf("\\")或者lastIndexOf(File.separator)
//				System.out.println("getPath2:"+filePath.lastIndexOf("/"));
			filePath = filePath.substring(0, filePath.lastIndexOf(File.separator) + 1);
			
		}
		return filePath;
	}
}
