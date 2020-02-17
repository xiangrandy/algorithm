package 字符串;

import java.util.LinkedList;
import java.util.List;

/**
 * Find Common Characters
 * 
 * @author x00418543
 * @since 2020年2月12日
 */
public class FindCommonCharacters1002 {

    public static void main(String[] args) {
        FindCommonCharacters1002 f = new FindCommonCharacters1002();
        String[] A = { "bella", "label", "roller" };
        List<String> l = f.commonChars(A);
        System.out.println(l.toString());
    }

    public List<String> commonChars(String[] A) {
        int[] counter = new int[26];
        for (char c : A[0].toCharArray()) {
            counter[c - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] tempArr = new int[26];
            for (char c : A[i].toCharArray()) {
                tempArr[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (tempArr[j] < counter[j]) {
                    counter[j] = tempArr[j];
                }
            }
        }
        LinkedList<String> resList = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            while (counter[i]-- > 0) { // counter[0] 记录字母a的出现次数
                resList.addLast("" + (char) ('a' + i));
            }
        }
        return resList;
    }

}
