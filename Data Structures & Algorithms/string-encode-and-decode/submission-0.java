class Solution {
	public String encode(List<String> strs) 
    {
  		//"neet","you","code"
  		String encodedStr = "";
  		for(int i=0;i<strs.size();i++)
  		{
  			String currWord = strs.get(i);
  			encodedStr=encodedStr+currWord.length()+"#"+currWord;// 4#neet3#you4#code
  		}
  		System.out.println(encodedStr);
  		return encodedStr;
    }

    public List<String> decode(String str) 
    {
    	List<String> res = new ArrayList();
    	// 4#neet3#you4#code
    	int i=0;
    	int j=0;
    	while(j<str.length())
    	{
    		//j=i;
    		//char curr = str.charAt(j);
    		while(str.charAt(j)!='#')
    			j++;//j7i6
    		int wordLen = Integer.parseInt(str.substring(i, j));
    		j++;
    		
    		String decodedWord = str.substring(j,j+wordLen);
    		System.out.println("===="+decodedWord);
    		res.add(decodedWord);
    		j = j+wordLen;//6
    		i=j;//
    	}
    	System.out.println(res);
    	return res;
    	
    }
}
