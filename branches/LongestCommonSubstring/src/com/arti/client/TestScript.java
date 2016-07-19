package com.arti.client;

public class TestScript {
	public static String requestJsonStringNullOrEmpty = "  ";
	public static String requestJsonStringDuplicate = "{\"setOfStrings\" : [ {\"value\" : \"sungard\"}, {\"value\" : \"sungard\"}, {\"value\" : \"sungarder\"}, {\"value\" : \"garden\"}]}";
	public static String requestJsonStringNoValues = "{\"setOfStrings\" : [ {\"value\" : \"\"}, {\"value\" : \"\"}, {\"value\" : \"\"}, {\"value\" : \"\"}]}";
	public static String requestJsonStringInvalidJson = "{\"setOfStrings\" : [ \"value\" : \"sungard\"}, {\"value\" : \"sungard\"}, {\"value\" : \"sungarder\"}, {\"value\" : \"garden\"}]}";
	public static String requestJsonStringValid = "{\"setOfStrings\" : [ {\"value\" : \"sungard\"}, {\"value\" : \"sungarder\"}, {\"value\" : \"garden\"}]}";
	public static String requestJsonStringValidMultipleLCS = "{\"setOfStrings\" : [ {\"value\" : \"sunsagard\"}, {\"value\" : \"sunsbgarder\"}, {\"value\" : \"sunscgarden\"}]}";	
}
