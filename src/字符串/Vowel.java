package 字符串;
import java.util.Scanner;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * 翻译
 * 
 * @author x00418543
 * @since 2020年1月15日
 */
public class Vowel {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String word = s.nextLine();
        word = word.toLowerCase().replace('a', 'A').replace('e', 'E').replace('i', 'I').replace('o', 'O').replace('u',
                'U');
        System.out.println(word);
    }

}
