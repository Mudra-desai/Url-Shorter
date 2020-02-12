package com.proptiger.urlshortner.controller;

import java.text.ParseException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proptiger.urlshortner.exception.ProApiException;
import com.proptiger.urlshortner.model.LongUrl;
import com.proptiger.urlshortner.response.ApiWrapper;
import com.proptiger.urlshortner.service.UrlService;

@Controller
public class UrlController {

	@Autowired
	private UrlService urlService;

	@RequestMapping(value = "/ping")
	@ResponseBody
	public ApiWrapper ping() {
		return new ApiWrapper("Pong");
	}

	@RequestMapping(value = "url", method = RequestMethod.POST)
	@ResponseBody
	public ApiWrapper createUrl(@RequestBody LongUrl Url) throws ParseException {
		String returnUrl = urlService.createLongUrl(Url);
		return new ApiWrapper(Collections.singletonMap("short-url","http://shortUrl/="+returnUrl));
	}

	
	@RequestMapping(value = "url", method = RequestMethod.GET/* , produces = MediaType.APPLICATION_JSON_VALUE */)
	@ResponseBody
	public ApiWrapper getLongUrl(@RequestParam(required = true) String shortUrl) throws ProApiException {
		String longUrlReturn = urlService.getLongUrl(shortUrl);
		if(longUrlReturn.contentEquals("abc")){
			throw new ProApiException();
		}
		return new ApiWrapper(Collections.singletonMap("long-url", longUrlReturn));
		
			//return new ApiWrapper("Error", "404");
		

	}
	
	@RequestMapping(value = "url/daily-report", method = RequestMethod.GET)
	@ResponseBody
	public ApiWrapper getUrlCreated(@RequestParam(required=true) String startDate, @RequestParam(required = true) String endDate) throws Exception {
		int urlCount = urlService.getCountOfUrlCreated(startDate,endDate);
		return new ApiWrapper(Collections.singletonMap("Daily-Count", urlCount));
		
	}
	

}
