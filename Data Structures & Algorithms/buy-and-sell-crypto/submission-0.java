class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0]; //initialize with first element
        int maxiProfit = 0;

        for(int i=1; i<prices.length; i++){
            //check for lowest price
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            else{ //else, calculate and update the max profit.
                maxiProfit = Math.max(maxiProfit, prices[i] - minPrice);
            }
        }

        return maxiProfit;
    }
}
