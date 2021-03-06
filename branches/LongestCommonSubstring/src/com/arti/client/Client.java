package com.arti.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Client {
	
	public static void main(String[] args) throws Exception {

		Client http = new Client();
		System.out.println("\nSending Http POST requests");
		http.sendPost(TestScript.requestJsonStringNullOrEmpty);
		http.sendPost(TestScript.requestJsonStringDuplicate);
		http.sendPost(TestScript.requestJsonStringInvalidJson);
		http.sendPost(TestScript.requestJsonStringNoValues);
		http.sendPost(TestScript.requestJsonStringValid);
		http.sendPost(TestScript.requestJsonStringValidMultipleLCS);
	}
	
	// HTTP POST request
	private void sendPost(String jsonLCSString) throws Exception {
		String url = "http://localhost:8080/LongestCommonSubstring/rest/lcs";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(jsonLCSString);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		System.out.println("Response Message : " + con.getResponseMessage());
		

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
	}
}
