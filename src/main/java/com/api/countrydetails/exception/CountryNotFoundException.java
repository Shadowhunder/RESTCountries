package com.api.countrydetails.exception;

public class CountryNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 8380054678441686310L;

	public CountryNotFoundException() {
		super();
	}

	public CountryNotFoundException(final String message) {
		super(message);
	}

}
