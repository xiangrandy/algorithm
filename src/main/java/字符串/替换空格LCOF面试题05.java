package 字符串;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 
 * @author x00418543
 * @since 2020年2月13日
 */
public class 替换空格LCOF面试题05 {

    public static void main(String[] args) {
        替换空格LCOF面试题05 t = new 替换空格LCOF面试题05();
        String s = "We are happy.";
        System.out.println(t.replaceSpace(s));
    }

    public String replaceSpace(String s) {
        s = s.replace(" ", "%20");
        return s;
    }

}
