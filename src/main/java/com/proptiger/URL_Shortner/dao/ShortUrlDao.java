package com.proptiger.URL_Shortner.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proptiger.URL_Shortner.model.LongUrl;
import com.proptiger.URL_Shortner.model.ShortUrl;

public interface ShortUrlDao extends JpaRepository<ShortUrl, Long> {
	
//	@Query("select S from ShortUrl S join fetch S.longUrl L where L.longUrl= ?1")
	public ShortUrl findByLongUrl(LongUrl longUrl);

	public ShortUrl findByShortUrl(String shortUrl);
	
//	long findById(LongUrl longUrl);
}
