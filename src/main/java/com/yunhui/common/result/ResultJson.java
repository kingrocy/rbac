package com.yunhui.common.result;

import com.alibaba.fastjson.JSONObject;

public class ResultJson {

	public static final String KEY_CODE = "code";
	public static final String KEY_MSG = "msg";
	public static final String KEY_DATA = "data";

	public static JSONObject jsonWithResultCode(ResultCode resultCode, Object data) {
		JSONObject object = new JSONObject();
		object.put(KEY_CODE, resultCode.getCode());
		object.put(KEY_MSG, resultCode.getMessage());
		object.put(KEY_DATA, data);
		return object;
	}

	public static JSONObject jsonWithResultCode(ResultCode resultCode) {
		return jsonWithResultCode(resultCode,null);
	}

	/**
	 * 适用于结果只有一个key的情况
	 * @param key
	 * @param value
	 * @return
	 */
	public static JSONObject success(String key, Object value) {
		JSONObject object = new JSONObject();
		object.put(KEY_CODE, ResultCode.SUCCESS.getCode());
		object.put(KEY_MSG, ResultCode.SUCCESS.getMessage());

		JSONObject dataContent = new JSONObject();
		dataContent.put(key, value);
		object.put(KEY_DATA, dataContent);
		return object;
	}

	/**
	 * 适用于结果是对象(多个key)转为json的情况
	 * @param data
	 * @return
	 */
	public static JSONObject success(Object data) {
		JSONObject object = new JSONObject();
		object.put(KEY_CODE, ResultCode.SUCCESS.getCode());
		object.put(KEY_MSG, ResultCode.SUCCESS.getMessage());
		object.put(KEY_DATA, data);
		return object;
	}

	public static JSONObject success() {
		return success(null);
	}

	public static <T> JSONObject fail() {
		JSONObject object = new JSONObject();
		object.put(KEY_CODE, ResultCode.RUNTIME_EXCEPTION.getCode());
		object.put(KEY_MSG, ResultCode.RUNTIME_EXCEPTION.getMessage());
		return object;
	}

	public static <T> JSONObject fail(ResultCode resultCode) {
		JSONObject object = new JSONObject();
		object.put(KEY_CODE, resultCode.getCode());
		object.put(KEY_MSG, resultCode.getMessage());
		return object;
	}

	public static JSONObject fail(Integer resultCode, String message) {
		JSONObject object = new JSONObject();
		object.put(KEY_CODE, resultCode);
		object.put(KEY_MSG, message);
		return object;
	}

}
