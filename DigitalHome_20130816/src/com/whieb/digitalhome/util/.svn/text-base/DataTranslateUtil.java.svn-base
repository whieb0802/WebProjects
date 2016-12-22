package com.whieb.digitalhome.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.duineframework.recommender.profile.itemsimilarity.ItemSimilarity;
import org.springframework.stereotype.Component;

import com.whieb.digitalhome.model.Connection;
import com.whieb.digitalhome.model.Item;

@Component
public class DataTranslateUtil {

	public JSONObject conToJson(List<Connection> con ,List<Item> item) {
		JSONObject json = new JSONObject();
		for(int i=0;i<con.size();i++){
			json.element(trans(i*3+0), item.get(i).getKey());
			json.element(trans(i*3+1), item.get(i).getTitle());
			json.element(trans(i*3+2), con.get(i).getConfidence());
		}
		return json;
	}
	public JSONObject conToJson2(List<ItemSimilarity> itemSimilarities ,List<Item> item) {
		JSONObject json = new JSONObject();
		for(int i=0;i<itemSimilarities.size();i++){
			json.element(trans(i*3+0), item.get(i).getKey());
			json.element(trans(i*3+1), item.get(i).getTitle());
			json.element(trans(i*3+2), itemSimilarities.get(i).getSimilarity());
		}
		return json;
	}
	
	public JSONObject itemToJson(List<Item> item){
		JSONObject json = new JSONObject();
		for(int i=0;i<item.size();i++){
			json.element(trans(i*2+0), item.get(i).getKey());
			json.element(trans(i*2+1), item.get(i).getTitle());
		}
		return json;
	}
	
   private  String trans(int k){
	   String num = "a"+ k ;
	   return num.substring(1);
   }

public JSONObject contentToJson(Map<Integer, String> content) {
	JSONObject json = new JSONObject();
	int i=0;
	Set<Map.Entry<Integer, String>> set = content.entrySet();
	 for (Iterator<Map.Entry<Integer, String>> it = set.iterator(); it.hasNext();) {
         Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) it.next();
         json.element(trans(i), entry.getKey());
         json.element(trans(i+1), entry.getValue());
         i=i+2;
        }
	 return json;
  }

public List<Integer> jsonToSequence(JSONObject jsonObj) {
	List<Integer> sequence = new ArrayList<Integer>();
	int total = jsonObj.size();
	System.out.println(total);
	for(int i=0;i<total;i++){
		sequence.add(jsonObj.getInt(trans(i+1)));
	}
	return sequence;
}

public JSONObject sequenceToJson(String[] message) {
	JSONObject json = new JSONObject();
	if(message == null){
		json.element("0", 0);
	}
	else {
		for(int i=0;i<message.length;i++)
			json.element(trans(i), message[i]);
	}
	return json;
}

public JSONObject allItemToJson(List<Item> item) {
	JSONObject json = new JSONObject();
	if(item != null){
	 for(int i=0;i<item.size();i++){
		json.element(trans(i*3+0), item.get(i).getKey());
		json.element(trans(i*3+1), item.get(i).getTitle());
		json.element(trans(i*3+2), item.get(i).getType());
	 }
	}
	else {
		json.element("0", "0");
	}
	return json;
}
}
