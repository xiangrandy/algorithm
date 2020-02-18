package 查找;

public class 第一个错误的版本 {

    public static void main(String[] args) {
        第一个错误的版本 d = new 第一个错误的版本();
        int n = 111;
        System.out.println(d.firstBadVersion(n));
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int n) {
        return n > 1;
    }

}
