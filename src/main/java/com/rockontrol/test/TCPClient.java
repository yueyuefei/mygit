package com.rockontrol.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) throws IOException {

		try {
			// 1.建立客户端socket连接，指定服务器位置及端口
//			Socket socket = new Socket("192.168.200.143", 9026);
			Socket socket = new Socket("www.aqiapp.com", 9026);
			socket.setSoTimeout(30000);  
			socket.setTcpNoDelay(true);
			// 2.得到socket读写流
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			// 输入流
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			// 3.利用流按照一定的操作，对socket进行读写操作
//			String info = "ST=62;CN=1301;PW=123456;MN=14010000500001;CP=&&QN=20160929110111034;TeleCtlCode=10200200102;TeleCtlData=38000:264:3487,1708,442,1281,445,417,449,413,443,419,447,1275,450,412,444,418,448,414,441,421,446,1277,449,413,442,1280,445,1277,448,414,442,1280,445,1277,448,1274,440,1282,443,1279,446,416,450,1272,443,419,479,384,440,1282,443,419,448,414,441,421,445,416,450,1272,442,1280,445,1277,448,1274,441,421,445,417,449,413,443,419,447,415,441,421,445,417,449,413,443,419,447,415,441,421,445,417,449,413,443,419,447,415,441,421,445,417,449,413,443,419,447,415,441,421,445,416,450,412,443,418,448,414,441,1281,444,417,449,413,442,1280,446,1277,449,1274,441,421,445,29912,3483,1712,448,1274,441,422,445,417,449,413,442,1280,446,416,450,412,443,418,448,414,441,1281,445,417,449,1273,441,1281,444,418,449,1274,441,1281,444,1278,447,1275,450,1272,443,419,447,1275,450,412,443,419,448,1275,451,411,444,418,448,413,442,420,446,416,451,411,444,418,449,413,442,1280,445,1277,448,1274,441,1281,444,418,448,414,442,420,446,1276,449,1273,442,420,446,416,450,412,444,418,448,414,441,421,446,416,450,412,444,418,448,414,442,420,446,416,450,412,444,418,448,414,442,420,446,1276,449,413,443,419,447,1275,450,412,444,418,448,413,442,0&&";
//			String info = "QN=20101201010101001;ST=62;CN=1302;PW=123456;MN=14010000500000;CP=&&TeleCtlCode=1d000000101&&";
//			String info = "QN=20101201010101001;ST=62;CN=1304;PW=123456;MN=14010000500000;CP=&&TeleCtlCode=10100100101&&";
//			String info = "QN=20101201010101001;ST=22;CN=1012;PW=123456;MN=14010000500000;CP=&&SystemTime=20161013104930&&";
			String info = "QN=20101201010101001;ST=62;CN=9810;PW=123456;MN=14010000500003;CP=&&Devstatus&&";
//			String info = "QN=20101201010101001;ST=22;CN=1001;PW=123456;MN=14010000500003;CP=&&&&";
			pw.write(info);
			pw.flush();
			// 接收服务器的相应
			String reply =null;
			try {
				reply = br.readLine();
			} catch (Exception e) {
				reply="超时";
			}
			// 4.关闭资源
			socket.shutdownInput();
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
			System.out.println("接收服务器的信息：" + reply);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
