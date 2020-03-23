package com.delakdev.wvmanager.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Image {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String url;
    @Enumerated(EnumType.STRING)
    private Type imageType;
    
    public enum Type {
        ETHNICITY,
        FACTION,
        TEAM
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Type getImageType() {
		return imageType;
	}

	public void setImageType(Type imageType) {
		this.imageType = imageType;
	}
    
    


}
