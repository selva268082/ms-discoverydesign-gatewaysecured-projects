package com.employee.util;

import java.net.URL;

import org.springframework.core.io.ClassPathResource;

public class GetPathUtil {
	
	
	 public static URL getUrl(String urlPath) {
		return  ClassPathResource.class.getResource(urlPath);
	}

}
