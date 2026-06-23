class Solution {
   public String longestPalindrome(String s) 
    {
        int mxSubStrLen = 0;
        String substr = "";

        for(int i=0;i<s.length();i++)//abbc 0 1 2 3
        {
            int l = i;//0
            int r = i;//0
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
            {
            if((r-l)+1 >= mxSubStrLen)
            {
                mxSubStrLen = (r-l)+1;
                substr = s.substring(l,r+1);
            }
            l--;
            r++;
            }
        }

        // even
        for(int i=0;i<s.length();i++)//abbc 0 1 2 3
        {
            int l = i;//0
            int r = i+1;//0
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
            {
            if((r-l)+1 >= mxSubStrLen)
            {
                mxSubStrLen = (r-l)+1;
                substr = s.substring(l,r+1);
            }
            l--;
            r++;
            }
        }
        return substr;
    }
}
