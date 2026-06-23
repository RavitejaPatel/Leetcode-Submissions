class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {   
        int max_pile = 0;
        
        for(int pile : piles)
        {
            max_pile = Math.max(max_pile,pile);
        }

       int st=1;
       int ed=max_pile;
      int minRate = max_pile;

       while(st<=ed)
       {
            int rate = st + (ed - st) / 2;
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
        for (int p : piles) 
        {
            hours += (p + rate - 1) / rate; // ceil(p / rate) using ints
            if (hours > h) return false;    // early exit
        }
        return hours <= h;
    }


}
