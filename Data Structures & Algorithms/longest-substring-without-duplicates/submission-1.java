class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        int st=0;
        int ed=0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap();

        while(ed<s.length())
        {
            char currChar = s.charAt(ed);
            map.put(currChar, map.getOrDefault(currChar,0)+1);
            
            while(map.get(currChar)>1)
            {
                char charAtSt = s.charAt(st++);
                map.put(charAtSt, map.get(charAtSt)-1);
                if(map.get(charAtSt)<=0)
                {
                    map.remove(charAtSt);
                }
            }
           maxLen = Math.max(maxLen, (ed-st)+1);
           ed++; 
        }
    return maxLen;
    }
}
