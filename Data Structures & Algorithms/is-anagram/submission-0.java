class Solution 
{
   public boolean isAnagram(String s, String t) 
    {
    	if(s.length()!=t.length())
    		return false;
    	int[] freqChar = new int[26];
    	
    	for(int i=0;i<s.length();i++)
    	{
    		char s_curr_char = s.charAt(i);
    		char t_curr_char = t.charAt(i);
    		
    		freqChar[s_curr_char-'a']++;
    		freqChar[t_curr_char-'a']--;
    	}
    	
    	for(int i=0;i<freqChar.length;i++)
    	{
    		if(freqChar[i]!=0)
    			return false;
    		
    	}
    	return true;
    }
}
