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
        List<String> res = new ArrayList<String>();
        int st = 0;

        for(int i=0;i<str.length();)  // 5#2neet 11#aaaaaaaaaaa
        {
            char curr = str.charAt(i); //5# 1 1 #
           

            if(curr == '#')//#i=1 i=9
            {
                String num = str.substring(st, i);//01 -> 5  str(7,9)->11
                int digit=0;
                int j=0;
                while(j<num.length())//2
                {
                    digit = digit*10 + (num.charAt(j) - '0');//0+5
                    j++;
                }
                System.out.println(str.substring(i+1,i+1+digit));
                res.add(str.substring(i+1,i+1+digit));//sub(2,7)-> 2neet   sub(10,21)
                st = i+1+digit;//7 21
                i = i+1+digit;//7 21
             
            }
            else
            	i++;

        }
    	return res;
    	
    }
}
