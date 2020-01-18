package 递归;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 第K个语法符号
 * 
 * @author x00418543
 * @since 2020年1月10日
 */
public class KthGrammar {

    public static void main(String[] args) {
        KthGrammar g = new KthGrammar();
        int N = 10;
        int K = 4;
        for (int i = 1; i <= 32; i++) {
            System.out.print(g.kthGrammar(N, i));
        }
    }

    public int kthGrammar(int N, int K) {
        if (K == 1) {
            return 0;
        }
        if (K == 2) {
            return 1;
        }
        // 经过了times次翻转
        int times = times(K);
        // 计算起始值
        int start = (K % 2 == 0) ? 1 : 0;
        // start翻转times次
        if (start == 0) {
            if (times % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (times % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    public int times(int K) {
        int times = 0;
        while (K > 4) {
            int i = 1;
            while (((int) Math.pow(2, i)) < K) {
                i++;
            }
            K = K - (int) Math.pow(2, i - 1);
            times++;
        }
        if (K == 4) {
            times++;
        } else if (K == 3) {
            times++;
        }
        return times;
    }

}
