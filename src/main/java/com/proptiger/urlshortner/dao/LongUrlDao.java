package com.proptiger.urlshortner.dao;


import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proptiger.urlshortner.model.LongUrl;

public interface LongUrlDao extends JpaRepository<LongUrl, Long>{
	LongUrl findByLongUrl(String longurl);

	/*
	 * @Query(value = "select long_url from url.long_url where hash=?1", nativeQuery
	 * = true) public List<String> findByLongUrl(int hash);
	 */
	@Query(value = "select count(*) from url.long_url where date>=?1 and date<=?2", nativeQuery = true )
	List<BigInteger> findbyDate(Date startDate, Date endDate);

	@Query(value = "select * from url.long_url where hash_id=?1", nativeQuery = true)	
	List<LongUrl> findByHash(long hash_id);
}



