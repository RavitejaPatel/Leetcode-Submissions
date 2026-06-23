class Solution 
{


public String longestPalindrome(String s)
{
    int n = s.length();
    int maxLength=0;
    String fString="";
    boolean[][] dp = new boolean[n][n];
    int count = 0;

    for (int i = n - 1; i >= 0; i--) 
    {
        for (int j = i; j < n; j++) 
        {
            if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) 
            {
                dp[i][j] = true;
                count++;

                if(j-i+1>=maxLength)
                {
                    maxLength = Math.max(maxLength, j-i+1);
                    fString = s.substring(i,j+1);
                }
            }
        }
    }
    return fString;
}

//    public String longestPalindrome(String s) 
//     {
//         int mxSubStrLen = 0;
//         String substr = "";

//         for(int i=0;i<s.length();i++)//abbc 0 1 2 3
//         {
//             int l = i;//0
//             int r = i;//0
//             while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
//             {
//             if((r-l)+1 >= mxSubStrLen)
//             {
//                 mxSubStrLen = (r-l)+1;
//                 substr = s.substring(l,r+1);
//             }
//             l--;
//             r++;
//             }
//         }

//         // even
//         for(int i=0;i<s.length();i++)//abbc 0 1 2 3
//         {
//             int l = i;//0
//             int r = i+1;//0
//             while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
//             {
//             if((r-l)+1 >= mxSubStrLen)
//             {
//                 mxSubStrLen = (r-l)+1;
//                 substr = s.substring(l,r+1);
//             }
//             l--;
//             r++;
//             }
//         }
//         return substr;
//     }
}
