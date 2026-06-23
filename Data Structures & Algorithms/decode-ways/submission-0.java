class Solution 
{

public int numDecodings(String s) {
    int n = s.length();
    int[] dp = new int[n + 1];

    dp[n] = 1; // empty suffix base case

    for (int i = n - 1; i >= 0; i--) {

        // single digit decode
        if (s.charAt(i) != '0') {
            dp[i] += dp[i + 1];
        }

        // two digit decode
        if (i + 1 < n) {
            int val = Integer.parseInt(s.substring(i, i + 2));
            if (val >= 10 && val <= 26) {
                dp[i] += dp[i + 2];
            }
        }
    }

    return dp[0];
}

}
