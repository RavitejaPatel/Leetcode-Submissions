class Solution 
{
     public String minWindow(String s, String t) 
		{
			Map<Character, Integer> map = new HashMap();

			for(char c : t.toCharArray())
				map.put(c,map.getOrDefault(c,0)+1);
			
			//x-1 y-1 z-1

			int st=0;
			int ed=0;
			Map<Character, Integer> map2 = new HashMap<>();
			int matchedChars=0;
			int minSubLen = Integer.MAX_VALUE;
			String res =  "";

			while(ed<=s.length()-1)
			{
				char curr = s.charAt(ed);
				map2.put(curr,map2.getOrDefault(curr,0)+1);

				if(map.containsKey(curr) && map.get(curr) == map2.get(curr))
					matchedChars++;

				System.out.println(curr+" "+map2.get(curr)+" "+matchedChars);
				while(st<=ed && matchedChars==map.size())
				{
					if((ed-st)+1 < minSubLen )
					{
						res = s.substring(st,ed+1);
						System.out.println(res);
						minSubLen = res.length();
					}
					char charAtSt = s.charAt(st);

					map2.put(charAtSt, map2.get(charAtSt)-1);
					
					if(map.containsKey(charAtSt) && map2.get(charAtSt).intValue() < map.get(charAtSt).intValue())
					{
						matchedChars--;
					}
					st++;
				}
				ed++;
			}
			return res;
	    }
}


//OUZODYXAZV
//XYZ

