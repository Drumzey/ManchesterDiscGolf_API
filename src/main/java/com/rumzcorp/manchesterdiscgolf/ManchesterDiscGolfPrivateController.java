package com.rumzcorp.manchesterdiscgolf;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rumzcorp.manchesterdiscgolf.classes.News;
import com.rumzcorp.manchesterdiscgolf.classes.UploadNews;

@RestController
public class ManchesterDiscGolfPrivateController {

	@Autowired
    private NewsRepository newsRepo;
	
	@RequestMapping("/news/add")
    public News addNews(@RequestBody UploadNews data)
    {
        Date date = new Date();        
        News n = new News();        
        n.setTitle(data.getTitle());
        n.setBody(data.getBody());
        n.setCreatedOn(date);        
        n.setValidUntil(data.getValidUntil());        
        newsRepo.save(n);        
        return n;
    }
	
}
