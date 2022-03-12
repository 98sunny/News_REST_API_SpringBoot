package com.stackroute.newz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.newz.model.News;
import com.stackroute.newz.repository.NewsRepository;
import com.stackroute.newz.repository.UserProfileRepository;
import com.stackroute.newz.service.NewsService;
import com.stackroute.newz.util.exception.NewsAlreadyExistsException;
import com.stackroute.newz.util.exception.NewsNotExistsException;


/*
 * This class is implementing the NewsService interface. This class has to be annotated with 
 * @Service annotation.
 * @Service - is an annotation that annotates classes at the service layer, thus 
 * clarifying it's role.
 * 
 * */
@Service
public class NewsServiceImpl implements NewsService {

	/*
	 * Autowiring should be implemented for the NewsRepository.
	 */
	@Autowired
	private NewsRepository repository;

	/*
	 * Add a new news. Throw NewsAlreadyExistsException if the news with specified
	 * newsId already exists.
	 */
	@Override
	public News addNews(News news) throws NewsAlreadyExistsException{
		if(repository.getOne(news.getNewsId())!=null) {
			throw new NewsAlreadyExistsException();
		}else {
			repository.save(news);
			return news;
		}

	}

	/*
	 * Retrieve an existing news by it's newsId. Throw NewsNotExistsException if the 
	 * news with specified newsId does not exist.
	 */
	public News getNews(int newsId) throws NewsNotExistsException {
		Optional<News> news=repository.findById(newsId);
		if(news.isPresent()) {
			return news.get();
		}else {
			throw new NewsNotExistsException();
		}
//		return null;
	}

	/*
	 * Retrieve all existing news
	 */
	public List<News> getAllNews() {
		List<News> newsList=repository.findAll();
		return newsList;
	}

	
	/*
	 * Update an existing news by it's newsId. Throw NewsNotExistsException if the 
	 * news with specified newsId does not exist.
	 */
	public News updateNews(News news) throws NewsNotExistsException {
		if(repository.getOne(news.getNewsId())!=null) {
			repository.saveAndFlush(null);
			return news;
		}else {
			throw new NewsNotExistsException();		
			}
		
		
	}

	/*
	 * Delete an existing news by it's newsId. Throw NewsNotExistsException if the 
	 * news with specified newsId does not exist.
	 */
	public void deleteNews(int newsId) throws NewsNotExistsException {
		if(repository.getOne(newsId) != null) {
			repository.deleteById(newsId);
		}else {
			throw new NewsNotExistsException();
		}
	}

}
