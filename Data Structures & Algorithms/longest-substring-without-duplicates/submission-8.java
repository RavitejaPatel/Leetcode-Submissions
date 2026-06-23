class Solution 
{
    
    public int lengthOfLongestSubstring(String s) 
    {
        //z x y z x y z     z-1 x-1 y-1
        //  ^     ^
        
        //a b b a
        int st=0;
        int ed=0;
        int subStrLensoFar = -1;
        Map<Character,Integer> map = new HashMap();
        while(ed<s.length())
        {
            char charAtEd = s.charAt(ed);//a b b a

            if(map.containsKey(charAtEd))//
            {
                int prevIdx = map.get(charAtEd);//1 0
                if(prevIdx<ed)
                    map.remove(charAtEd);

                st = Math.max(prevIdx+1,st); //2 1
            }
            
            map.put(charAtEd, ed);// a-0(rem) b-1(rem) b-2
            

            subStrLensoFar = Math.max(subStrLensoFar, (ed-st)+1);//1 2-
            
            ed++;//1 3
        }
        return subStrLensoFar == -1 ? 0 : subStrLensoFar;
    }
}
