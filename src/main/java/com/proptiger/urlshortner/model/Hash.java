package com.proptiger.urlshortner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hash", schema = "url")
public class Hash {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	int id;
	
	@Column(name = "hash")
	int hash;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}
	
}
