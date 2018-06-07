package com.jack.elasticsearch.repository;


import com.jack.elasticsearch.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author yangyueming
 */

//泛型的参数分别是实体类型和主键类型
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {

}