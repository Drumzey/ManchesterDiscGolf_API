package com.rumzcorp.manchesterdiscgolf;

import com.rumzcorp.manchesterdiscgolf.classes.News;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by richard.rumsey on 15/02/2017.
 */

//@RepositoryRestResource
public interface NewsRepository extends CrudRepository<News, String>
{
	List<News> findByValidUntilGreaterThanEqualOrderByCreatedOnDesc(Date date);
}