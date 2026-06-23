class Solution 
{
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) 
    {
        if (digits == null || digits.length() == 0) {
            return res; // edge case: empty input
        }

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

        backtrack(digitToChar,digits,0,new StringBuilder());
        return res;
    }

    private void backtrack(String[] digitToChar, String digits, int idx, StringBuilder sb)
    {
        if(sb.length()==digits.length())
        {
            res.add(sb.toString());
            return;
        }
        //34
        String currStr = digitToChar[digits.charAt(idx)-'0'];//3->ab 4->cd  //idx=0->ab //idx=1->cd

        for(int i=0;i<currStr.length();i++)//ab i=0//  cd i=0
        {
            sb.append(currStr.charAt(i));//ac
            backtrack(digitToChar, digits, idx+1, sb);//bt(1)->idx=1
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
