package com.zc.example.trees;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-10-31 16:59
 */
public class Hello {

    public static void main(String[] args) {
        Tree tree1 = new Tree();
        tree1.setId(1000);
        tree1.setName("美食");
        tree1.setParent_id(0);
//        tree1.setLevel(1);
        tree1.setIs_left(0);
        Tree tree2 = new Tree();
        tree2.setId(10);
        tree2.setName("快餐小吃");
        tree2.setParent_id(1000);
//        tree2.setLevel(2);
        tree2.setIs_left(0);
        Tree tree3 = new Tree();
        tree3.setId(94);
        tree3.setName("快餐简餐");
        tree3.setParent_id(10);
//        tree3.setLevel(3);
        tree3.setIs_left(1);
        Tree tree4 = new Tree();
        tree4.setId(22);
        tree4.setName("医药健康");
        tree4.setParent_id(0);
//        tree4.setLevel(1);
        tree4.setIs_left(0);
        List<Tree> dbTrees = Lists.newArrayList(tree1, tree2, tree3, tree4);
        List<Object> objects = new TreeUtils().menuList(dbTrees);
        System.out.println(objects);
    }
}
