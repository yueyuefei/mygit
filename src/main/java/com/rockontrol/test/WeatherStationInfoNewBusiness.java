package com.rockontrol.test;

import java.io.Serializable;
import java.util.List;

import com.google.gson.Gson;

/**
 * 这个Business是从web-all web-service 中导入的,所有涉及的类，不再重新创建，在本类内部创建
 * 
 * @author lvshengchao
 * @since 2016-5-20 下午3:48:10
 * 
 */
public class WeatherStationInfoNewBusiness {
	
	static Gson gson = new Gson();
	
			
	
	
	
	@SuppressWarnings("unused")
	private static class AirData{
		private String aqi24h;
		private String co24h;
		private String no224h;
		private String o324h;
		private String o38h24h;
		private String pm1024h;
		private String pm2524h;
		private String so224h;
		private String temp24h;
		private String sd24h;
		private String voc24h;
		private String hcho24h;
		private String co224h;
		
		public AirData() {
			this.aqi24h = "0";
			this.co24h = "0";
			this.no224h = "0";
			this.o324h = "0";
			this.o38h24h = "0";
			this.pm1024h = "0";
			this.pm2524h = "0";
			this.so224h = "0";
			this.temp24h = "0";
			this.sd24h = "0";
			this.voc24h = "0";
			this.hcho24h = "0";
			this.co224h = "0";
		}
	}
	
}

/**
 * 简要城市天气信息
 * @author lvshengchao
 * @since  2016-6-12 下午6:35:24
 *
 */
class TqViewMobileSimple{
	private String SD;	//当前湿度
	private String WD; 	//当前温度
	private String weather;//当前天气
	private String DQFX;   //当前风向
	private String DQFL;	//当前风力
	public String getSD() {
		return SD;
	}
	public void setSD(String sD) {
		SD = sD;
	}
	public String getWD() {
		return WD;
	}
	public void setWD(String wD) {
		WD = wD;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getDQFX() {
		return DQFX;
	}
	public void setDQFX(String dQFX) {
		DQFX = dQFX;
	}
	public String getDQFL() {
		return DQFL;
	}
	public void setDQFL(String dQFL) {
		DQFL = dQFL;
	}
	
	
}
class TqViewMobile {

	private String SD;	//当前湿度
	private String WD; 	//当前温度
	private String weather;//当前天气
	private String DQFX;   //当前风向
	private String DQFL;	//当前风力
	private String day_FX;   //白天风向 1
	private String night_FX;   //夜间风向 1
	private String day_FL;	//白天风力 1
	private String night_FL;	//夜间风力 1
	private String day_WD;	//当前最高温度 1
	private String night_WD;	//当天最低温度 1
	private String day_weather;	//白天天气 1
	private String night_weather;	//夜晚天气1
	private String sun_begin;
	private String sun_end;	
	
	private String beauty; //化妆
	private String clothes;//穿衣
	private String cold;//感冒
	private String comfort;//舒适
	private String glass;//太阳镜
	private String sports;//运动
	private String travel;//旅游
	private String uv;//紫外钱
	private String wash_car;//洗车
	
	private String beauty_desc;
	private String clothes_desc;
	private String cold_desc;
	private String comfort_desc;
	private String glass_desc;
	private String sports_desc;
	private String travel_desc;
	private String uv_desc;
	private String wash_car_desc;	
	
	private List<TqViewMobile> list;	//7天天气预报
	private List<TqViewHour> hourTqs;	//当日湿度趋势
	
	private String lastUpdateTime;
	
	public TqViewMobile() {
		super();
	}

	public TqViewMobile(String sD, String wD, String weather, String dQFX,
			String dQFL, String day_FX, String night_FX, String day_FL,
			String night_FL, String day_WD, String night_WD,
			String day_weather, String night_weather, String beauty,
			String clothes, String cold, String comfort, String glass,
			String sports, String travel, String uv, String wash_car,
			List<TqViewMobile> list) {
		super();
		SD = sD;
		WD = wD;
		this.weather = weather;
		DQFX = dQFX;
		DQFL = dQFL;
		this.day_FX = day_FX;
		this.night_FX = night_FX;
		this.day_FL = day_FL;
		this.night_FL = night_FL;
		this.day_WD = day_WD;
		this.night_WD = night_WD;
		this.day_weather = day_weather;
		this.night_weather = night_weather;
		this.beauty = beauty;
		this.clothes = clothes;
		this.cold = cold;
		this.comfort = comfort;
		this.glass = glass;
		this.sports = sports;
		this.travel = travel;
		this.uv = uv;
		this.wash_car = wash_car;
		this.list = list;
	}

	public String getSD() {
		return SD;
	}
	public void setSD(String sD) {
		SD = sD;
	}
	public String getWD() {
		return WD;
	}
	public void setWD(String wD) {
		WD = wD;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getDQFX() {
		return DQFX;
	}
	public void setDQFX(String dQFX) {
		DQFX = dQFX;
	}
	public String getDQFL() {
		return DQFL;
	}
	public void setDQFL(String dQFL) {
		DQFL = dQFL;
	}
	public String getDay_WD() {
		return day_WD;
	}
	public void setDay_WD(String day_WD) {
		this.day_WD = day_WD;
	}
	public String getNight_WD() {
		return night_WD;
	}
	public void setNight_WD(String night_WD) {
		this.night_WD = night_WD;
	}
	public String getBeauty() {
		return beauty;
	}
	public void setBeauty(String beauty) {
		this.beauty = beauty;
	}
	public String getClothes() {
		return clothes;
	}
	public void setClothes(String clothes) {
		this.clothes = clothes;
	}
	public String getCold() {
		return cold;
	}
	public void setCold(String cold) {
		this.cold = cold;
	}
	public String getComfort() {
		return comfort;
	}
	public void setComfort(String comfort) {
		this.comfort = comfort;
	}
	public String getGlass() {
		return glass;
	}
	public void setGlass(String glass) {
		this.glass = glass;
	}
	public String getSports() {
		return sports;
	}
	public void setSports(String sports) {
		this.sports = sports;
	}
	public String getTravel() {
		return travel;
	}
	public void setTravel(String travel) {
		this.travel = travel;
	}
	public String getUv() {
		return uv;
	}
	public void setUv(String uv) {
		this.uv = uv;
	}
	public String getWash_car() {
		return wash_car;
	}
	public void setWash_car(String wash_car) {
		this.wash_car = wash_car;
	}
	public List<TqViewMobile> getList() {
		return list;
	}
	public void setList(List<TqViewMobile> tqViewMobiles) {
		this.list = tqViewMobiles;
	}


	public String getDay_weather() {
		return day_weather;
	}


	public void setDay_weather(String day_weather) {
		this.day_weather = day_weather;
	}


	public String getNight_weather() {
		return night_weather;
	}


	public void setNight_weather(String night_weather) {
		this.night_weather = night_weather;
	}


	public String getDay_FX() {
		return day_FX;
	}


	public void setDay_FX(String day_FX) {
		this.day_FX = day_FX;
	}


	public String getNight_FX() {
		return night_FX;
	}


	public void setNight_FX(String night_FX) {
		this.night_FX = night_FX;
	}


	public String getDay_FL() {
		return day_FL;
	}


	public void setDay_FL(String day_FL) {
		this.day_FL = day_FL;
	}


	public String getNight_FL() {
		return night_FL;
	}


	public void setNight_FL(String night_FL) {
		this.night_FL = night_FL;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getBeauty_desc() {
		return beauty_desc;
	}

	public void setBeauty_desc(String beauty_desc) {
		this.beauty_desc = beauty_desc;
	}

	public String getClothes_desc() {
		return clothes_desc;
	}

	public void setClothes_desc(String clothes_desc) {
		this.clothes_desc = clothes_desc;
	}

	public String getCold_desc() {
		return cold_desc;
	}

	public void setCold_desc(String cold_desc) {
		this.cold_desc = cold_desc;
	}

	public String getComfort_desc() {
		return comfort_desc;
	}

	public void setComfort_desc(String comfort_desc) {
		this.comfort_desc = comfort_desc;
	}

	public String getGlass_desc() {
		return glass_desc;
	}

	public void setGlass_desc(String glass_desc) {
		this.glass_desc = glass_desc;
	}

	public String getSports_desc() {
		return sports_desc;
	}

	public void setSports_desc(String sports_desc) {
		this.sports_desc = sports_desc;
	}

	public String getTravel_desc() {
		return travel_desc;
	}

	public void setTravel_desc(String travel_desc) {
		this.travel_desc = travel_desc;
	}

	public String getUv_desc() {
		return uv_desc;
	}

	public void setUv_desc(String uv_desc) {
		this.uv_desc = uv_desc;
	}

	public String getWash_car_desc() {
		return wash_car_desc;
	}

	public void setWash_car_desc(String wash_car_desc) {
		this.wash_car_desc = wash_car_desc;
	}

	public String getSun_begin() {
		return sun_begin;
	}

	public void setSun_begin(String sun_begin) {
		this.sun_begin = sun_begin;
	}

	public String getSun_end() {
		return sun_end;
	}

	public void setSun_end(String sun_end) {
		this.sun_end = sun_end;
	}

	public List<TqViewHour> getHourTqs() {
		return hourTqs;
	}

	public void setHourTqs(List<TqViewHour> hourTqs) {
		this.hourTqs = hourTqs;
	}
}

class TqViewHour {
	private String weather;
	private String WD;
	
	public TqViewHour() {
		super();
	}
	
	
	public TqViewHour(String weather, String wD) {
		super();
		this.weather = weather;
		WD = wD;
	}


	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getWD() {
		return WD;
	}
	public void setWD(String wD) {
		WD = wD;
	}
	
}


class WeatherAirRealtimeCacheData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4993502259889243239L;
	private float aqi;
    private float co;
    private float no2;
    private float o3;
    private float pm10;
    private float pm2_5;//国标基站
    private float pm25;//自有基站
    private float so2;
    
    //24小时平均值
    private float aqi_24h;
    private float co_24h;
    private float no2_24h;
    private float o3_24h;
    private float o3_8h;
    private float o3_8h_24h;
    private float pm10_24h;
    private float pm2_5_24h;
    private float pm25_24h;
    private float so2_24h;
    
    private String quality;
    private String area;
    private String position_name;
    private String primary_pollutant;
	private String station_code;
	private String time_point;
	private String ranking;
	private String lastTime;
	
	public float getAqi() {
		return aqi;
	}
	public void setAqi(float aqi) {
		if(aqi>500){
			aqi=500;
		}
		this.aqi = aqi;
	}
	public float getCo() {
		return co;
	}
	public void setCo(float co) {
		this.co = co;
	}
	public float getNo2() {
		return no2;
	}
	public void setNo2(float no2) {
		this.no2 = no2;
	}
	public float getO3() {
		return o3;
	}
	public void setO3(float o3) {
		this.o3 = o3;
	}
	public float getPm10() {
		return pm10;
	}
	public void setPm10(float pm10) {
		this.pm10 = pm10;
	}
	public float getPm2_5() {
		return pm2_5;
	}
	public void setPm2_5(float pm2_5) {
		this.pm2_5 = pm2_5;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public float getSo2() {
		return so2;
	}
	public void setSo2(float so2) {
		this.so2 = so2;
	}
	public float getCo_24h() {
		return co_24h;
	}
	public void setCo_24h(float co_24h) {
		this.co_24h = co_24h;
	}
	public float getNo2_24h() {
		return no2_24h;
	}
	public void setNo2_24h(float no2_24h) {
		this.no2_24h = no2_24h;
	}
	public float getO3_24h() {
		return o3_24h;
	}
	public void setO3_24h(float o3_24h) {
		this.o3_24h = o3_24h;
	}
	public float getO3_8h() {
		return o3_8h;
	}
	public void setO3_8h(float o3_8h) {
		this.o3_8h = o3_8h;
	}
	public float getO3_8h_24h() {
		return o3_8h_24h;
	}
	public void setO3_8h_24h(float o3_8h_24h) {
		this.o3_8h_24h = o3_8h_24h;
	}
	public float getPm10_24h() {
		return pm10_24h;
	}
	public void setPm10_24h(float pm10_24h) {
		this.pm10_24h = pm10_24h;
	}
	public float getPm2_5_24h() {
		return pm2_5_24h;
	}
	public void setPm2_5_24h(float pm2_5_24h) {
		this.pm2_5_24h = pm2_5_24h;
	}
	public float getSo2_24h() {
		return so2_24h;
	}
	public void setSo2_24h(float so2_24h) {
		this.so2_24h = so2_24h;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getPrimary_pollutant() {
		return primary_pollutant;
	}
	public void setPrimary_pollutant(String primary_pollutant) {
		this.primary_pollutant = primary_pollutant;
	}
	public String getStation_code() {
		return station_code;
	}
	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}
	public String getTime_point() {
		return time_point;
	}
	public void setTime_point(String time_point) {
		this.time_point = time_point;
	}
	public float getAqi_24h() {
		return aqi_24h;
	}
	public void setAqi_24h(float aqi_24h) {
		if(aqi_24h>500){
			aqi_24h=500;
		}
		this.aqi_24h = aqi_24h;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public float getPm25() {
		return pm25;
	}
	public void setPm25(float pm25) {
		this.pm25 = pm25;
	}
	public float getPm25_24h() {
		return pm25_24h;
	}
	public void setPm25_24h(float pm25_24h) {
		this.pm25_24h = pm25_24h;
	}
}