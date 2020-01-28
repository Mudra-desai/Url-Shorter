package com.proptiger.URL_Shortner.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proptiger.URL_Shortner.model.ShortUrl;

public interface ShortUrlDao extends JpaRepository<ShortUrl, Long> {
	
	
}
