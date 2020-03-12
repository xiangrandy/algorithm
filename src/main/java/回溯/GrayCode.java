package 回溯;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月9日
 */
public class GrayCode {

    public static void main(String[] args) {
        int n = 7;
        GrayCode gray = new GrayCode();
        List<Integer> l = gray.grayCode(n);
        System.out.println(l);
    }

    public List<Integer> grayCode(int n) {
        int[] a = new int[n];
        int size = (int) Math.pow(2, n);
        List<Integer> l = new ArrayList<>(size);
        l.add(0);
        for (int i = 0; i < a.length; i++) {
            int high = (int) Math.pow(2, i);
            int length = l.size();
            for (int j = length - 1; j >= 0; j--) {
                l.add(high + l.get(j));
            }
        }
        return l;
    }

}
