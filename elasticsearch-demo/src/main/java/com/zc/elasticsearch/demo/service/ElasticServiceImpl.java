package com.zc.elasticsearch.demo.service;

import com.zc.elasticsearch.demo.dao.ElasticRepository;
import com.zc.elasticsearch.demo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service("elasticService")
public class ElasticServiceImpl implements IElasticService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private ElasticRepository elasticRepository;

    private Pageable pageable = PageRequest.of(0,10);
    @Override
    public void createIndex() {

    }

    @Override
    public void deleteIndex(String index) {

    }

    @Override
    public void save(Book docBean) {

    }

    @Override
    public void saveAll(List<Book> list) {

    }

    @Override
    public Iterator<Book> findAll() {
        return null;
    }

    @Override
    public Page<Book> findByContent(String content) {
        return null;
    }

    @Override
    public Page<Book> findByFirstCode(String firstCode) {
        return null;
    }

    @Override
    public Page<Book> findBySecordCode(String secordCode) {
        return null;
    }

    @Override
    public Page<Book> query(String key) {
        return null;
    }
}
