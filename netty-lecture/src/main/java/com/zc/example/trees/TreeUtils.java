package com.zc.example.trees;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-10-31 16:38
 */
public class TreeUtils {

    List<Object> list = Lists.newArrayList();
    List<Tree> menuCommon;

    public List<Object> menuList(List<Tree> sourceTree) {
        this.menuCommon = sourceTree;
        sourceTree.stream().forEach(tree -> {
            Map<String, Object> mapArr = Maps.newLinkedHashMap();
            int i = 1;
            if (tree.getParent_id() == 0) {
                mapArr.put("id", tree.getId());
                mapArr.put("name", tree.getName());
                mapArr.put("parent_id", tree.getParent_id());
                mapArr.put("level", i);
                mapArr.put("is_left", tree.getIs_left());
                mapArr.put("child", menuChild(tree.getId(), ++i));
                list.add(mapArr);
            }
        });
        return list;
    }

    private List<?> menuChild(Integer id, int level) {
        List<Object> lists = Lists.newArrayList();
        for (Tree a : menuCommon) {
            Map<String, Object> childArray = Maps.newLinkedHashMap();
            if (a.getParent_id().equals(id)) {
                level = getLevel(level, lists, a, childArray);
            }
        }
        return lists;
    }

    private int getLevel(int level, List<Object> lists, Tree a, Map<String, Object> childArray) {
        childArray.put("id", a.getId());
        childArray.put("name", a.getName());
        childArray.put("parent_id", a.getParent_id());
        childArray.put("level", level);
        childArray.put("is_left", a.getIs_left());
        childArray.put("child", menuChild(a.getId(), ++level));
        lists.add(childArray);
        return level;
    }

}
