class Solution 
{
    public int characterReplacement(String s, int k) 
    {
        int st=0;
        int ed=0;
        int[] freqMap = new int[26];
        int maxFreqsoFar = 0;
        int maxLen = 0;

        while(ed<s.length())
        {
            char currChar = s.charAt(ed);
            int val = currChar-'A';
            freqMap[val]++;
            maxFreqsoFar = Math.max(maxFreqsoFar,freqMap[val]);

            while( ((ed-st)+1 - maxFreqsoFar ) > k)
            {
                char charAtSt = s.charAt(st++);
                int valst = charAtSt-'A';
                freqMap[valst]--;
            }
            maxLen = Math.max(maxLen, (ed-st)+1);
				ed++;
        }
        return maxLen;

    }
}
