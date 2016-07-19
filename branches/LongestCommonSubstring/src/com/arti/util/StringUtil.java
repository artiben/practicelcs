package com.arti.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StringUtil {
	
	public static boolean isJSONValid(String test) {
	    try {
	        new JSONObject(test);
	    } catch (JSONException ex) {
	        try {
	            new JSONArray(test);
	        } catch (JSONException ex1) {
	            return false;
	        }
	    }
	    return true;
	}

	public static List<String> getSetOfString(String requestJsonString) {
		JsonElement jelement = new JsonParser().parse(requestJsonString);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonArray("setOfStrings");
		List<String> stringValues = new ArrayList<String>(); 
		for (JsonElement jElem : jarray) {
			jobject = jElem.getAsJsonObject();
			String value = jobject.get("value").toString();
			stringValues.add(value.substring(1, value.length()-1));
		}
		return stringValues;		
	}
	
	public static String getMinLengthString(Set<String> stringValuesSet) {
		int minLengthString = 0;
		String minLength = null;
		for (String string : stringValuesSet) {
			if (string.length() < minLengthString)
				minLengthString = string.length();
				minLength = string;
		}
		return minLength;
	}
	
	public static int getMaxLengthString(Set<String> stringValuesSet) {
		int maxLengthString = 0;
		String maxLength = null;
		for (String string : stringValuesSet) {
			if (string.length() > maxLengthString) {
				maxLengthString = string.length();
				maxLength = string;
			}
		}
		return maxLength.length();
	}
	
	public static List<String> getMaxLengthStrings(int maxLength, Set<String> stringValuesSet) {
		List<String> maxLengthStringList = new ArrayList<String>();
		for (String string : stringValuesSet) {
			if (string.length() == maxLength) {
				maxLengthStringList.add(string);
			}
		}
		Collections.sort(maxLengthStringList);
		return maxLengthStringList;
	}

	
	public static boolean isStringToCompareInSet(Set<String> stringValuesSet, String stringToCompare) {
		for (String string : stringValuesSet) {
			if (!string.contains(stringToCompare)) {
				return false;
			}
		}
		return true;
	}
}
