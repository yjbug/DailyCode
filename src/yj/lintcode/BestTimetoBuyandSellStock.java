package yj.lintcode;

import tools.ArrayUtils;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		int A[] = ArrayUtils.ARRAY;
		BestTimetoBuyandSellStock T = new BestTimetoBuyandSellStock();
		int a = T.maxProfitIII(A);
		System.out.println(a);
	}

	// I. you were only permitted to complete at most one transaction
	// 根据当前最小值，选取之后的一个最大值， 差值为profit
	public int maxProfitI(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int buy = prices[0];
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > buy + profit) {
				profit = prices[i] - buy;
			} else if (prices[i] < buy) {
				buy = prices[i];
			}
		}
		return profit;
	}

	// I. 另一种解法，参考III
	// 对于单次交易的理解：
	// buy 收购股票后，当前收益，目标是尽可能的降低成本
	// sell 一次交易后的收益， 选取历史最高收益 和 当前销售收益 的较大值
	public int maxProfitIA(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int sell = 0;
		int buy = Integer.MIN_VALUE; // 初始成本无限大
		for (int price : prices) {
			sell = Math.max(sell, buy + price);
			buy = Math.max(buy, -price);
		}
		return sell;
	}

	// II. You may complete as many transactions as you like
	// 寻找全部升值区间
	public int maxProfitII(int[] prices) {
		int result = 0;
		for (int i = 1; i < prices.length; i++)
			result += Math.max(prices[i] - prices[i - 1], 0);
		return result;
	}

	// III. You may complete at most two transactions.

	// 假设手上最开始只有0元钱，那么如果买入股票的价格为price，手上的钱需要减去这个price，如果卖出股票的价格为price，手上的钱需要加上这个price。
	// 它定义了4个状态：
	// BuyA[i]表示前i天做第一笔交易买入股票后剩下的最多的钱；
	// SellA[i]表示前i天做第一笔交易卖出股票后剩下的最多的钱；
	// BuyB[i]表示前i天做第二笔交易买入股票后剩下的最多的钱；
	// SellB[i]表示前i天做第二笔交易卖出股票后剩下的最多的钱；
	// 那么
	// SellB[i]=max{SellB[i-1],BuyB[i-1]+prices[i]}
	// BuyB[i]=max{BuyB[i-1],SellA[i-1]-prices[i]}
	// SellA[i]=max{SellA[i-1],BuyA[i-1]+prices[i]}
	// BuyA[i]=max{BuyA[i-1],-prices[i]}
	// 上面四个状态都是只与前一个状态有关，所以用两组变量来存储
	
	// BuyB的理解： 易知，SellA是前i个元素下，完成一次交易的最大收益
	//           BuyB 在SellA前提下，尽可能的最小化成本
	// SellB的理解： 由上述可知， BuyB[i-1]表示的是前i个元素下，收购入股票的最小成本
	// 				SellB是 历史最高收益 和 当前销售收益 的较大值
	
	

	public int maxProfitIII(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int sellA = 0;
		int buyA = Integer.MIN_VALUE;
		int sellB = 0;
		int buyB = Integer.MIN_VALUE;

		for (int price : prices) {
			sellB = Math.max(sellB, buyB + price);
			buyB = Math.max(buyB, sellA - price);
			sellA = Math.max(sellA, buyA + price);
			buyA = Math.max(buyA, -price);
		}
		return sellB;
	}
}
