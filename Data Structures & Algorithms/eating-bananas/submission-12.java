class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {
        int minRate=Integer.MAX_VALUE;
        int min_banana_ct = 1;
        // int max_banana_ct = Arrays.stream(piles)
        //                 .max()
        //                 .getAsInt();
        int max_banana_ct=0;
         for(int pile : piles)
        {
            max_banana_ct = Math.max(max_banana_ct,pile);
        }

         System.out.println(min_banana_ct+" "+max_banana_ct);

        int st = min_banana_ct;
        int ed = max_banana_ct;

        while(st<=ed)
        {
            int rate = (st + ed)/2;
            System.out.print("rate is : "+rate);
            if(canEatwithCurrentRate(piles,rate,h))
            {
                System.out.println("minRate "+minRate);
                ed = rate-1;
                //minRate = Math.min(minRate, rate);
                minRate = rate;
            }
            else
                st = rate+1;

        }  
        return minRate;
    }

    private boolean canEatwithCurrentRate(int[] piles, int rate, int h)
    {
        int hours = 0;

        for(int p : piles)
        {
           int hour = (int)Math.ceil( (double)p/rate );
           hours+=hour;
            // if(hours>h)
            //     return false;
        }
        System.out.println("hours is "+hours);
        return hours<=h;
    }
}
