package 数学;

public class 布尔代数 {

    public static void main(String[] args) {
        Byte();
        Short();
        Char();
        Integer();
        Long();
        Float();
        Double();
        and();
        or();
        not();
    }

    /**
     * byte数据类型是8位、有符号的，以二进制补码表示的整数；（256个数字），占1字节
     * 
     * @author x00418543
     * @since 2020年2月4日
     */
    public static void Byte() {
        System.out.println("Max byte:" + Byte.MAX_VALUE + " Min byte:" + Byte.MIN_VALUE);
    }

    public static void Boolean() {
        System.out.println();
    }

    /**
     * short数据类型是16位、有符号的以二进制补码表示的整数，占2字节
     * 
     * @author x00418543
     * @since 2020年2月4日
     */
    public static void Short() {
        System.out.println("Max short:" + Short.MAX_VALUE + " Min short:" + Short.MIN_VALUE);
    }

    /**
     * char类型是一个单一的16位Unicode字符；用 ‘’表示一个字符。。java 内部使用Unicode字符集。。他有一些转义字符 ，2字节
     * 
     * @author x00418543
     * @since 2020年2月4日
     */
    public static void Char() {
        System.out.println("Max char:" + Character.MAX_VALUE + " Min char:" + Character.MIN_VALUE);
    }

    /**
     * int数据类型是32位、有符号的以二进制补码表示的整数；占4字节
     * 
     * @author x00418543
     * @since 2020年2月4日
     */
    public static void Integer() {
        System.out.println("Max int:" + Integer.MAX_VALUE + " Min int:" + Integer.MIN_VALUE);
    }

    /**
     * long数据类型是64位、有符号的以二进制补码表示的整数；占8字节
     * 
     * @author x00418543
     * @since 2020年2月4日
     */
    public static void Long() {
        System.out.println("Max long:" + Long.MAX_VALUE + " Min long:" + Long.MIN_VALUE);
    }

    /**
     * float数据类型是单精度、32位、符合IEEE 754标准的浮点数；占4字节
     * 
     * @author x00418543
     * @since 2020年2月4日
     */
    public static void Float() {
        System.out.println("Max float:" + Float.MAX_VALUE + " Min float:" + Float.MIN_VALUE);
    }

    /**
     * double数据类型是双精度、64位、符合IEEE 754标准的浮点数；占8字节
     * 
     * @author x00418543
     * @since 2020年2月4日
     */
    public static void Double() {
        System.out.println("Max double:" + Double.MAX_VALUE + " Min double:" + Double.MIN_VALUE);
    }

    public static void and() {
        int a = 129;
        int b = 128;
        System.out.println("a 和b 与的结果是：" + (a & b));
    }

    public static void or() {
        int a = 129;
        int b = 128;
        System.out.println("a 和b 或的结果是：" + (a | b));
    }

    public static void not() {
        byte a = -128;
        System.out.println("a 非的结果是：" + (~a));
    }

}
