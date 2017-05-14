package com.erm.integralwall.core.params;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.erm.integralwall.core.Constant;

/**
 * 作者：liemng on 2017/3/31
 * 邮箱：859686819@qq.com
 */

import android.content.Context;
import android.text.TextUtils;

/**用于合成网络请求头信息**/
public class FormParams {

    private PhoneSysConfig mPhoneInfo;

    public FormParams(Context application){
        mPhoneInfo = new PhoneSysConfig(application);
    }
    
    /**
     * 获取广告列表所需的部分参数
     * @return
     */
    public Map<String, String> getAdsListParamsMap(String other){
		HashMap<String,String> map = new HashMap<String, String>();
		map.put(Constant.ADP_CODE, Constant.APP_CODE);
		map.put(Constant.IMEI, mPhoneInfo.getPhoneIMEI());
		map.put(Constant.IP, mPhoneInfo.getIPAddress());
		map.put(Constant.SDK_VERSION, Constant.SDK_VERSION_CODE);
		map.put(Constant.IMSI, mPhoneInfo.getPhoneIMSI());
		map.put(Constant.ANDROID_ID, mPhoneInfo.getPhoneID());
		map.put(Constant.SYSTEM_VERSION, mPhoneInfo.getPhoneVersion());
		map.put(Constant.MODEL, mPhoneInfo.getPhoneModels());
		map.put(Constant.MAC, mPhoneInfo.getPhoneMAC());
		map.put(Constant.OPERATOR, mPhoneInfo.getOperators());
		map.put(Constant.NETTYPE, mPhoneInfo.getNetWorkType());
		map.put(Constant.BRAND, mPhoneInfo.getPhoneBrand());
		map.put(Constant.RESOLUTION, mPhoneInfo.getResolution());
		map.put(Constant.OTHER, TextUtils.isEmpty(other) ? "ArMn" : other);
		
		//--- 'false' get all install package, but not system app.
		map.put(Constant.PACKAGE, mPhoneInfo.getAllAppsPackage(false));
        return map;
    }
    
    /**
     * 获取基础手机参数.
     * @return
     */
    public Map<String, String> getBaseParamsMap(){
    	HashMap<String,String> map = new HashMap<String, String>();
		map.put(Constant.ADP_CODE, Constant.APP_CODE);
		map.put(Constant.IMEI,mPhoneInfo.getPhoneIMEI());
		return map;
    }
    
    /**
     * 获取广告详情所需的部分参数
     * @return
     */
    public Map<String, String> getAdsDetailParamsMap(){
		HashMap<String,String> map = new HashMap<String, String>();
		map.put(Constant.ADP_CODE, Constant.APP_CODE);
		map.put(Constant.IMEI, mPhoneInfo.getPhoneIMEI());
		
		//---get all install package, but not system app.
		map.put(Constant.PACKAGE, mPhoneInfo.getAllAppsPackage(false));
		
        return map;
    }

    public JSONObject createJsonObj(String[] _param, String[] _values) {
        JSONObject jsonObj = new JSONObject();
        try {
            for (int i = 0; i < _param.length; i++) {
                jsonObj.put(_param[i], _values[i]);
            }
        } catch (Exception e) {
            return null;
        }
        return jsonObj;
    }

    /**
     * 生成json
     * @param _param
     * @param _values
     * @return 返回String对象
     */
    public String createJsonObj2String(String[] _param, Object[] _values) {
        JSONObject jsonObj = new JSONObject();
        try {
            for (int i = 0; i < _param.length; i++) {
                jsonObj.put(_param[i], _values[i]);
            }
        } catch (Exception e) {
            return null;
        }
        return jsonObj.toString();
    }
}
