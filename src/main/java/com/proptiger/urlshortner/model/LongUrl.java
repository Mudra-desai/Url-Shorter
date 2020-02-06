package com.proptiger.urlshortner.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "long_url", schema = "url")
public class LongUrl {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	long id;
	
	@Column(name = "long_url", unique = true, nullable = false  )
	String longUrl;

	@Column(name = "date")
	Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hash_id")
	Hash hash;
	




	public Hash getHash() {
		return hash;
	}

	public void setHash(Hash hash) {
		this.hash = hash;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	
	
}
