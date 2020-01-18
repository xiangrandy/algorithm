package 数学;
import java.util.Scanner;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 加法器
 * 
 * @author x00418543
 * @since 2020年1月15日
 */
public class APLUSB {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            java.math.BigDecimal first = s.nextBigDecimal();
            java.math.BigDecimal second = s.nextBigDecimal();
            java.math.BigDecimal result = first.add(second);
            System.out.println("Case " + (i + 1) + ":");
            System.out.println(first.toString() + " + " + second.toString() + " = " + result.toString());
            if (i != n - 1) {
                System.out.println("");
            }
        }
    }
}
