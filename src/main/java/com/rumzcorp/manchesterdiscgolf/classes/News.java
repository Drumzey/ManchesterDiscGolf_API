package com.rumzcorp.manchesterdiscgolf.classes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "news_tbl")
public class News
{
	@Id
    @GeneratedValue
    private int id;
	
	@Column(nullable = false)
    private String title;
    
	@Column(nullable = false)
    private String body;
    
	@Column(nullable = false)
    private Date createdOn;
	
	@Column(nullable = false)
    private Date validUntil;
	
    public int getId()
    {
        return id;
    }

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
    
    public Date getCreatedOn()
    {
    	return createdOn;
    }
    
    public void setCreatedOn(Date createdOn) 
    {
    	this.createdOn = createdOn;
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
