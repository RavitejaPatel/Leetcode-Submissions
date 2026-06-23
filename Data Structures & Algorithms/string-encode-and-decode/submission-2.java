class Solution {
	public String encode(List<String> strs) 
    {
  		//["neet","you"]
        //neet#you#
        // ["neet#","you"]
        //neet#you#

        //["neet#","you"]
        //5#neet#3#you
        // st = 0
        // ed = 0
        //[neet#]
        String res = "";
        for(int i=0;i<strs.size();i++)
        {
            String curr = strs.get(i);
           res+=curr.length()+"#"+curr;//#4neet
        }
        System.out.print(res);
        System.out.println();
        //decode(res);
        return res;
    }

    //2neet aaaaaaa...a
    //5#2neet 11#a
   public List<String> decode(String str) 
    {
		int st=0;
		int ed=0;
		List<String> encodedList = new ArrayList<>();
		
		while(st<=ed && ed<str.length())
		{
			char curr = str.charAt(ed);
			if(curr=='#')
			{
				String num = str.substring(st, ed);//12
				
				//prepare num
				int j=0;
				int digit = 0;
				while(j<num.length())
				{
					digit = digit * 10 + (num.charAt(j)-'0');
					j++;
				}
				System.out.println(str.substring(ed+1, ed+1+digit));
				encodedList.add(str.substring(ed+1, ed+1+digit));
				st = ed+1+digit;
				ed = ed+1+digit;
			}
			
			else
				ed++;
		}
		return encodedList;
    }
}
