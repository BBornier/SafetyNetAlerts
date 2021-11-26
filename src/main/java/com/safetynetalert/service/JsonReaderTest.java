package com.safetynetalert.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class JsonReaderTest {

	public JSONObject getJSonObjectFromUrl(String urlJson) throws ParseException {

		JSONObject jsonObject = new JSONObject();
		try {
			URL url = new URL(urlJson);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			
			readAndParseJsonFileFromUrl(conn, url);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
		return jsonObject;

	}

	public static void readAndParseJsonFileFromUrl(HttpURLConnection conn, URL url) throws IOException, ParseException {
		String inline = "";
		if (conn.getResponseCode() == 200) {
			Scanner scan = new Scanner(url.openStream());
			while (scan.hasNext()) {
				inline += scan.nextLine();

			}
			System.out.println("\nJSON data in string format from JsonReader class.");
			System.out.println(inline);

}
	}
	
		}
