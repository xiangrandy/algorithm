package 数学;
import java.util.Scanner;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * Table
 * 
 * @author x00418543
 * @since 2020年1月15日
 */
public class Table {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sqrt = (int) Math.sqrt(n);
        int cnt = 0;
        String ss = "%s";
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    ss = String.format(ss, i);
                    cnt += 1;
                } else {
                    ss = String.format(ss, i + " %s " + n / i);
                    cnt += 2;
                }
            }
        }
        System.out.print(cnt + " " + ss.replace("%s ", ""));
    }

}
