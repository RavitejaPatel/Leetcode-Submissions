class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res; // edge case: empty input
        }

        // index = digit, value = letters for that digit
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

        backtrack(0, new StringBuilder(), digits, digitToChar, res);
        return res;
    }

    private void backtrack(int index,
                           StringBuilder curStr,
                           String digits,
                           String[] digitToChar,
                           List<String> res) {

        // if current string length == digits length, we have a full combination
        if (curStr.length() == digits.length()) {
            res.add(curStr.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = digitToChar[digit - '0'];

        for (int i = 0; i < letters.length(); i++) {
            curStr.append(letters.charAt(i));               // choose
            backtrack(index + 1, curStr, digits, digitToChar, res); // explore
            curStr.deleteCharAt(curStr.length() - 1);       // un-choose (backtrack)
        }
    }
}