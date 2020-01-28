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

	public ShortUrl createLongUrl(LongUrl longUrl) {
	//	System.out.println(longUrl.getLongUrl());
		
		longUrl = longUrlDao.save(longUrl);
		//	System.out.println(longUrl.getLongUrl());
		ShortUrl shortUrl = new ShortUrl();
		shortUrl.setShortUrl(Id.createID(longUrl.getId()));
		shortUrl.setLongUrl(longUrl);
		return shortUrlDao.save(shortUrl);
	}

	public String getLongUrl(String shortUrl) {
		long id = Id.getID(shortUrl);
		LongUrl longUrl = longUrlDao.findOne(id);
		return longUrl.getLongUrl();
	}



}
