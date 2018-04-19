package com.rockontrol.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.alibaba.fastjson.JSONObject;
import com.rockontrol.utils.RedisTest;
import com.rockontrol.utils.RedisUtils;

import parsii.eval.Expression;
import parsii.eval.Parser;
import parsii.eval.Scope;
import redis.clients.jedis.Jedis;

public class expressionTest {
	public static void main(String[] args) {
		String a = handleData("4.73","mydata*0.395+7.329||V1598A*0.5+mydata*0.5","pm10","2016083123");
//		String a = handleData("20","if(lanlian=0,0,mydata*0.3+lanlian*0.7)","");
		System.out.println(a);
	}
	private static String handleData(String value, String exp, String type) {
//		if(NumberUtils.toDouble(value)==0){
//			return "0.0"; 
//		}
		Map<String, Double> values = new HashMap<String, Double>();
		values.put("lanlian", 15.0);
		values.put("zhigong", 20.0);
		values.put("shengwu", 16.0);
		values.put("tielu", 23.0);
		values.put("average", (values.get("lanlian")+values.get("zhigong")+values.get("shengwu")+values.get("tielu"))/4);
		values.put("lanlianpm10", 4.4);
		values.put("zhigongpm10", 4.4);
		values.put("shengwupm10", 4.4);
		values.put("tielupm10", 4.4);
		values.put("averagepm10", (values.get("lanlianpm10")+values.get("zhigongpm10")+values.get("shengwupm10")+values.get("tielupm10"))/4);
		// compile  
		Scope scope = new Scope();  
		Expression parsiiExpr;
		try {
			parsiiExpr = Parser.parse(exp,scope);
			scope.getVariable("mydata").setValue(NumberUtils.toDouble(value));
			if(values.get("average"+type)!=null)
			scope.getVariable("average").setValue(values.get("average"+type));
			if(values.get("zhigong"+type)!=null)
			scope.getVariable("zhigong").setValue(values.get("zhigong"+type)); 
			if(values.get("lanlian"+type)!=null)  
			scope.getVariable("lanlian").setValue(values.get("lanlian"+type));  
			if(values.get("shengwu"+type)!=null) 
			scope.getVariable("shengwu").setValue(values.get("shengwu"+type));  
			if(values.get("tielu"+type)!=null) 
			scope.getVariable("tielu").setValue(values.get("tielu"+type));  
		  
			// evaluate  
			Double result = parsiiExpr.evaluate();  
			return result.toString();
//			DecimalFormat df = new DecimalFormat("0");  
//			return df.format(result);
		} catch (parsii.tokenizer.ParseException e) {
			e.printStackTrace();
		}  
		return null;
	}
	
	private static String handleData(String value, String exp, String type, String time) {

		Map<String, Double> values = new HashMap<String, Double>();
		values.put("lanlian", 15.0);
		values.put("zhigong", 20.0);
		values.put("shengwu", 16.0);
		values.put("tielu", 23.0);
		values.put("average", (values.get("lanlian")+values.get("zhigong")+values.get("shengwu")+values.get("tielu"))/4);
		values.put("lanlianpm10", 4.4);
		values.put("zhigongpm10", 4.4);
		values.put("shengwupm10", 4.4);
		values.put("tielupm10", 4.4);
		values.put("averagepm10", (values.get("lanlianpm10")+values.get("zhigongpm10")+values.get("shengwupm10")+values.get("tielupm10"))/4);
		
		
		Scope scope = new Scope(); 
		Expression parsiiExpr;
		if(StringUtils.contains(exp, "||")){
			String[] exps = StringUtils.split(exp,"||");
			if(StringUtils.isNotEmpty(type)){
				exp = exps[1];
			}else {
				exp = exps[0];
			}
		}
		try {
			Set<String> parse = parse(exp);
			Double val=0d;
			for (String string : parse) {
				Jedis redis = RedisUtils.getRedis();
				try {
					if(StringUtils.isEmpty(time)){
						time = "station.last";
					}
					String station = string.substring(1)+".";
//						String lastData = redis.get(station+time);
					String lastData = RedisTest.get(station+time);
					if(StringUtils.isNotEmpty(lastData)){
						JSONObject json = JSONObject.parseObject(lastData);
						if(StringUtils.isNotEmpty(type)){
							val = NumberUtils.toDouble(json.getString("pm10"));
						}else{
							val = NumberUtils.toDouble(json.getString("pm2_5"));
						}
						scope.getVariable(string).setValue(val);  
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally{
					RedisUtils.close(redis);
				}
			}
			parsiiExpr = Parser.parse(exp,scope);
			scope.getVariable("mydata").setValue(NumberUtils.toDouble(value));
			if(values.get("average"+type)!=null)
			scope.getVariable("average").setValue(values.get("average"+type));  
			if(values.get("zhigong"+type)!=null)
			scope.getVariable("zhigong").setValue(values.get("zhigong"+type)); 
			if(values.get("lanlian"+type)!=null)  
			scope.getVariable("lanlian").setValue(values.get("lanlian"+type));  
			if(values.get("shengwu"+type)!=null) 
			scope.getVariable("shengwu").setValue(values.get("shengwu"+type));  
			if(values.get("tielu"+type)!=null) 
			scope.getVariable("tielu").setValue(values.get("tielu"+type));  
		  
			// evaluate  
			double result = parsiiExpr.evaluate();  
			return String.valueOf(Math.round(result));
		} catch (parsii.tokenizer.ParseException e) {
			e.printStackTrace();
		}  
		return null;
	}
	public static Set<String> parse(String a) {
		Set<String> set = new HashSet<String>();
		StringBuffer sb = new StringBuffer();
		if(a.indexOf("V")!=-1){
			a = a.substring(a.indexOf("V"));
			String[] arr = a.split("V");
			if (arr.length <= 1) {
				return null;
			}
			sb.append("V");
			for (String b : arr) {
				for (int i = 0; i < b.length(); i++) {
					char c = b.charAt(i);
					if ((c >= 48 && c <= 57) || c == 65) {
						sb.append(c);
						if(i==b.length()-1){
							set.add(sb.toString());
							sb = new StringBuffer();
							sb.append("V");
						}
					} else {
						set.add(sb.toString());
						sb = new StringBuffer();
						sb.append("V");
						break;
					}
				}
			}
		}
		return set;
	}
}
