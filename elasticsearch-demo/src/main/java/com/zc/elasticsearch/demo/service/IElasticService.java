package com.zc.elasticsearch.demo.service;

import com.zc.elasticsearch.demo.domain.Book;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;

public interface IElasticService {
    void createIndex();
    void deleteIndex(String index);
    void save(Book docBean);
    void saveAll(List<Book> list);
    Iterator<Book> findAll();
    Page<Book> findByContent(String content);
    Page<Book> findByFirstCode(String firstCode);
    Page<Book> findBySecordCode(String secordCode);
    Page<Book> query(String key);
}
