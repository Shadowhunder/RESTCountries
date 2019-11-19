package com.api.countrydetails.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GenericBean {

	@Value("${countries}")
	String countryURL;

	@Value("${delimiter}")
	String delimiter;

	@Value("${resources.name}")
	String resource;

	public String getUrl(String country) {
		String url = countryURL;
		if (!country.equals("all")) {

			url = url + delimiter + resource + delimiter + country;

		} else {
			url = url + delimiter + country;
		}

		return url;
	}
}
