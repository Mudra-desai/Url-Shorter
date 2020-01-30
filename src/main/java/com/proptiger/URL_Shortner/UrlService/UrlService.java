package com.proptiger.URL_Shortner.UrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proptiger.URL_Shortner.dao.LongUrlDao;
import com.proptiger.URL_Shortner.dao.ShortUrlDao;
import com.proptiger.URL_Shortner.model.LongUrl;
import com.proptiger.URL_Shortner.model.ShortUrl;

@Service
public class UrlService {



	@Autowired
	private  ShortUrlDao shortUrlDao;
	
	@Autowired
	private LongUrlDao longUrlDao;
	
	private IDConverter Id = new IDConverter();

	public String createLongUrl(LongUrl longUrl) {
		
		LongUrl longUrlPresent	= longUrlDao.findByLongUrl(longUrl.getLongUrl());
		
		if(longUrlPresent!=null) {
			return shortUrlDao.findByLongUrl(longUrlPresent).getShortUrl();
		}
		/*
		 * if(shortUrlDao.findByLongUrl(longUrl.getLongUrl())!=null) { return
		 * shortUrlDao.findByLongUrl(longUrl.getLongUrl()).getShortUrl(); }// //
		 * System.out.println("c");
		 */
		
	else {	 
	
			
				longUrl = longUrlDao.save(longUrl);
					//System.out.println(longUrl.getLongUrl());
				ShortUrl shortUrl = new ShortUrl();
				StringBuilder urlCreated = new StringBuilder(Id.createID(longUrl.getId()));
				shortUrl.setShortUrl(urlCreated.toString());
				shortUrl.setLongUrl(longUrl);
				shortUrlDao.save(shortUrl);
				return  urlCreated.toString();
	}
	}
	
	public String getLongUrl(String shortUrl) {
		 ShortUrl shortUrlObject = shortUrlDao.findByShortUrl(shortUrl);
		LongUrl longUrl = shortUrlObject.getLongUrl();
		return longUrl.getLongUrl();
	}



}
