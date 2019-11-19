package com.api.countrydetails.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.api.countrydetails.beans.GenericBean;
import com.api.countrydetails.exception.CountryNotFoundException;

@RestController
public class APIRestCountroller {

	@Autowired
	GenericBean genBean;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getCountriesDetails(
			@RequestParam(value = "country", required = false, defaultValue = "all") String country) {
		RestTemplate template = new RestTemplate();
		HttpStatus status = HttpStatus.NOT_FOUND;
		System.out.println(country);
		String url = genBean.getUrl(country);
		System.out.println(url);
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		if (response != null) {
			status = HttpStatus.OK;
		} else {
			throw new CountryNotFoundException("Country Not Found");
		}
		return new ResponseEntity<String>(response.getBody(), status);
	}

}
