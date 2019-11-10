package com.zc.example.trees;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-10-31 16:35
 */
//@Data
//@Builder
public class Tree {

    private Integer id;
    private String name;
    private Integer parent_id;
    private Integer level;
    private Integer is_left;
    private List<Tree> child;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIs_left() {
        return is_left;
    }

    public void setIs_left(Integer is_left) {
        this.is_left = is_left;
    }

    public List<Tree> getChild() {
        return child;
    }

    public void setChild(List<Tree> child) {
        this.child = child;
    }
}
