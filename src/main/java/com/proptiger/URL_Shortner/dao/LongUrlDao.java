package com.proptiger.URL_Shortner.dao;


import com.proptiger.URL_Shortner.model.LongUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LongUrlDao extends JpaRepository<LongUrl, Long>{
	LongUrl findByLongUrl(String longurl);
}



