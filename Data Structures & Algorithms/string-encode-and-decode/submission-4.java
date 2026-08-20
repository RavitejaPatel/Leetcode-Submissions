class Solution {

    public String encode(List<String> strs) {
		String encode = "";
		for(String str : strs)
		{
			encode+=str.length()+"#"+str;
		}
		System.out.println(encode);
		return encode;
    }

    public List<String> decode(String str) {
		//10#Helloooooo5#World
		int st=0;
		int ed=0;
		String tempNum = "";
		List<String> fres=new ArrayList();

		while(ed<str.length())
		{
			char curr = str.charAt(ed);
			System.out.print(" "+curr);
			if(curr=='#')
			{
				String sub = str.substring(st,ed);//10
				System.out.println("==========="+sub);
				int num=0;
				int i=0;
				while(i<sub.length())
				{
					num = num*10+(sub.charAt(i)-'0');
					i++;  //
				}
				st = st+i;
				//st=2 ed=2
				//num=10
				System.out.println(st+"==========="+ed);
				String decoded = str.substring(st+1, ed+1+num);
				System.out.println(decoded);
				fres.add(decoded);
				st = st+1+num;
				ed = ed+1+num;
				System.out.println(st+" "+ed);
			}
			else
			{
				//tempNum+=curr;
				ed++;
				System.out.println(tempNum);
			}
			
		}

		return fres;

    }
}
