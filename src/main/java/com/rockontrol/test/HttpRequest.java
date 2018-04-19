package com.rockontrol.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.HttpURLConnection;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class HttpRequest {
   
    public static String sendPost(String url,String cntent) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            //conn.setRequestProperty("Accept-Charset", "UTF-8");
            //	Content-Type:application/x-www-form-urlencoded
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //conn.setRequestProperty("Content-type", "application/json");
            //conn.setRequestProperty("username", "cloudtest");
            //conn.setRequestProperty("password", "cloudtest");
            conn.setDoOutput(true);
            conn.setDoInput(true);
           out = new PrintWriter(conn.getOutputStream());
            out.print(cntent);
            // flush输出流的缓冲
            out.flush();
            conn.connect();
            
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    public static void main(String[] args) {
    	JSONObject jsons = new JSONObject();
/*    	jsons.put("uploadTaskId", "4028b881624c763b01624c7965900010");
    	jsons.put("taskTitle", "监管事件测试");
    	jsons.put("taskDescribe", "监管事件测试描述");
    	jsons.put("regionCode", "测试地址");
    	jsons.put("regionAddress", "测试地址");
    	jsons.put("xais", 116.651387);
    	jsons.put("yais", 39.92156);
    	jsons.put("suspectedCause", "垃圾堆放");
    	jsons.put("sendSystemCode", "51");
    	jsons.put("sendSystemName", "绩效考核");
    	jsons.put("senderUserid", "3098");
    	jsons.put("senderName", "超级管理员");
    	jsons.put("flag", "1");
    	jsons.put("eventTime", "");
    	jsons.put("linkPersonTel", "13434567890");
    	jsons.put("suggType", "2");
    	jsons.put("suggMethod", "1");
    	jsons.put("eventCode", "1");
    	jsons.put("eventTime", "2018-03-18");*/
    	JSONArray array=new JSONArray();
    	JSONObject fj = new JSONObject();
    	fj.put("type", "1");
    	fj.put("fujianPath", "55555");
    	array.add(fj);
    	//jsons.put("xcqz", array);
    	
    	
/*    	
    	eventJson.put("params","{'params': {'eventCode': '010701','eventTime': '2018-01-01','flag': '0','linkPersonTel': '','regionAddress': '东昌府区','regionCode': '371502000000','sendSystemCode': '31'," +
    			"'sendSystemName': '数字城管','senderName': '','senderUserid': 'admin','suggMethod': '2','suggType': '3','suspectedCause': '','taskDescribe': '444','taskTitle': '444'," +
    			"'uploadTaskId': '200420180330165513','xais': '37.44679831919068','yais': '116.32672122510225'},'sysCode': '31'}");*/
		
/*    	System.out.println(eventJson.toString());
    	String aa=new String();
    	*/
    	
    	
   	    //jsons.put("id", null);
    	jsons.put("userName", "wu");
    	jsons.put("usex", 1);
    	jsons.put("birthday", "2018-04-13");
    	jsons.put("mobile", "12345677890");
    	jsons.put("duty", "团员");
    	jsons.put("sfCard", "1111111");
    	jsons.put("deptId", "0");
    	jsons.put("legalNum", "");
    	jsons.put("email", "");
    	jsons.put("politicalOutlook", 0);
    	jsons.put("post", "组长");
    	jsons.put("idCard", "wucaijuan");
    	jsons.put("iconPath", "");
    	jsons.put("txPath", "");
    	jsons.put("Password", "123345");
    	
    	
    	JSONObject eventJson = new JSONObject();
    	eventJson.put("params", jsons.toString());
/*    	json.put("pageNo", 1);
    	json.put("pageSize", 10);*/
    	String json="";
    	try {
			//json = HttpRequest.sendPost("http://www.dcf.daqi110.com/dcf_Services/pendingTask/tasks!uploadPendingTask.action",eventJson.toString());
    		//json = HttpRequest.sendPost("http://localhost:8080/Services/pendingTask/tasks!uploadPendingTask.action",eventJson.toString());
    		
    		//aa = HttpRequest.sendPost("http://localhost:8080/Services/pendingTask/tasks!getTaskList.action",json.toString());
    		//aa = HttpRequest.sendPost("http://www.dcf.daqi110.com/dcf_Services/pendingTask/tasks!getTaskList.action",json.toString());
			//updateTaskState
			//json = HttpRequest.sendPost("http://www.dcf.daqi110.com/dcf_Services/pendingTask/tasks!updateTaskState.action",jsons.toString());
			
			//json = HttpRequest.sendPost("http://1.180.90.146:11646/data/updateUser?jsonStr=%7B%22id%22%3A8640%2C%22userName%22%3A%22wucaijuanceshi%22%2C%22loginNm%22%3A%22wucaijuanceshi%22%2C%22password%22%3A%22%22%2C%22entId%22%3A%22%22%2C%22usex%22%3A0%2C%22duty%22%3A%22%22%2C%22mobile%22%3A%2218836181234%22%2C%22sfCard%22%3A%22%22%2C%22idCard%22%3A%22wucaijuanceshi%22%2C%22birthday%22%3A%22%22%2C%22deptId%22%3A%22100277%22%2C%22orderId%22%3A22%2C%22flag%22%3A%220%22%2C%22iconPath%22%3A%22%22%2C%22deptIdCard%22%3A%22100277%22%2C%22rootDeptId%22%3A%22%2F100277%2F100225%2F100220%2F%22%2C%22deptName%22%3A%22%E7%9D%A3%E6%9F%A5%E7%A7%91%22%2C%22userType%22%3A%222%22%2C%22printUnit%22%3A%22%22%2C%22printOrg%22%3A%22%22%2C%22printDuty%22%3A%22%22%2C%22legalNum%22%3A%22%22%2C%22email%22%3A%22%22%2C%22qqOpenId%22%3A%22%22%2C%22wxOpenId%22%3A%22%22%2C%22politicalOutlook%22%3A0%2C%22post%22%3A%22%22%7D","");
		      json=HttpRequest.sendPost("http://www.dcf.daqi110.com/gov_springBoot/gov_pc/saveUser",jsons.toString());
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	System.out.println(json+"*****");
    	
    }
    
    
}

  