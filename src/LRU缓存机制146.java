/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * LRU缓存机制
 * 
 * @author x00418543
 * @since 2020年1月17日
 */
public class LRU缓存机制146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */ );
        cache.put(2, 1);
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

}
