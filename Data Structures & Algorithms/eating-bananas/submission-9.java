class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {   
        int min_pile = 1;
        int max_pile = 0;
        
        for(int pile : piles)
        {
            max_pile = Math.max(max_pile,pile);
        }

       int st=min_pile;
       int ed=max_pile;
      int minRate = max_pile;

       while(st<=ed)
       {
            int rate = (st+ed)/2;
            if(canFinish(piles,h,rate))
            {
                ed = rate-1;
                minRate = rate;
            }
            else
                st = rate+1;
       }
       return minRate;
    }

    
  private boolean canFinish(int[] piles, int h, int rate) 
  {
    long hours = 0;
    for (int p : piles) {
        hours += p / rate;               // full hours
        if (p % rate != 0) hours += 1;   // remainder needs one more hour
        if (hours > h) return false;     // early exit
    }
    return hours <= h;
}


}
