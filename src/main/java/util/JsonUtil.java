package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtil {
	public static final SerializerFeature[] features = { SerializerFeature.PrettyFormat };

	/**
	 * 还原成对象list
	 * 
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> JsonToObjectList(String jsonString, Class<T> clazz) {
		try {
			if (StringUtil.isNull(jsonString)) {
				return new ArrayList<T>();
			} else {
				if (null == JSONArray.parseArray(jsonString, clazz)) {
					return new ArrayList<T>();
				} else {
					return JSONArray.parseArray(jsonString, clazz);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 返回对应对象
	 * 
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static <T> T JsonToObject(String jsonString, Class<T> clazz) {
		try {
			if (StringUtil.isNull(jsonString)) {
				return null;
			} else {
				if (JSON.parseObject(jsonString, clazz) != null) {
					return JSON.parseObject(jsonString, clazz);
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 返回map类型的对�?
	 * 
	 * @param jsonString
	 * @param clazz1
	 * @param clazz2
	 * @return
	 */
	public static <K, V> Map<K, V> JsonToObjectMap(String jsonString,
			Class<K> clazz1, Class<V> clazz2) {
		if (StringUtil.isNull(jsonString)) {
			return null;
		}
		Map<K, V> map = null, result = new HashMap<K, V>();
		try {
			map = JSON.parseObject(jsonString, new TypeReference<Map<K, V>>() {
			});
			for (K k : map.keySet()) {
				String ks = k.toString();
				String vs = map.get(k).toString();
				V nv = JSON.parseObject(vs, clazz2);
				K kv = JSON.parseObject(ks, clazz1);
				result.put(kv, nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 将对象编程字符串
	 * 
	 * @param clazz
	 * @return
	 */
	public static String ObjectToJson(Object obj) {
		if (obj == null) {
			return "";
		}
		return JSON.toJSONString(obj);
	}
}
