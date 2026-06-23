class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int st=0;
        int ed=1;
        int maxProfit = 0;

        while(ed<prices.length)
        {
            if(prices[st]>prices[ed])
                st = ed;
            else
                maxProfit = Math.max(maxProfit, prices[ed]-prices[st]);
            ed++;
        } 
        return maxProfit;   
    }
}
