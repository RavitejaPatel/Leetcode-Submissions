class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int st=0;
        int ed=1;
        int maxProfit = 0;

        while(ed<prices.length)
        {
            int curr = prices[ed];//1 5 3
            if(curr > prices[st]) //5>1 3
                maxProfit = Math.max(maxProfit, prices[ed]-prices[st]);//4 5
            else
                st = ed;//1
            ed++;//2 3 4
        } 
        return maxProfit;   
    }
}
