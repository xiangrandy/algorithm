package 数学;

public class GreatestCommonDivisorOfStrings1071 {

	public static void main(String[] args) {
		GreatestCommonDivisorOfStrings1071 g = new GreatestCommonDivisorOfStrings1071();
		String str1 = "ABABAB";
		String str2 = "AB";
		System.out.println(g.gcdOfStrings(str1, str2));
	}

	public String gcdOfStrings(String str1, String str2) {
		if (!(str1 + str2).equals(str2 + str1)) {
			return "";
		}
		int maxCommonDivisor = gcd(str1.length(), str2.length());
		return str1.substring(0, maxCommonDivisor);
	}

	public int gcd(int a, int b) {
		int r;
		while (b > 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

}
