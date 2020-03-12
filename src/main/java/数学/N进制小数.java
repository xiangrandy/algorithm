package 数学;
import java.util.Scanner;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * N进制小数
 * 
 * @author x00418543
 * @since 2020年1月15日
 */
public class N进制小数 {

    public static void main(String[] args) {

        // please define the JAVA input here. For example: Scanner s = new
        // Scanner(System.in);
        Scanner s = new Scanner(System.in);
        // please finish the function body here.
        while (s.hasNext()) {
            String m = s.next();
            int n = s.nextInt();
            if (m.equals("0") && n == 0) {
                return;
            }
            double d = Double.parseDouble(m);
            String output = "0.";
            int i = 0;
            while (i < 10) {
                d = d * n;
                output += (int) d;
                d = d - (int) d;
                i++;
            }
            System.out.println(output);
        }
        // please define the JAVA output here. For example:
        // System.out.println(s.nextInt());

    }

}
