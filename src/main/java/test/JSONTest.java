package test;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.SourceTree;
import model.Word;
//import org.json.JSONArray;
//import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/12.
 */
public class JSONTest {
    public static void main(String[] args) {
       /* // 1.json.org
        String jsonString = "{\"k1\":\"v1\",\"k2\":2,\"k3\":null}";
        JSONObject jsonObject = new JSONObject(jsonString);
        System.out.println(jsonObject.get("k3"));
        System.out.println(jsonObject.toString(4));

        Word word = new Word(1,"english","中文");
        JSONObject jsonObject1 = new JSONObject(word);
        System.out.println(jsonObject1.toString(4));

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(true);
        jsonArray.put(123);
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject1);
        System.out.println(jsonArray.toString(4));

        Map<String,Object> map= new HashMap<>();
        map.put("k1", jsonObject);
        map.put("k2", jsonObject1);
        map.put("k3", jsonArray);
        JSONObject jsonObject2 = new JSONObject(map);
        System.out.println(jsonObject2.toString(4));

        List<Object> list = new ArrayList<>();
        list.add("string");
        list.add(123);
        list.add(true);
        list.add(word);
        list.add(jsonObject);
        list.add(jsonArray);
        System.out.println(new JSONArray(list).toString(4));*/

     /*// 2.jackson
     ObjectMapper objectMapper = new ObjectMapper();
     objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true); //格式化
     Word word = new Word(1,"english","中文");
     List<Object>list=new ArrayList<>();
     list.add("string");
     list.add(123);
     list.add(null);
     list.add(word);
     Map<String,Object>map=new HashMap<>();
     map.put("k1",false);
     map.put("k2",list);
     try {
      String json=objectMapper.writeValueAsString(word);// 1 object -> json字符串
      System.out.println(json);
      Word newWord = objectMapper.readValue(json, Word.class); // 2 json字符串 -> object
      System.out.println(newWord.getChinese());
     } catch (JsonProcessingException e) {
      e.printStackTrace();
     } catch (IOException e) {
      e.printStackTrace();
     }*/
   /*//3.gson
     Word word = new Word(1,"english","中文");
     Gson gson = new GsonBuilder().setPrettyPrinting().create();
     String json = gson.toJson(word);  // 1 object -> json字符串
     System.out.println(json);

     Word newWord = gson.fromJson(json,Word.class);  // 2 json字符串 -> object
     System.out.println(newWord.getChinese());*/

     /*//4.fastjson
     Word word = new Word(1,"english","中文");
     String json= JSON.toJSONString(word);
     System.out.println(json);

     Word newWord =JSON.parseObject(json,Word.class);
     System.out.println(newWord.getChinese());*/


    }
}
