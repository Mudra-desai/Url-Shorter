package com.proptiger.urlshortner.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proptiger.urlshortner.model.ShortUrl;

public interface ShortUrlDao extends JpaRepository<ShortUrl, Long> {
	


	public ShortUrl findByShortUrl(String shortUrl);

	@Query(value = "select short_url from url.short_url where long_url_id=?1", nativeQuery = true)
	public String findLongUrlId(long id);
	
//	long findById(LongUrl longUrl);
}
