package com.jack.elasticsearch.controller;

import com.jack.elasticsearch.domain.Book;
import com.jack.elasticsearch.repository.BookElasticsearchRepository;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author yangyueming
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookElasticsearchRepository bookElasticsearchRepository;

	/**
     * 1、查  id
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookElasticsearchRepository.findById(id).get();
    }


    //查询
    @GetMapping("/findAll")
    public Iterable<Book> findAll() {
        return bookElasticsearchRepository.findAll();
    }

    /**
     * 2、查  ++:全文检索（根据整个实体的所有属性，可能结果为0个）
     *
     * @param q
     * @return
     */
    @GetMapping("/select/{q}")
    public List<Book> testSearch(@PathVariable String q) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(q);
        Iterable<Book> searchResult = bookElasticsearchRepository.search(builder);
        Iterator<Book> iterator = searchResult.iterator();
        List<Book> list = new ArrayList<Book>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

//	/**
//	 * 3、查   +++：分页、分数、分域（结果一个也不少）
//	 * @param page
//	 * @param size
//	 * @param q
//	 * @return
//	 * @return
//	 */
//	@GetMapping("/{page}/{size}/{q}")
//	public List<Book> searchCity(@PathVariable Integer page, @PathVariable Integer size, @PathVariable String q) {
//
//		// 分页参数
//		Pageable pageable = new PageRequest(page, size);
//
//		// 分数，并自动按分排序
//		FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
//				.add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("name", q)),
//						ScoreFunctionBuilders.weightFactorFunction(1000)) // 权重：name 1000分
//				.add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("message", q)),
//						ScoreFunctionBuilders.weightFactorFunction(100)); // 权重：message 100分
//
//		// 分数、分页
//		SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(pageable)
//				.withQuery(functionScoreQueryBuilder).build();
//
//		Page<Book> searchPageResults = bookElasticsearchRepository.search(searchQuery);
//		return searchPageResults.getContent();
//
//	}


    @PostMapping("/insert")
    public Book insertBook(@RequestParam("id") Long id, @RequestParam("name") String name,
                           @RequestParam("message") String message) {
        Book book = new Book();
        book.setId(id);
        book.setMessage(message);
        book.setName(name);
        Book book1 = bookElasticsearchRepository.save(book);
        return book1;
    }

    /**
     * 5、删 id
     * @param id
     * @return
     */
	@PostMapping("/delete")
	public void insertBook(@RequestParam("id") Long id) {
		bookElasticsearchRepository.deleteById(id);
	}

    /**
     * 6、改
     *
     * @param book
     * @return
     */
    @PutMapping("/update")
    public Book updateBook(Book book) {
        bookElasticsearchRepository.save(book);
        return book;
    }

}
