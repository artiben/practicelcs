package com.arti.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Validate {
		
	public Response isValidJsonString(String requestJsonString) {
		if (requestJsonString == null || requestJsonString.trim().equals("")) 
			return Response.status(412).entity("Null or empty string is not allowed").type(MediaType.APPLICATION_JSON).build();
			//return Response.ok().entity("Null or empty string").type(MediaType.APPLICATION_JSON).build();
//		try {
//			JsonParser parser = new JsonParser();
//			parser.parse(requestJsonString);
//		} catch (JsonSyntaxException jse) {
//			return Response.status(412).entity("Not a valid Json String:" + jse.getMessage()).build();
//		}

		if (!StringUtil.isJSONValid(requestJsonString)) 
			return Response.status(412).entity("Not a valid Json String:").build();
				
		List<String> stringValues = StringUtil.getSetOfString(requestJsonString);
		if (stringValues == null || stringValues.isEmpty() || stringValues.contains("")) 
			return Response.status(412).entity("No String values found or Empty value found").build();
		
		Set<String> stringValuesSet = new HashSet<String>(stringValues);
		if (stringValues.size() != stringValuesSet.size())
			return Response.status(412).entity("Duplicate String values not found").build();
		
		return Response.status(200).entity("Valid JSON!").build();
	}
	
		
	
	

}