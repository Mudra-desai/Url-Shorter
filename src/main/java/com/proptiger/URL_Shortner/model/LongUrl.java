package com.proptiger.URL_Shortner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Long_Url", schema = "Url")
public class LongUrl {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	long id;
	
	@Column(name = "long_url")
	String longUrl;

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
