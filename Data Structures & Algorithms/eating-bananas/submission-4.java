class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {
        int minPile = 1;
        int maxPiles =  Arrays.stream(piles).max().getAsInt();
        int result = maxPiles;

        while(minPile<maxPiles)  // 1    4
        {
            int midPileRate = (minPile + maxPiles)/2;

            if(canFinish(midPileRate, h, piles))//9hours with this midPileRate
            {
                result = Math.min(result,midPileRate);
                maxPiles = midPileRate;
            }// st  mid   ed
            else
            {
                minPile = midPileRate+1;
            }
        }
        return result;
    }

    private boolean canFinish(int midPileRate, int h, int[] piles)
    {
        // 1 4 3 2
        // 1 2 2 1
        int hours = 0;
        for(int pile : piles)
        {
            hours+= Math.ceil((double)pile/midPileRate);

            if(hours>h)       
                return false;
        }
        return true;
    }


}
