package com.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class FileUtils {

//To fetch the request endpoint from

	public String getEndpoint(String endPointName) {
		try {
			FileReader reader = new FileReader("src/main/resources/endpoint.properties");
			Properties p = new Properties();
			p.load(reader);
			return p.getProperty(endPointName);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}

//To convert json file to string
	public String jsonToString(String fileName) {
		try {
			FileReader reader = new FileReader(
					System.getProperty("user.dir") + "src/main/resource/JsonRequestData/" + fileName + ".json");
			String jsonFinal = "";
			BufferedReader br = new BufferedReader(reader);
			String jsonString;
			while ((jsonString = br.readLine()) != null) {
				jsonFinal += jsonString;
			}
			reader.close();
			br.close();
			return jsonFinal; 

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}
	
	//To fetch the response from response.properties
	public String jsonPathPropertyFileReader(String tagName) {
		
		try {
			FileReader reader=new FileReader(System.getProperty("user.dir") + "src/main/resource/response.properties");
			Properties p = new Properties();
			p.load(reader);
			return p.getProperty(tagName);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
