package com.rockontrol.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

public class httpClientTest {
	public static void main(String[] args) {
//		String a = getDataByGet("http://www.aqiapp.com/pmact_pmrest/public/getDataByMn?mn=1085A");
//		System.out.println(a);
		Map<String, String> params = new HashMap<String, String>();
//		params.put("jsonStr", "{\"birthday\":\"2018-04-11\",\"deptId\":\"100365\",\"deptIdCard\":\"100365\",\"deptName\":\"局领导\",\"duty\":\"测试\",\"email\":\"\",\"entId\":\"\",\"flag\":\"0\",\"iconPath\":\"\",\"id\":7169,\"idCard\":\"aaatest\",\"legalNum\":\"\",\"loginNm\":\"aaatest\",\"mobile\":\"18636181748\",\"orderId\":8,\"password\":\"\",\"politicalOutlook\":0,\"post\":\"\",\"printDuty\":\"\",\"printOrg\":\"\",\"printUnit\":\"\",\"qqOpenId\":\"\",\"rootDeptId\":\"/100365/\",\"sfCard\":\"\",\"userName\":\"测试\",\"userType\":\"2\",\"usex\":0,\"wxOpenId\":\"\"}");
		String b = getDataByPost("http://www.dcf.daqi110.com/gov_springBoot/gov_pc/saveUser", params);
		System.out.println(b);
	}
	
	private static String getDataByGet(String url) {
		try {
			// 创建默认的客户端实例
			HttpClient httpclient = new DefaultHttpClient();
			// 创建Get请求实例
			HttpGet httpgets = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpgets);
			return EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static String getDataByPost(String url, Map<String, String> params) {
		// 创建默认的客户端实例
		HttpClient httpclient = new DefaultHttpClient();
		// 创建post请求实例
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}
		System.out.println(JSON.toJSONString(nvps));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
			HttpResponse response = httpclient.execute(httpPost);
			return EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return null;
	}

}
