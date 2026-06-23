class Solution 
{
    
    public int lengthOfLongestSubstring(String s) 
    {
        //z x y z x y z     z-1 x-1 y-1
        //  ^     ^
        
        //x z y z x y z 
        int st=0;
        int ed=0;
        int subStrLensoFar = -1;
        Map<Character,Integer> map = new HashMap();
        while(ed<s.length())
        {
            char charAtEd = s.charAt(ed);//x z y z
            map.put(charAtEd, map.getOrDefault(charAtEd,0)+1);// z-1 y-1
            
            while(map.get(charAtEd)>1 && st<=ed)
            {
               char charAtSt = s.charAt(st);//x z
               map.put(charAtSt, map.get(charAtSt)-1);
               
               if(map.get(charAtSt)<=0)
                map.remove(charAtSt);

                st++;//1 2
            }

            subStrLensoFar = Math.max(subStrLensoFar, (ed-st)+1);//-1,0-0+1, 1,(1-0)+ 2 3
            
            ed++;//1 2 3
        }
        return subStrLensoFar == -1 ? 0 : subStrLensoFar;
    }
}
