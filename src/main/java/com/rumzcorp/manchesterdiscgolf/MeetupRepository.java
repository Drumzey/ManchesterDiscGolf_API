package com.rumzcorp.manchesterdiscgolf;

import com.rumzcorp.manchesterdiscgolf.classes.Meetup;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by richard.rumsey on 15/02/2018.
 */

//@RepositoryRestResource
public interface MeetupRepository extends CrudRepository<Meetup, String>
{
	List<Meetup> findByDate(Date date);
	Meetup findOneByNameAndDate(String name, Date date);
	Long deleteMeetupByNameAndDate(String name, Date date);
}