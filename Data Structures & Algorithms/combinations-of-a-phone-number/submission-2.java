class Solution 
{
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) 
    {
        if(digits.length()<=0)
            return res;
            
        String[] digitToChar = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };

        backtrack(0,new StringBuilder(),digits,digitToChar);
        return res;
    }

    private void backtrack(int idx,StringBuilder sb,String digits, String[] digitToChar)
    {
        if(sb.length()==digits.length())
        {
            res.add(sb.toString());//ad ae
            return;
        }

        String letters = digitToChar[digits.charAt(idx)-'0'];//ab  de
        for(int i=0;i<letters.length();i++)//ab   de 2
        {
            sb.append(letters.charAt(i));//ab  de ad ae
            backtrack(idx+1,sb,digits,digitToChar);
            sb.deleteCharAt(sb.length()-1);//a a ""
        }
        


    }
}
