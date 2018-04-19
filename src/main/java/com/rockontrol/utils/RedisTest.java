package com.rockontrol.utils;

import java.util.HashMap;
import java.util.Map;

import org.appserver.android.api.rpc.PCService;
import org.appserver.android.api.rpc.Request;
import org.appserver.android.api.rpc.Response;

/**
 * 用于测试，获取鄂尔多斯服务器上的redis数据
 * @author DP
 * @date 2016-8-30下午4:17:55
 */
public class RedisTest {
	public static Map<String, String> map = new HashMap<String, String>();
	public static String get(String key) {
		if(map.containsKey(key)){
			return map.get(key);
		}
		Request request = new Request("web://WeatherStationInfoNewService");
		request.setAttribute("rmi","get_redis_data");
		request.setAttribute("type","string");
		request.setAttribute("keys",key);
		String data = getAppserver(request);
		map.put(key, data);
		return data;
	}
	public static String getRedisData(String key,String type) {
		Request request = new Request("web://WeatherStationInfoNewService");
		request.setAttribute("rmi","get_redis_data");
		request.setAttribute("type","string");
		request.setAttribute("keys",key);
		String data = getAppserver(request);
		return data;
	}
	public static String getAppserver(Request request) {
		Response response = null;
		try {
			long l = System.currentTimeMillis();
			response = PCService.invoke("www.aqiapp.com", "8414", request);
			if (response != null) {
				String message = response.getAttribute("message");
				if("1".equals(message)){
					String data = response.getAttribute("data");
					return data;
				}
			} else {
				System.out.println("response为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
