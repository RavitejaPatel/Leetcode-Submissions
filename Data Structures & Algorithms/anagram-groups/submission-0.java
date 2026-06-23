class Solution 
{
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> temp = null;
        for(int i=0;i<strs.length;i++)
        {
            String key = prepKeyHelper(strs[i]);

            if(!map.containsKey(key))
            {
                temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(key, temp);
            }
            else
            {
            	map.get(key).add(strs[i]);
                //map.put(key, temp);
            }

        }
        List<List<String>> res = new ArrayList<>();
        for(String key : map.keySet())
        {
        	res.add(map.get(key));
        }
        	
        return res;
        
    }

    private String prepKeyHelper(String str)
    {
        int[] chartracker = new int[26];
        for(int i=0;i<str.length();i++)
        {
            chartracker[(str.charAt(i)-'a')]++;
        }
        return Arrays.toString(chartracker); // fixed!
    }
}
