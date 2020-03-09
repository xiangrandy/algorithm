package 动态规划;

public class 买卖股票的最佳时机121 {

	public static void main(String[] args) {
		买卖股票的最佳时机121 m = new 买卖股票的最佳时机121();
		int[] prices = {7, 1, 5, 3, 6, 4};
		int profit = m.maxProfit(prices);
		System.out.println(profit);
	}

	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int maxProfit = 0;
		int minPrices = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < minPrices) {
				minPrices = prices[i];
			} else {
				int profit = prices[i] - minPrices;
				if (profit > maxProfit) {
					maxProfit = profit;
				}
			}
		}
		return maxProfit;
	}

}
