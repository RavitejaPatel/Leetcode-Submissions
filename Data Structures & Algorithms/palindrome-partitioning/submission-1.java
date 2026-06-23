class Solution 
{
	List<List<String>> res = new ArrayList<>();
	List<String> sol = new ArrayList<>();

    public List<List<String>> partition(String s) 
	{
        backtrack(s,0);
		return res;
    }

	private void backtrack(String s, int idx)
	{
		if(idx == s.length())
    	{
    		res.add(new ArrayList<>(sol));
    		return;
    	}
		for(int i=idx;i<s.length();i++)
		{
			if(isPalindrome(idx,i,s))
			{
				sol.add(s.substring(idx,i+1));
				backtrack(s,i+1);
				sol.remove(sol.size()-1);
			}
		}
	}

	private boolean isPalindrome(int st, int ed, String word)
	{
		while(st<=ed && st>=0 && ed<word.length())
		{
			if(word.charAt(st)!=word.charAt(ed))
				return false;
			st++;
			ed--;
		}
		return true;
	}
}
