package com.proptiger.URL_Shortner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proptiger.URL_Shortner.UrlService.UrlService;
import com.proptiger.URL_Shortner.model.LongUrl;
import com.proptiger.URL_Shortner.model.ShortUrl;

@Controller
public class UrlController {

	@Autowired
	private UrlService urlService;

	@RequestMapping(value = "/ping")
	@ResponseBody
	public String ping() {
		return "Pong";
	}

	@RequestMapping(value = "url/", method = RequestMethod.POST)
	@ResponseBody
	public ShortUrl createUrl(@RequestBody LongUrl Url) {
		return urlService.createLongUrl(Url);
	}

	
	  @RequestMapping(value = "url/Id", method = RequestMethod.GET)
	  @ResponseBody public String getLongUrl(@RequestParam(required = true) String
	  shortUrl){ return urlService.getLongUrl(shortUrl); }
	 

}
