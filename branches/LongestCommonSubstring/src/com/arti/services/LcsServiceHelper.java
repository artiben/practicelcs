package com.arti.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.arti.util.StringUtil;

public class LcsServiceHelper {
	
	public String findLCS(Set<String> stringValuesSet) {
		String minLengthString = StringUtil.getMinLengthString(stringValuesSet);
		Set<String> maxSubStringSet = new HashSet<String>();
		
		for(int i = 1; i < minLengthString.length(); i++) {
			String stringToCompare = minLengthString.substring(i);
			if(StringUtil.isStringToCompareInSet(stringValuesSet, stringToCompare)) {
				//maxSubString = stringToCompare;
				maxSubStringSet.add(stringToCompare);
			}
		}
		
		for(int i = 1; i < minLengthString.length(); i++) {
			String stringToCompare = minLengthString.substring(0, minLengthString.length() - i);
			if(StringUtil.isStringToCompareInSet(stringValuesSet, stringToCompare)) {
				//if (maxSubString.length() <= stringToCompare.length()) {
					//maxSubString = stringToCompare;
					maxSubStringSet.add(stringToCompare);
				//}
			}
		}
		int maxLength = StringUtil.getMaxLengthString(maxSubStringSet);
		List<String> list = StringUtil.getMaxLengthStrings(maxLength, maxSubStringSet);
		StringBuilder sb = new StringBuilder();
		sb.append("{\"lcs\" : [");
		int listSize = list.size();
		for (int i = 0; i < listSize; i++) {
			sb.append("{\"value\" : \"" + list.get(i) + "\"}");
			if (listSize > 1 && i != listSize - 1) {
				sb.append(",");
			}
		}
		sb.append("]}");
		return sb.toString();
	}


}
