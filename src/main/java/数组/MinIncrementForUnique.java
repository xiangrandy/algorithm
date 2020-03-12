package 数组;
import java.util.Arrays;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月9日
 */
public class MinIncrementForUnique {

    public static void main(String[] args) {
        MinIncrementForUnique m = new MinIncrementForUnique();
        int[] A = { 3, 2, 1, 2, 1, 7 };
        System.out.println(m.minIncrementForUnique(A));
    }

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int diff = A[i - 1] - A[i] + 1;
                A[i] = A[i - 1] + 1;
                count += diff;
            }
        }
        return count;
    }

}
