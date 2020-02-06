package com.proptiger.urlshortner.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proptiger.urlshortner.model.Hash;

public interface HashDao extends JpaRepository<Hash,Integer>{

	Hash findByHash(int hash);

	
}
