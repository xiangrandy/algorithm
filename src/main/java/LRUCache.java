import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月17日
 */
public class LRUCache {

    int capacity;

    Map<Integer, Integer> m;

    Queue<Integer> queue = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        m = new HashMap<>(capacity);
    }

    public int get(int key) {
        Integer ret = m.get(key);
        if (ret == null) {
            return -1;
        }
        if (queue.contains(key)) {
            queue.remove(key);
        }
        queue.add(key);
        return ret;
    }

    public void put(int key, int value) {
        if (queue.contains(key)) {
            queue.remove(key);
            queue.add(key);
            m.put(key, value);
        } else {
            if (queue.size() == capacity) {
                Integer removed = queue.poll();
                m.remove(removed);
            }
            queue.add(key);
            m.put(key, value);
        }
    }

}
