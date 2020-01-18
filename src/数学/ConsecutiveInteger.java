package 数学;
import java.util.Scanner;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 连续整数
 * 
 * @author x00418543
 * @since 2020年1月15日
 */
public class ConsecutiveInteger {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int result = 2;
        boolean exist = true;
        while (result <= n) {
            if (result == n) {
                exist = false;
                break;
            }
            result *= 2;
        }
        System.out.println(exist ? "YES" : "NO");
    }

}
