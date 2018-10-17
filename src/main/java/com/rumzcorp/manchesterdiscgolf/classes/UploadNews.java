package com.rumzcorp.manchesterdiscgolf.classes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

public class UploadNews
{
    private String title;

    private String body;

    private Date validUntil;
	
    public String getTitle()
    {
    	return title;
    }
    
    public void setTitle(String title) 
    {
    	this.title = title;
    }
    
    public String getBody()
    {
    	return body;
    }
    
    public void setBody(String body) 
    {
    	this.body = body;
    }
   
    public Date getValidUntil()
    {
    	return validUntil;
    }
    
    public void setValidUntil(Date validUntil) 
    {
    	this.validUntil = validUntil;
    }
}