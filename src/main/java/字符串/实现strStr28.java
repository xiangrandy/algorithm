package 字符串;

public class 实现strStr28 {

    public static void main(String[] args) {
        实现strStr28 s = new 实现strStr28();
        String haystack = "aaaaabba";
        String needle = "bba";
        System.out.println(s.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle) || needle.length() > haystack.length()) {
            return 0;
        }
        int length = needle.length();
        char[] needleChars = needle.toCharArray();
        char[] haystackChars = haystack.toCharArray();
        for (int i = length - 1; i < haystackChars.length; i++) {
            boolean found = true;
            for (int j = 0; j < length; j++) {
                if (needleChars[length - 1 - j] != haystackChars[i - j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i + 1 - length;
            }
        }
        return -1;
    }

}
