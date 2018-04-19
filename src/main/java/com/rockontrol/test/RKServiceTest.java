package com.rockontrol.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.appserver.android.api.rpc.PCService;
import org.appserver.android.api.rpc.Request;
import org.appserver.android.api.rpc.Response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rockontrol.cloud.conf.Constant;
import com.rockontrol.pojo.Page;
import com.rockontrol.pojo.WeatherAirDataHistoryGb;
import com.rockontrol.pojo.WeatherStationDataHourtimeMap;
import com.rockontrol.pojo.WeatherStationInfo;

/** 
* @ClassName RKServiceTest 
* @Description  
* @author huohaiyang 
* @date 2016年6月24日 下午2:24:41 
*  
*/
public class RKServiceTest {

//	static String port = "8080";
//	static String SERVER_IP = "192.168.200.96";
//	static String port = "1502";
//	static String SERVER_IP = "10.1.2.136";
//	static String SERVER_IP = "192.168.204.237";
	static String port = "8414";
	static String SERVER_IP = "www.aqiapp.com";
//	static String port = "10366";
//	static String SERVER_IP = "ty.aqiapp.com";
	static String postID = "101100101";	//太原
	static String lat = "39.908471";
	static String lng = "116.371934";
	static String latitude = "39.908471";
	static String longitude = "116.371934";
	static String username = "18634318355";
	static String mn_gb = "1087A";
	static String mn_own = "14010501010004";
	static String mn_zm = "021616020000002C";
	static Gson gson = new Gson();
	
	public static void main(String[] args) {
		getZzExcel();
//		getGbExcel();
	}

	
	/**
	 * @Description
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:02:09 	
	 */
	public static void getServer() {
		Request request = new Request("health://HealthService");
		request.setAttribute("rmi", "surroundingNew");
		request.setAttribute("longitude","112.560959");
		request.setAttribute("latitude","37.791412");
		request.setAttribute("username","18634318355");
		getAppserver(request);
	}
	
	
	/**
	 * @Description 获取当前坐标，附近的设备
	 * @author huohaiyang 
	 * @date 2016年9月5日 下午12:57:24
	 */
	public static void getStation() {
		Request request = new Request("health://HealthService");
		request.setAttribute("rmi","addressStationList");
		request.setAttribute("longitude",longitude);
		request.setAttribute("latitude",latitude);
		getAppserver(request);
	}
	
	/**
	 * @Description 模拟第三方登录
	 * @author huohaiyang 
	 * @date 2016年8月23日 下午1:47:41
	 */
	public static void login() {
		Request request = new Request("env-user-manage://UserService");
		request.setAttribute("rmi","getUserBaseInfoAuthorize");
		request.setAttribute("username","18634318355");
//		request.setAttribute("openId","123");
//		request.setAttribute("typeId","wx");
//		request.setAttribute("nickname","qwert");
//		request.setAttribute("headPath",URLEncoder.encode("http://q.qlogo.cn/qqapp/1105439627/AACA1320CF0DE9E6DBD7D1DE3466607E/100"));
		getAppserver(request);
	}
	
	/**
	 * @Description
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:02:09 	
	 */
	public static void getAroundSites() {
		Request request = new Request("web://WeatherStationInfoNewService");
		request.setAttribute("rmi","getAroundSites");
		request.setAttribute("level","12");
		request.setAttribute("lat","37.791412");
		request.setAttribute("lng","112.560959");
		request.setAttribute("username","18634318355");
		getAppserver(request);
	}
	
	/**
	 * @Description 读取图片
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:02:09 	
	 */
	public static void findHomePic() {
		Request request = new Request("env-pic://ReadService");
		request.setAttribute("rmi","home");
		request.setAttribute("cnd","{\"location\":\"山西省太原市\"}");
		getAppserver(request);
	}
	/**
	 * @Description 向redis初始化设备关系数据
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:02:09 	
	 */
	public static void initStationUser() {
		Request request = new Request("web://WeatherStationInfoNewService");
		request.setAttribute("rmi","init_station_user");
		request.setAttribute("type","1");
		request.setAttribute("username","");
		request.setAttribute("stationMn","");
		getAppserver(request);
	}
	/**
	 * @Description 向redis初始化指定类型的设备
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:02:09 	
	 */
	public static void initStationInfo() {
		Request request = new Request("web://WeatherStationInfoNewService");
		request.setAttribute("rmi","init_station_info");
		request.setAttribute("type","0");
		getAppserver(request);
	}
	/**
	 * @Description 获取设备7天/24小时数据
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:02:09 	
	 */
	public static void get7_24Data(String mn) {
		Request request = new Request("web://WeatherStationInfoNewService");
		request.setAttribute("rmi","get7_24Data");
		request.setAttribute("mn",mn);
		getAppserver(request);
	}
	
	/**
	 * @Description 获取设备实时数据
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:02:09 	
	 */
	public static void getRealData(String mn) {
		Request request = new Request("web://WeatherStationInfoNewService");
		request.setAttribute("rmi","findRealData");
		request.setAttribute("mn",mn);
		getAppserver(request);
	}
	
	/**
	 * @Description 获取redis中的数据
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:02:09 	
	 */
	public static void getRedisData() {
		Request request = new Request("web://WeatherStationInfoNewService");
		request.setAttribute("rmi","get_redis_data");
		request.setAttribute("type","string");
		request.setAttribute("keys","1410051f01000695.2016102816.3");
		getAppserver(request);
	}
	
	/**
	 * @Description 获取redis中的键值
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:02:09 	
	 */
	public static void get_redis_key() {
		Request request = new Request("web://WeatherStationInfoNewService");
		request.setAttribute("rmi","get_redis_key");
		request.setAttribute("keys","station.mn.*");
		getAppserver(request);
	}
	
	/**
	 * @Description 测试推送大屏
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:02:09 	
	 */
	public static void TimerPushScreen() {
		Request request = new Request("health://HealthService");
		request.setAttribute("rmi","TimerPushScreen");
		getAppserver(request);
	}
	
	/**
	 * @Description 定时检测国标
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:02:09 	
	 */
	public static void TimerDetection() {
		Request request = new Request("health://HealthService");
		request.setAttribute("rmi","TimerDetection");
		getAppserver(request);
	}
	
	/**
	 * @Description 定时检测自主
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:02:09 	
	 */
	public static void TimerDetectionOwn() {
		Request request = new Request("health://HealthService");
		request.setAttribute("rmi","TimerDetectionOwn");
		getAppserver(request);
	}
	
	
	/**
	 * @Description 初始化单位
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:02:09 	
	 */
	public static void initWeatherAirParameter() {
		Request request = new Request("web://WeatherAirParameterService");
		request.setAttribute("rmi","set_redis");
		getAppserver(request);
	}
	
	
	/**
	 * @Description 获取设备并删除
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:24:44 	
	 */
	public static void getWeatherStation() {
		WeatherStationInfo condition=  new WeatherStationInfo();
		condition.setAddress("北京");
		condition.setType("4");
		
		Request request = new Request("web://WeatherStationInfoService");
		request.setAttribute("rmi", "findAllByContitions");
		request.setAttribute("page", gson.toJson(new Page(1,300)));
		request.setAttribute("pojo", gson.toJson(condition));
		String data = getAppserver(request);
		if(StringUtils.isNotEmpty(data)){
			Type listType = new TypeToken<List<WeatherStationInfo>>() {}.getType();
			List<WeatherStationInfo> weatherStationInfoList = gson.fromJson(data,listType);
			for (WeatherStationInfo weatherStationInfo : weatherStationInfoList) {
				if("4".equals(weatherStationInfo.getType())&&"北京".equals(weatherStationInfo.getBuilder())&&NumberUtils.isNumber(weatherStationInfo.getAddress())){
					System.out.println(weatherStationInfo.getAddress()+":"+weatherStationInfo.getBuilder());
					removeWeatherStation(weatherStationInfo.getId()+"");
					removeWeatherStationEnt(weatherStationInfo.getMn());
				}
			}
		}
	}
	
	/**
	 * @Description 删除设备
	 * @param id
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:23:31 	
	 */
	public static void removeWeatherStation(String id){
		Request request = new Request("web://WeatherStationInfoService");
		request.setAttribute("rmi", "remove");
		request.setAttribute("id",id);
		getAppserver(request);
	}
	
	/**
	 * 
	 * @Description 删除设备-企业库
	 * @param mn
	 * @author huohaiyang 
	 * @date 2016年6月24日 下午2:22:30
	 */
	public static void removeWeatherStationEnt(String mn){
		Request request = new Request("enterprise://WeatherStationInfoService");
		request.setAttribute("rmi", "removeByMn");
		request.setAttribute("mn",mn);
		getAppserver(request);
	}	
	
	//生成Excel自主基站数据
	public static void getZzExcel() {
		String mns = "";
		try {
			mns = FileUtils.readFileToString(new File("src/main/java/com/rockontrol/mn.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonArray = JSONArray.parseArray(mns);
		// 创建文件
        WritableWorkbook book;
		try {
			book = Workbook.createWorkbook(new File("E:/数据/20161219--至今自主基站小时数据.xls"));
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String mn = jsonObject.getString("mn");
				String name = jsonObject.getString("name");
				boolean isMoMi = jsonObject.getBoolean("isMoMi");
				//创建工作表
				WritableSheet sheet = book.createSheet(name, 0);
				sheet = getZzSHeet(sheet,mn);
				if (isMoMi) {
					WritableSheet sheetTemp = book.createSheet(name+"(模拟)", 0);
					sheetTemp = getZzSHeet(sheetTemp,mn+"_bak");
				}
			}
	        // 写入数据并关闭文件
	        book.write();
	        book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static WritableSheet getZzSHeet(WritableSheet sheet,String mn) {
		String data = getZzData(mn);
		if(StringUtils.isNotEmpty(data)){
			List<WeatherStationDataHourtimeMap> list = JSON.parseArray(data,WeatherStationDataHourtimeMap.class);
			try {
				Label label = new Label(0,0,"mn号");
				sheet.addCell(label);
				label = new Label(1,0,"项目");
				sheet.addCell(label);
				label = new Label(2,0,"数值");
				sheet.addCell(label);
				label = new Label(3,0,"时间");
				sheet.addCell(label);
				
				for (int j = 1; j < list.size()+1; j++) {
					//sheet.setRowView(j,5);
					label = new Label(0,j,list.get(j-1).getMn());
					sheet.addCell(label);
					label = new Label(1,j,list.get(j-1).getCode());
					sheet.addCell(label);
					label = new Label(2,j,list.get(j-1).getValue());
					sheet.addCell(label);
					label = new Label(3,j,list.get(j-1).getGatherTime());
					sheet.addCell(label);
				}
				sheet.setColumnView(0,20);
				sheet.setColumnView(3,20);	
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sheet;
	}
	
	
	/**
	 * 生成Excel国标基站数据
	 * @Description 
	 * @author huohaiyang 
	 * @date 2016年6月27日 下午9:57:06
	 */
	public static void getGbExcel() {
		String mns = "";
		try {
			mns = FileUtils.readFileToString(new File("src/main/java/com/rockontrol/mn_gb.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonArray = JSONArray.parseArray(mns);
		// 创建文件
		WritableWorkbook book;
		try {
			book = Workbook.createWorkbook(new File("E:/数据/20161112国标小时数据.xls"));
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String mn = jsonObject.getString("mn");
				String name = jsonObject.getString("name");
				//创建工作表
				WritableSheet sheet = book.createSheet(name, 0);
				String data = getGbData(mn);
				if(StringUtils.isNotEmpty(data)){
					//输入内容
					List<WeatherAirDataHistoryGb> list = JSON.parseArray(data,WeatherAirDataHistoryGb.class);
					Label label = new Label(0,0,"mn号");
					sheet.addCell(label);
					label = new Label(1,0,"项目");
					sheet.addCell(label);
					label = new Label(2,0,"日期");
					sheet.addCell(label);
					label = new Label(3,0,"0点");
					sheet.addCell(label);
					label = new Label(4,0,"1点");
					sheet.addCell(label);
					label = new Label(5,0,"2点");
					sheet.addCell(label);
					label = new Label(6,0,"3点");
					sheet.addCell(label);
					label = new Label(7,0,"4点");
					sheet.addCell(label);
					label = new Label(6+2,0,"5点");
					sheet.addCell(label);
					label = new Label(7+2,0,"6点");
					sheet.addCell(label);
					label = new Label(8+2,0,"7点");
					sheet.addCell(label);
					label = new Label(9+2,0,"8点");
					sheet.addCell(label);
					label = new Label(10+2,0,"9点");
					sheet.addCell(label);
					label = new Label(11+2,0,"10点");
					sheet.addCell(label);
					label = new Label(12+2,0,"11点");
					sheet.addCell(label);
					label = new Label(13+2,0,"12点");
					sheet.addCell(label);
					label = new Label(14+2,0,"13点");
					sheet.addCell(label);
					label = new Label(15+2,0,"14点");
					sheet.addCell(label);
					label = new Label(16+2,0,"15点");
					sheet.addCell(label);
					label = new Label(17+2,0,"16点");
					sheet.addCell(label);
					label = new Label(18+2,0,"17点");
					sheet.addCell(label);
					label = new Label(19+2,0,"18点");
					sheet.addCell(label);
					label = new Label(20+2,0,"19点");
					sheet.addCell(label);
					label = new Label(21+2,0,"20点");
					sheet.addCell(label);
					label = new Label(22+2,0,"21点");
					sheet.addCell(label);
					label = new Label(23+2,0,"22点");
					sheet.addCell(label);
					label = new Label(24+2,0,"23点");
					sheet.addCell(label);
					
					for (int j = 1; j < list.size()+1; j++) {
						sheet.setRowView(j,300);
						label = new Label(0,j,list.get(j-1).getMn());
						sheet.addCell(label);
						label = new Label(1,j,list.get(j-1).getCode());
						sheet.addCell(label);
						label = new Label(2,j,DateFormatUtils.format(list.get(j-1).getDate(),Constant.DATE_FORFORMAT_YMDHMS));
						sheet.addCell(label);
						label = new Label(3,j,list.get(j-1).getT00());
						sheet.addCell(label);
						label = new Label(3+1,j,list.get(j-1).getT01());
						sheet.addCell(label);
						label = new Label(4+1,j,list.get(j-1).getT02());
						sheet.addCell(label);
						label = new Label(5+1,j,list.get(j-1).getT03());
						sheet.addCell(label);
						label = new Label(6+1,j,list.get(j-1).getT04());
						sheet.addCell(label);
						label = new Label(7+1,j,list.get(j-1).getT05());
						sheet.addCell(label);
						label = new Label(8+1,j,list.get(j-1).getT06());
						sheet.addCell(label);
						label = new Label(9+1,j,list.get(j-1).getT07());
						sheet.addCell(label);
						label = new Label(10+1,j,list.get(j-1).getT08());
						sheet.addCell(label);
						label = new Label(11+1,j,list.get(j-1).getT09());
						sheet.addCell(label);
						label = new Label(12+1,j,list.get(j-1).getT10());
						sheet.addCell(label);
						label = new Label(13+1,j,list.get(j-1).getT11());
						sheet.addCell(label);
						label = new Label(14+1,j,list.get(j-1).getT12());
						sheet.addCell(label);
						label = new Label(15+1,j,list.get(j-1).getT13());
						sheet.addCell(label);
						label = new Label(16+1,j,list.get(j-1).getT14());
						sheet.addCell(label);
						label = new Label(17+1,j,list.get(j-1).getT15());
						sheet.addCell(label);
						label = new Label(18+1,j,list.get(j-1).getT16());
						sheet.addCell(label);
						label = new Label(19+1,j,list.get(j-1).getT17());
						sheet.addCell(label);
						label = new Label(20+1,j,list.get(j-1).getT18());
						sheet.addCell(label);
						label = new Label(21+1,j,list.get(j-1).getT19());
						sheet.addCell(label);
						label = new Label(22+1,j,list.get(j-1).getT20());
						sheet.addCell(label);
						label = new Label(23+1,j,list.get(j-1).getT21());
						sheet.addCell(label);
						label = new Label(24+1,j,list.get(j-1).getT22());
						sheet.addCell(label);
						label = new Label(25+1,j,list.get(j-1).getT23());
						sheet.addCell(label);
					}
					
					sheet.setColumnView(1,20);
					sheet.setColumnView(2,20);
				}
			}
			// 写入数据并关闭文件
			book.write();
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String getZzData(String mn) {
		Request request = new Request("web://WeatherStationInfoNewService");
		request.setAttribute("rmi", "excelZz");
		request.setAttribute("mn",mn);
		request.setAttribute("gatherTimea","2016-12-19 00:00:00");
		request.setAttribute("gatherTimeb","2017-01-06 00:00:00");
		return getAppserver(request);
	}
	
	private static String getGbData(String mn) {
		Request request = new Request("web://WeatherStationInfoNewService");
		request.setAttribute("rmi", "excelGb");
		request.setAttribute("mn",mn);
		request.setAttribute("datea","2016-11-15 00:00:00");
		request.setAttribute("dateb","2016-11-16 00:00:00");
		return getAppserver(request);
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
			response = PCService.invoke(SERVER_IP, port, request,"");
			if (response != null) {
				String message = response.getAttribute("message");
				System.out.println("message："+message);
				if("1".equals(message)){
					String data = response.getAttribute("data");
					System.out.println("data："+data);
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