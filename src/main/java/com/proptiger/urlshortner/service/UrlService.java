package com.proptiger.urlshortner.service;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.proptiger.urlshortner.dao.HashDao;
import com.proptiger.urlshortner.dao.LongUrlDao;
import com.proptiger.urlshortner.dao.ShortUrlDao;
import com.proptiger.urlshortner.model.Hash;
import com.proptiger.urlshortner.model.LongUrl;
import com.proptiger.urlshortner.model.ShortUrl;

@Service
public class UrlService {

	@Autowired
	private ShortUrlDao shortUrlDao;

	@Autowired
	private LongUrlDao longUrlDao;
	

	@Autowired
	private HashDao hashDao;
	
	HashGenerator hashGenerator = new HashGenerator();

	public String createLongUrl(LongUrl longUrl) throws ParseException {

		// LongUrl longUrlPresent = longUrlDao.findByLongUrl(longUrl.getLongUrl());
		String longUrlString = longUrl.getLongUrl();
		int hash = HashGenerator.getHash(longUrlString);
		Hash hashObject = hashDao.findByHash(hash);
		if(hashObject!=null) {
			List<LongUrl> longUrlByHash = longUrlDao.findByHash(hashObject.getId());
			for (LongUrl s : longUrlByHash) {
				if (s.getLongUrl().contentEquals(longUrlString)) {
					return shortUrlDao.findLongUrlId(s.getId());
				}

			}
			

		}
		else {
			hashObject = new Hash();
			hashObject.setHash(hash);
			hashObject = hashDao.save(hashObject);
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = formatter.parse(formatter.format(new Date()));
		longUrl.setDate(currentDate);
		longUrl.setHash(hashObject);
		longUrl = longUrlDao.save(longUrl);
		ShortUrl shortUrl = new ShortUrl();
		StringBuilder urlCreated = new StringBuilder(IDConverter.createID(longUrl.getId()));
		shortUrl.setShortUrl(urlCreated.toString());
		shortUrl.setLongUrl(longUrl);
		shortUrlDao.save(shortUrl);
		return urlCreated.toString();

	}
	@Cacheable(value = "short", key = "#shortUrl")
	public String getLongUrl(String shortUrl) {

		ShortUrl shortUrlObject = shortUrlDao.findByShortUrl(shortUrl);
		if (shortUrlObject == null || !shortUrlObject.getShortUrl().contentEquals(shortUrl)) {
			return "Client Input Error";
		} else {
			
			LongUrl longUrl = shortUrlObject.getLongUrl();
			return longUrl.getLongUrl();
		}
	}
	
	@Cacheable(value = "date")
	public int getCountOfUrlCreated(String startDate, String endDate) throws Exception {
		Date startDateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
		Date endDateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
		List<BigInteger> urlCreated = longUrlDao.findbyDate(startDateFormat, endDateFormat);
		int returnValue = urlCreated.get(0).intValue();
		return returnValue;
	}

}
