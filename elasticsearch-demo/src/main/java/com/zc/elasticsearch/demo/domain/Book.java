package com.zc.elasticsearch.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document(indexName = "ems",type = "_doc", shards = 10, replicas = 1)
public class Book {

    @Id
    private Long id;

    @Field(type = FieldType.Text, analyzer = "title")
    private String title;

    @Field(type = FieldType.Keyword)
    private String author;

    @Field(type = FieldType.Integer, analyzer = "word_count")
    private Integer wordCount;

    @Field(type = FieldType.Date, analyzer = "publish_date")
    private Date publishDate;


}
