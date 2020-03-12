package 字符串;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月16日
 */
public class 文本左右对齐68 {

    public static void main(String[] args) {
        文本左右对齐68 w = new 文本左右对齐68();
        String[] words = { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
                "computer.", "Art", "is", "everything", "else", "we", "do" };
        int maxWidth = 20;
        List<String> l = w.fullJustify(words, maxWidth);
        for (String s : l) {
            System.out.println(s);
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> l = new ArrayList<>();
        String line = "";
        // 分行
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (canBePut(line, word, maxWidth)) {
                // 放置
                line += word;
                if (line.length() != maxWidth) {
                    line += " ";
                }
            } else {
                // 换行
                line = average(line, maxWidth);
                l.add(line);
                // 新line
                line = "";
                line += word;
                if (line.length() != maxWidth) {
                    line += " ";
                }
            }
            if (i + 1 == words.length) {
                // 最后行
                line = addBlanks(line, maxWidth);
                l.add(line);
            }
        }
        return l;
    }

    private String average(String line, int maxWidth) {
        String newLine = "";
        line = line.trim();
        int length = line.replace(" ", "").length();
        // 空格数
        String[] words = line.split(" ");
        int blanks = words.length - 1;
        if (blanks == 0) {
            return addBlanks(line, maxWidth);
        }
        // 需要加的空格
        int blanksToAdd = maxWidth - length;
        int blankNumber = blanksToAdd / blanks;
        int blankNumberRest = blanksToAdd % blanks;
        String blank = "";
        for (int i = 0; i < blankNumber; i++) {
            blank += " ";
        }
        for (int i = 0, j = 0; i < words.length - 1; i++, j++) {
            newLine += (words[i].trim() + (blank + (j < blankNumberRest ? " " : "")));
        }
        newLine += words[words.length - 1].trim();
        return newLine;
    }

    private String addBlanks(String line, int maxWidth) {
        line = line.trim();
        int length = line.length();
        int blankToAdd = maxWidth - length;
        String blanks = "";
        for (int i = 0; i < blankToAdd; i++) {
            blanks += " ";
        }
        return line + blanks;
    }

    private boolean canBePut(String line, String word, int maxWidth) {
        if (line.length() + word.length() <= maxWidth) {
            return true;
        } else {
            return false;
        }
    }

}
