package com.jack.elasticsearch.repository;

import com.jack.elasticsearch.domain.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author yangyueming
 */
public interface BookElasticsearchRepository extends ElasticsearchRepository<Book,Long> {

}
