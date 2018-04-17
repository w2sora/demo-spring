package com.designPatterns._24Iterator;

public interface Collection {
    /**
     * 取得迭代器对象
     */
    Iterator iterator();

    /**
     * 取得集合元素
     */
    Object get(int i);

    /**
     * 取得集合大小
     */
    int size();

}
