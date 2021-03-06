package com.jack.elasticsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * 加上了@Document注解之后，默认情况下这个实体中所有的属性都会被建立索引、并且分词
 * @author yangyueming
 *
 */
@Document(indexName = "product2", type = "book2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
	Long id;
	String name;
	String message;
}
