package com.arti.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.arti.util.StringUtil;
import com.arti.util.Validate;

@Path("/lcs")
public class LcsService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getLCS(String requestJsonString) {
		Response response = new Validate().isValidJsonString(requestJsonString);
		if (response.getStatus() == 200) {
			List<String> stringValues = StringUtil.getSetOfString(requestJsonString);
			Set<String> stringValuesSet = new HashSet<String>(stringValues);
			String lcs = new LcsServiceHelper().findLCS(stringValuesSet);
			//return Response.status(200).entity(lcs).build();
			return lcs;
		} else {
			return response.getEntity().toString();
		}	
	}
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		String output = "Jersey say : " + msg;
		return Response.status(200).entity(output).build();
	}
}
