package com.proptiger.URL_Shortner.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Short_Url", schema = "Url")

public class ShortUrl {

	@Id
	@GeneratedValue
	@Column(name = "id")
	long id;
	
	
	@Column(name = "short_url")
	String shortUrl;
	

	@OneToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "Long_Url_Id")
	LongUrl longUrl;

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getShortUrl() {
		return shortUrl;
	}



	public void setLongUrl(LongUrl longUrl) {
		this.longUrl = longUrl;
	}


	public void setShortUrl(String string) {
		// TODO Auto-g
		this.shortUrl = string;
	}


	public LongUrl getLongUrl() {
		// TODO Auto-generated method stub
		return this.longUrl;
	}
	




	
	
}
