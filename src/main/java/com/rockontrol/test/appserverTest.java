package com.rockontrol.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.appserver.android.api.rpc.PCService;
import org.appserver.android.api.rpc.Request;
import org.appserver.android.api.rpc.Response;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.rockontrol.pojo.HealthButtonDetail;
import com.rockontrol.pojo.HealthControlButton;
import com.rockontrol.pojo.HealthValue;

public class appserverTest {

	static Gson gson = new Gson();
//	static String SERVER_IP = "192.168.200.178";
//	static String SERVER_IP = "10.1.2.133";
//	static String SERVER_IP = "192.168.204.237";
//	static String port = "1502";
	static String SERVER_IP = "www.aqiapp.com";
//	static String SERVER_IP = "ty.aqiapp.com";
	static String port = "8414";
	public static void main(String[] args) throws Exception {
		testData();
//		testGetNetTime();
//		testMsg();
//		getRedisData("weather.data.mobile.city.f1.101100101");
//		getRedisData("weather.city.name.singel.太原");
//		getRedisData("control.14010000500000.10200200102");
//		getRedisData("rkmd3100005775b.20161021.daycount");
		//生成随机字母数字组合
//		getCharAndNumr(5);
//		getRedisData("weather.city.name.all");
//		getRedisData("station.mn.10110010110015");
//		getRedisData("weather.city.mapall");
//		getRedisData("weather.city.mapall");
//		getRedisData("unit.code.vocs");
//		getRedisData("14010001500003.zm.last");
//		getRedisData("53250301020003.2017032214");
//		getRedisData("14010001500003.2016112119.2");
//		getRedisData("14010001500003.2016112119.3");
//		getRedisData("14010001500003.2016112119.4");
//		getRedisData("14010001500004.2016112411.1");
//		getRedisData("station.mn.1410051F01000716");
//		setRedisData("keys","data");
//		getRedisData("weather.data.mobile.city.f1.101100101");
//		get_redis_key();
//		getForecast();
//		getDetails();
//		getListStations();
//		sendTCP();
//		brandList();
//		panelList();
//		saveOrUpdatePanel();
//		sendOrder();
//		learnButton();
//		learnGroupButton();
//		health();
//		surroundingNew();
//		getParameterGov();
	}
	
	/**
	 * 空气医生
	 * @throws Exception
	 * @date 2016-9-7上午10:23:09
	 */ 
	public static void health() throws Exception {
		Request request = new Request("health://HealthService");
//		HealthControlButton button = new HealthControlButton();
//		request.setAttribute("rmi","stationDetails");
//		request.setAttribute("username","18234047278");
//		request.setAttribute("longitude","112.56130953467807");
//		request.setAttribute("latitude","37.79144123702355");
//		request.setAttribute("id","973");
		request.setAttribute("rmi","surroundingNew");
		request.setAttribute("username","18234047278");
		request.setAttribute("longitude","112.561912");
		request.setAttribute("latitude","37.79139");
//		request.setAttribute("buttonId","474");
		getAppserver(request);
	}
	/**
	 * 政务大厅服务接口
	 * @throws Exception
	 * @date 2016-9-7上午10:23:09
	 */ 
	public static void getParameterGov() throws Exception {
		Request request = new Request("gov://GovService");
		request.setAttribute("rmi","PcAppTypeService");
//		request.setAttribute("logs","[{\"userId\":\"1\",\"appId\":\"\",\"entId\":\"456\",\"loginName\":\"manage\",\"actionTime\":\"2016-12-01 16:40:27\",\"action\":\"登录\",\"ip\":\"192.232.1.3\"},{\"userId\":\"1\",\"appId\":\"123123\",\"entId\":\"456\",\"loginName\":\"manage\",\"actionTime\":\"2016-12-01 16:40:27\",\"action\":\"退出\",\"ip\":\"192.232.1.3\"}]");
//		request.setAttribute("versionCode","7");
//		request.setAttribute("oldPassword","123");
//		request.setAttribute("packageName","com.rockontrol.android.intelbuilding");
		getAppserver(request);
	}
	/**
	 * 室外
	 * @throws Exception
	 * @date 2016-9-7上午10:23:09
	 */
	public static void surroundingNew() throws Exception {
		Request request = new Request("health://HealthService");
		request.setAttribute("longitude","112.562055");
		request.setAttribute("latitude","37.791015");
		request.setAttribute("rmi","surroundingNew");
		getAppserver(request);
	}
	/**
	 * 学习按钮
	 * @throws Exception
	 * @date 2016-9-7上午10:23:09
	 */
	public static void learnButton() throws Exception {
		Request request = new Request("health://HealthService");
		request.setAttribute("code","1d000000707");
		request.setAttribute("icon","7");
		request.setAttribute("name","上下扫");
		request.setAttribute("panelId","333");
		request.setAttribute("mn","14010000500004");
		request.setAttribute("rmi","learnButton");
		getAppserver(request);
	}
	/**
	 * 学习组合按钮
	 * @throws Exception
	 * @date 2016-9-7上午10:23:09
	 */
	public static void learnGroupButton() throws Exception {
		Request request = new Request("health://HealthService");
		HealthControlButton button = new HealthControlButton();
		button.setIcon("1");
		button.setName("开");
		button.setPanelId(507l);
		List<HealthButtonDetail> list = new ArrayList<>();
		HealthButtonDetail detail = new HealthButtonDetail();
		detail.setCode("2d000000402");
		detail.setName("不");
		list.add(detail);
		button.setList(list);
		request.setAttribute("dataButton",gson.toJson(button));
		request.setAttribute("mn","14010001500004");
		request.setAttribute("rmi","learnGroupButton");
		getAppserver(request);
	}

	/**
	 * 保存按钮
	 * @throws Exception
	 * @date 2016-9-7上午10:23:09
	 */
	public static void sendOrder() throws Exception {
		Request request = new Request("health://HealthService");
		request.setAttribute("mn","14010000500003");
		request.setAttribute("code","1d000000401");
		request.setAttribute("rmi","sendOrder");
		getAppserver(request);
	}
	/**
	 * 保存面板
	 * @throws Exception
	 * @date 2016-9-7上午10:23:09
	 */
	public static void saveOrUpdatePanel() throws Exception {
		Request request = new Request("health://HealthService");
		request.setAttribute("mn","021616020000002B");
		request.setAttribute("name","bm");
		request.setAttribute("typeCode","01");
		request.setAttribute("typeName","空调");
		request.setAttribute("brandCode","021");
		request.setAttribute("brandName","大金");
		request.setAttribute("modelName","456");
		request.setAttribute("rmi","saveOrUpdatePanel");
		getAppserver(request);
	}
	
	/**
	 * 品牌列表
	 * @throws Exception
	 * @date 2016-9-7上午10:23:09
	 */
	public static void panelList() throws Exception {
		Request request = new Request("health://HealthService");
		request.setAttribute("mn","14010000500004");
		request.setAttribute("rmi","panelList");
		getAppserver(request);
	}
	/**
	 * 品牌列表
	 * @throws Exception
	 * @date 2016-9-7上午10:23:09
	 */
	public static void brandList() throws Exception {
		Request request = new Request("health://HealthService");
		request.setAttribute("typeCode","01");
		request.setAttribute("rmi","brandList");
		getAppserver(request);
	}
	/**
	 * 调用TCP下发命令
	 * @throws Exception
	 * @date 2016-9-7上午10:23:09
	 */
	public static void sendTCP() throws Exception {
		Request request = new Request("health://HealthService");
		request.setAttribute("cn","1301");
		request.setAttribute("mn","14010000500000");
		request.setAttribute("code","10200200102");
		request.setAttribute("rmi","sendTCP");
		getAppserver(request);
	}
	/**
	 * 获取我的设备、我关注的设备
	 * @throws Exception
	 * @date 2016-9-7上午10:23:09
	 */
	public static void getListStations() throws Exception {
		Request request = new Request("health://HealthService");
		request.setAttribute("username","18234047278");
//		request.setAttribute("username","15035693747");
		request.setAttribute("type","1");
		request.setAttribute("rmi","listStationsInHome");
		getAppserver(request);
	}
	/**
	 * 详情页面
	 * @throws Exception
	 * @date 2016-9-7上午10:23:09
	 */
	public static void getDetails() throws Exception {
		Request request = new Request("health://HealthService");
//		request.setAttribute("longitude","112.562156");
//		request.setAttribute("latitude","37.791229");
		request.setAttribute("longitude","112.5729246249221");
		request.setAttribute("latitude","37.62784724747002");
		request.setAttribute("username","18234047278");
//		request.setAttribute("longitude","112.589806");
//		request.setAttribute("latitude","37.814327");
//		37.74504089355469
//		112.585578918457
//		request.setAttribute("username","18035065860");
//		request.setAttribute("id","62");
		request.setAttribute("id","531");
//		request.setAttribute("id","579");
		request.setAttribute("rmi","stationDetails");
		getAppserver(request);
	}
	/**
	 * 空气质量预测
	 * @throws Exception
	 * @date 2016-9-7上午10:23:09
	 */
	public static void getForecast() throws Exception {
		Request request = new Request("health://HealthService");
		request.setAttribute("rmi","airQualityForecast");
		getAppserver(request);
	}
	/**
	 * @Description 获取redis中的数据
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:02:09 	
	 */
	public static void getRedisData() throws Exception {
		Request request = new Request("web://WeatherStationInfoNewService");
		request.setAttribute("rmi","get_redis_data");
		request.setAttribute("type","string");
//		request.setAttribute("type","set");
		request.setAttribute("keys","1252A.station.last");
		getAppserver(request);
	}
	public static String getRedisData(String key) throws Exception {
		
		Request request = new Request("web://WeatherStationInfoNewService");
		request.setAttribute("rmi","get_redis_data");
		request.setAttribute("type","string");
//		request.setAttribute("type","set");
		request.setAttribute("keys",key);
		String data = getAppserver(request);
		return data;
	}
	
	/**
	 * redis  set值
	 * @author dongpeng
	 * @data 2017年4月13日上午9:54:02
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static String setRedisData(String key, String value) throws Exception {
		Request request = new Request("web://WeatherStationInfoNewService");
		request.setAttribute("rmi","set_redis_key");
		request.setAttribute("keys",key);
		request.setAttribute("data",value);
		String data = getAppserver(request);
		return data;
	}
	/**
	 * @Description 获取redis中的键值
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:02:09 	
	 */
	public static void get_redis_key() {
		Request request = new Request("web://WeatherStationInfoNewService");
		request.setAttribute("rmi","get_redis_key");
		request.setAttribute("keys","14010000500003.*");
		getAppserver(request);
	}
	 


	/**
	 * 生成模拟数据
	 * @throws Exception
	 */
	private static void testData()throws Exception {

		Request request = new Request("enterprise://WebEnterpriseService");
		request.setAttribute("rmi", "findByEcode");
		request.setAttribute("ecode", "100008");
		getAppserver(request);
	}

	/**
	 * 获取网络时间
	 * @throws Exception
	 */
	public static void testGetNetTime()throws Exception {
//        String webUrl1 = "http://www.bjtime.cn";//bjTime
		long l = System.currentTimeMillis();
        String webUrl2 = "http://www.baidu.com";//百度
        String webUrl3 = "http://www.taobao.com";//淘宝
        String webUrl4 = "http://www.ntsc.ac.cn";//中国科学院国家授时中心
        String webUrl5 = "http://www.360.cn";//360
        String webUrl6 = "http://www.beijing-time.org";//beijing-time
//        System.out.println(getWebsiteDatetime(webUrl1) + " [bjtime]");
        System.out.println(getWebsiteDatetime(webUrl2) + " [百度]");
        System.out.println(getWebsiteDatetime(webUrl3) + " [淘宝]");
        System.out.println(getWebsiteDatetime(webUrl4) + " [中国科学院国家授时中心]");
        System.out.println(getWebsiteDatetime(webUrl5) + " [360安全卫士]");
        System.out.println(getWebsiteDatetime(webUrl6) + " [beijing-time]");
        System.out.println("调用耗时：" + ( System.currentTimeMillis() - l ) +" ms");
    }
	 private static String getWebsiteDatetime(String webUrl){
	        try {
	            URL url = new URL(webUrl);// 取得资源对象
	            URLConnection uc = url.openConnection();// 生成连接对象
	            uc.connect();// 发出连接
	            long ld = uc.getDate();// 读取网站日期时间
	            Date date = new Date(ld);// 转换为标准时间对象
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);// 输出北京时间
	            return sdf.format(date);
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	

	/**
	 * 漫道短信测试
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static void testMsg()throws Exception {

		Request request = new Request("env-user-manage://UserService");
		request.setAttribute("rmi","sendMsg");
		request.setAttribute("phone", "18636181748");
		request.setAttribute("validateCode","123");
		request.setAttribute("type","0");
		getAppserver(request);
	}
	
	
	/**
	 * @Description 执行appserver
	 * @param request
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午1:56:47 	
	 */
	public static String getAppserver(Request request) {
		Response response = null;
		try {
			long l = System.currentTimeMillis();
			response = PCService.invoke(SERVER_IP, port, request,"");
			if (response != null) {
				String message = response.getAttribute("message");
				System.out.println("message："+message);
				if("1".equals(message)){
					String data = response.getAttribute("data");
					System.out.println("data："+data);
					System.out.println("调用耗时：" + ( System.currentTimeMillis() - l ) +" ms");
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
	/**
	  * java生成随机数字和字母组合
	  * @param length[生成随机数的长度]
	  * @return
	  */
	 public static String getCharAndNumr(int length) {
	  String val = "";
	  Random random = new Random();
	  for (int i = 0; i < length; i++) {
	   // 输出字母还是数字
	   String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; 
	   // 字符串
	   if ("char".equalsIgnoreCase(charOrNum)) {
	    // 取得大写字母还是小写字母
	    int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; 
	    val += (char) (choice + random.nextInt(26));
	   } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
	    val += String.valueOf(random.nextInt(10));
	   }
	  }
	  System.out.println(val);
	  return val;
	 }
}
