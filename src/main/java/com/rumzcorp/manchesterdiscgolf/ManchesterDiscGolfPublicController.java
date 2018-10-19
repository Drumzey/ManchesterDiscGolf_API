package com.rumzcorp.manchesterdiscgolf;

import com.rumzcorp.manchesterdiscgolf.NewsRepository;
import com.rumzcorp.manchesterdiscgolf.classes.Meetup;
import com.rumzcorp.manchesterdiscgolf.classes.News;
import com.rumzcorp.manchesterdiscgolf.MeetupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class ManchesterDiscGolfPublicController {

	@Autowired
    private NewsRepository newsRepo;
	
	@Autowired
    private MeetupRepository meetupRepo;
	
	@RequestMapping("/hello")
    public String hello()
    {
        return "Hello from manchester disc golf";
    }
	
	@RequestMapping("/news/get")
	public List<News> getNews()
	{
		Date now = new Date();
		List<News> news = newsRepo.findByValidUntilGreaterThanEqualOrderByCreatedOnDesc(now);
		
		return news;
	}
	
	@RequestMapping("/meetup/get")
	public List<Meetup> getMeetup(@RequestParam(value="day", required=true) int day)
	{
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, day);
		dt = c.getTime();
		try {
			Date dateWithZeroTime = formatter.parse(formatter.format(dt));
			List<Meetup> meetups = meetupRepo.findByDate(dateWithZeroTime);			
			return meetups;
		} catch (ParseException e) {
			return null;
		}			
	}
	
	@RequestMapping("/meetup/post")
	public Meetup postMeetup(@RequestParam(value="name", required=true) String name,
								   @RequestParam(value="date", required=true) int date,
								   @RequestParam(value="time", required=true) String time,
								   @RequestParam(value="type", required=false) String type)
	{		
		Meetup m = new Meetup();
		m.setName(name);
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");		
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, date);
		dt = c.getTime();
		try {
			Date dateWithZeroTime = formatter.parse(formatter.format(dt));
			m.setDate(dateWithZeroTime);
		} catch (ParseException e) {
			return null;
		}		
		
		m.setTime(time);
		if(type != null)
		{
			m.setRoundType(type);
		}
		else
		{
			m.setRoundType("none");		
		}
		
		meetupRepo.save(m);		
		return m;
	}
	
	@RequestMapping("/meetup/remove")
	public Long postMeetup(@RequestParam(value="name", required=true) String name,
								   @RequestParam(value="date", required=true) int date)
	{
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");		
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, date);
		dt = c.getTime();
		try {
			Date dateWithZeroTime = formatter.parse(formatter.format(dt));
			return meetupRepo.deleteMeetupByNameAndDate(name, dateWithZeroTime);
		} catch (ParseException e) {
			return null;
		}		
	}
	
}
