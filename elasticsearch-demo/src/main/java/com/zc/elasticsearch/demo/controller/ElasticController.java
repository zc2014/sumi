package com.zc.elasticsearch.demo.controller;

import com.zc.elasticsearch.demo.domain.Book;
import com.zc.elasticsearch.demo.service.IElasticService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/elastic")
public class ElasticController {

    @Autowired
    private IElasticService elasticService;

    @GetMapping("/init")
    public void init() {
        elasticService.createIndex();
        List<Book> list = new ArrayList<>();
        list.add(new Book(100L, "代码整洁之道", "不详", 45000, new Date("2011-12-12")));
        elasticService.saveAll(list);
    }

}
