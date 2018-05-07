package com.sinet.main;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CosineUtil {

    private static Cosine cosine = new Cosine();

    private static double SIMILARITYVAL = 0.5;

    public static List<Map<String,Object>> participleCacheList ;


    public static double similarity(Map<String,Integer> participle1, Map<String,Integer> participle2){
        return cosine.similarity(participle1,participle2);
    }

    /**
     * @param string
     * @return
     * @throws Exception
     */
    public static Map<String,Integer> participle(final String string) throws Exception{
        if (string == "" && string == null) {
            throw new RuntimeException("参数异常");
        }
        if (string.length() < cosine.getK()) {
            throw new RuntimeException("文本过短");
        }
        Map<String, Integer> map = cosine.getProfile(string);
        return map;
    }

    /**
     * 加载缓存
     */
    public static void LoadCache(List<Map<String,String>> list) throws Exception {
        if (participleCacheList != null) {
            participleCacheList.clear();
            participleCacheList = null;
        }
        participleCacheList = new ArrayList<Map<String,Object>>();
        for (Map<String, String> map : list) {
            String id = objToString(map.get("id"));
            String text = map.get("text");
            try {
                Map<String, Integer> participle1 = participle(text);
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                hashMap.put("id",id);
                hashMap.put("text",participle1);
                participleCacheList.add(hashMap);
            } catch (RuntimeException e) {
                System.out.println("异常文本:" + id + ":" + text);
            }
        }
    }

    public static void LoadCache2(List<Map<String,String>> list) throws Exception {
        if (participleCacheList != null) {
            participleCacheList.clear();
            participleCacheList = null;
        }
        participleCacheList = new ArrayList<Map<String,Object>>();
        for (Map<String, String> map : list) {
            String id = objToString(map.get("id"));
            String text = map.get("text");
            String name = map.get("name");
            try {
                Map<String, Integer> participle1 = participle(text);
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                hashMap.put("id",id);
                hashMap.put("text",participle1);
                hashMap.put("name",name);
                hashMap.put("content",text);
                participleCacheList.add(hashMap);
            } catch (RuntimeException e) {
                System.out.println("异常文本:" + id + ":" + text);
            }
        }
    }

    /**
     * 清理缓存
     */
    public static void clearCache(){
        if (participleCacheList != null) {
            participleCacheList.clear();
            participleCacheList = null;
        }
    }



    /**
     * 添加缓存
     * @param map
     */
    public static void addCache(Map<String,String> map) throws Exception {
        String id = objToString(map.get("id"));
        String text = map.get("text");
        Map<String, Integer>  participle = CosineUtil.participle(text);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id",id);
        hashMap.put("text",participle);
        participleCacheList.add(hashMap);
    }

    /**
     * 添加缓存2
     * @param map
     */
    public static void addCache2(Map<String,String> map) throws Exception {
        String id = objToString(map.get("id"));
        String text = map.get("text");
        String name = map.get("name");
        Map<String, Integer>  participle = CosineUtil.participle(text);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id",id);
        hashMap.put("text",participle);
        hashMap.put("name",name);
        hashMap.put("content",text);
        participleCacheList.add(hashMap);
    }

    public static List<String> compared(String s) throws Exception {
        if (s == null || s == "") {
            return null;
        }
        Map<String, Integer> map = participle(s);
        ArrayList<String> list = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : participleCacheList) {
            Map<String, Integer> text = (Map<String, Integer>) stringObjectMap.get("text");
            double similarity = similarity(map, text);
            if (similarity >= 0.5) {
                list.add(objToString(stringObjectMap.get("id")) + ":" + similarity);
            }
        }

        return list;

    }

    /**
     * 相似值,默认0.5
     * @param SIMILARITYVAL
     */
    public static void setSIMILARITYVAL(double SIMILARITYVAL) {
        CosineUtil.SIMILARITYVAL = SIMILARITYVAL;
    }

    public static String objToString(Object obj){
        if (obj == null) {
            return null;
        }
        String result = "";
        if (obj instanceof Integer) {
            result = String.valueOf(obj);
        } else if (obj instanceof BigDecimal) {
            result = ((BigDecimal) obj).toString();
        } else if (obj instanceof Long) {
            result = String.valueOf(obj);
        } else if (obj instanceof Short) {
            result = String.valueOf(obj);
        } else if (obj instanceof Float) {
            result = String.valueOf(obj);
        } else if (obj instanceof Double) {
            result = String.valueOf(obj);
        } else if (obj instanceof Boolean) {
            result = String.valueOf(obj);
        } else if (obj instanceof String) {
            result = String.valueOf(obj);
        }
        return result;
    }

}
