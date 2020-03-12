package 数学;
import java.util.Scanner;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 计算字符平均长度
 * 
 * @author x00418543
 * @since 2020年1月15日
 */
public class Words {

    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new
        // Scanner(System.in);
        Scanner in = new Scanner(System.in);
        // please finish the function body here.
        double weight = 0d;
        String word = in.nextLine();
        String word2 = word.replace(" ", "");
        String[] words = word.split(" ");
        weight = (double) word2.length() / (double) words.length;
        // please define the JAVA output here. For
        // example:System.out.println(s.nextInt());
        System.out.println(String.format("%.2f", weight));
    }

}
