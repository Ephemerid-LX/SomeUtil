package yfzyn.util.json;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import java.util.Map;

/**
 * Created by yfzyn on 12/1/2016.
 */
public class JsonUtilUseJsonlib{
    /**
     * 将符合条件的json字符串转换为Map
     * @param jsonStr json字符串
     * @param classMap json与java object映射
     * @return Map
     */
    public static Map<String, Object> jsonStr2Map(String jsonStr,Map<String, Class> classMap){
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setRootClass(Map.class);
        jsonConfig.setClassMap(classMap);
        return (Map<String, Object>)JSONObject.toBean(jsonObject, jsonConfig);
    }

    /**
     * 将符合条件的json字符串转化为objec
     * @param jsonStr json字符串
     * @param clazz 根类
     * @param classMap json与java object映射
     * @return Objec
     */
    public static Object jsonStr2JaveObject(String jsonStr,Class clazz ,Map<String, Class> classMap){
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setRootClass(clazz);
        jsonConfig.setClassMap(classMap);
        return JSONObject.toBean(jsonObject, jsonConfig);
    }

}
