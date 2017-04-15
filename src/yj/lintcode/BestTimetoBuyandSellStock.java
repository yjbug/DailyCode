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
	// ���ݵ�ǰ��Сֵ��ѡȡ֮���һ�����ֵ�� ��ֵΪprofit
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

	// I. ��һ�ֽⷨ���ο�III
	// ���ڵ��ν��׵���⣺
	// buy �չ���Ʊ�󣬵�ǰ���棬Ŀ���Ǿ����ܵĽ��ͳɱ�
	// sell һ�ν��׺�����棬 ѡȡ��ʷ������� �� ��ǰ�������� �Ľϴ�ֵ
	public int maxProfitIA(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int sell = 0;
		int buy = Integer.MIN_VALUE; // ��ʼ�ɱ����޴�
		for (int price : prices) {
			sell = Math.max(sell, buy + price);
			buy = Math.max(buy, -price);
		}
		return sell;
	}

	// II. You may complete as many transactions as you like
	// Ѱ��ȫ����ֵ����
	public int maxProfitII(int[] prices) {
		int result = 0;
		for (int i = 1; i < prices.length; i++)
			result += Math.max(prices[i] - prices[i - 1], 0);
		return result;
	}

	// III. You may complete at most two transactions.

	// ���������ʼֻ��0ԪǮ����ô��������Ʊ�ļ۸�Ϊprice�����ϵ�Ǯ��Ҫ��ȥ���price�����������Ʊ�ļ۸�Ϊprice�����ϵ�Ǯ��Ҫ�������price��
	// ��������4��״̬��
	// BuyA[i]��ʾǰi������һ�ʽ��������Ʊ��ʣ�µ�����Ǯ��
	// SellA[i]��ʾǰi������һ�ʽ���������Ʊ��ʣ�µ�����Ǯ��
	// BuyB[i]��ʾǰi�����ڶ��ʽ��������Ʊ��ʣ�µ�����Ǯ��
	// SellB[i]��ʾǰi�����ڶ��ʽ���������Ʊ��ʣ�µ�����Ǯ��
	// ��ô
	// SellB[i]=max{SellB[i-1],BuyB[i-1]+prices[i]}
	// BuyB[i]=max{BuyB[i-1],SellA[i-1]-prices[i]}
	// SellA[i]=max{SellA[i-1],BuyA[i-1]+prices[i]}
	// BuyA[i]=max{BuyA[i-1],-prices[i]}
	// �����ĸ�״̬����ֻ��ǰһ��״̬�йأ�����������������洢
	
	// BuyB����⣺ ��֪��SellA��ǰi��Ԫ���£����һ�ν��׵��������
	//           BuyB ��SellAǰ���£������ܵ���С���ɱ�
	// SellB����⣺ ��������֪�� BuyB[i-1]��ʾ����ǰi��Ԫ���£��չ����Ʊ����С�ɱ�
	// 				SellB�� ��ʷ������� �� ��ǰ�������� �Ľϴ�ֵ
	
	

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
