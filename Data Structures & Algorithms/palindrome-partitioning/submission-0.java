class Solution 
{
    List<List<String>> res = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    
    public List<List<String>> partition(String s) 
    {
    	dfs(0, s);
    	return res;
    }
    private void dfs(int idx, String word)
    {
    	if(idx == word.length())
    	{
    		res.add(new ArrayList<>(temp));
    		return;
    	}
    	
    	for(int i=idx;i<word.length();i++)
    	{
    		if(isPalindrome(idx, i, word))
    		{
    			temp.add(word.substring(idx, i+1));
    			dfs(i+1, word);
    			temp.remove(temp.size()-1);
    		}
    	}
    }
    private boolean isPalindrome(int st, int ed, String word)
    {
    	while(st<ed)
    	{
    		if(word.charAt(st)!=word.charAt(ed))
    		{
    			return false;
    		}
    		st++;
    		ed--;
    	}
    	return true;
    }
}
