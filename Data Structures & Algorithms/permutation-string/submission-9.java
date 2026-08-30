class Solution 
{
    public boolean checkInclusion(String s1, String s2) 
    {
        if(s1.length()>s2.length()) return false;

        int st = 0;
        int ed = s1.length();
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        while(st<ed)
        {
            char currAts1 = s1.charAt(st);
            char currAts2 = s2.charAt(st);
            s1Arr[currAts1-'a']++;
            s2Arr[currAts2-'a']++;
            st++;
        }

       if(Arrays.equals(s1Arr,s2Arr)) return true; //early return

        ed = s1.length();
        st = 0;
        System.out.print(st+" "+ed);
        while(ed<s2.length())
        {
            char curr = s2.charAt(ed);
            char charAtSt = s2.charAt(ed-s1.length());

            //Remove Char At st
            s2Arr[charAtSt-'a']--;
            //Update curr Char Freq
            s2Arr[curr-'a']++;

            if(Arrays.equals(s1Arr,s2Arr)) return true;
            ed++;
            st++;
        }
        return false;
    }
}
