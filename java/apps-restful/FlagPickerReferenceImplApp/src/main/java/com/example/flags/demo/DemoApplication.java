package com.example.flags.demo;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.example.flags.demo.model.Flag;
import com.example.flags.demo.service.FlagService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Value("${json.file}")
	private String jsonFile;
	
	@Autowired
	private FlagService flagService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) {
		/*
		 * if (args.length == 0) {
		 * System.out.println("Usage: java DemoApplication <json-file-name>");
		 * System.exit(1); }
		 */
		try {
			FileReader reader = new FileReader(jsonFile);
			JSONParser parser = new JSONParser();
			JSONArray jsonArr = (JSONArray) parser.parse(reader);
			int index = 0;
			while (index < jsonArr.size()) {
				JSONObject jsonObj = (JSONObject) jsonArr.get(index);
				String continent = (String)jsonObj.get("continent");
				JSONArray countriesArr = (JSONArray) jsonObj.get("countries");
				int countriesInd = 0;
				while (countriesInd < countriesArr.size()) {
					JSONObject nameFlagObj = (JSONObject)countriesArr.get(countriesInd);
					String name = (String)nameFlagObj.get("name");
					String flag = (String)nameFlagObj.get("flag");
					flagService.createFlag(new Flag(continent, name, flag));
					countriesInd++;
				}
				index++;
			}
		} catch(IOException ioex) {
			System.err.println(ioex.getMessage());
		} catch(ParseException parseex) {
			System.err.println(parseex.getMessage());
		}
	}

}
