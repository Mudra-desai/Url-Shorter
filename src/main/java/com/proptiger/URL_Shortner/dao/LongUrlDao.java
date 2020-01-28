package com.proptiger.URL_Shortner.dao;


import com.proptiger.URL_Shortner.model.LongUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LongUrlDao extends JpaRepository<LongUrl, Long>{
	/*
	 * @Query("select long_url from Long_Url where id =?") String getLongUrl(long
	 * id);
	 */
}



