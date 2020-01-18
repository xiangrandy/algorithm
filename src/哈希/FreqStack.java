package 哈希;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月9日
 */
public class FreqStack {

    public static void main(String[] args) {
        // [[],[718967141],[189971378],[341560426],[23521218],[339517772],[967482459],[],[978798455],[],[744530040],[],[3454610],[],[940238504],[],[],[],[],[],[]]
        FreqStack s = new FreqStack();
        s.push(5);
        s.push(7);
        s.push(5);
        s.push(7);
        s.push(4);
        s.push(5);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

    Map<Integer, Integer> freq;

    Map<Integer, Stack<Integer>> group;

    int maxfreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq) {
            maxfreq = f;
        }
        group.computeIfAbsent(f, z -> new Stack<>()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0) {
            maxfreq--;
        }
        return x;
    }

}
