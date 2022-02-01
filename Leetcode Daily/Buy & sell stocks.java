/*121. Best Time to Buy and Sell Stock
Add to List

Share
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.*/

public int maxProfit(int[] prices) {
	var maxProfit = 0;

	for (int i = 1, cheapest = prices[0]; i < prices.length; i++) {
		if (prices[i] >= cheapest)
			maxProfit = Math.max(maxProfit, prices[i] - cheapest);
		cheapest = Math.min(cheapest, prices[i]);
	}
	return maxProfit;
}
