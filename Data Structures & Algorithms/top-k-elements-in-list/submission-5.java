class kRepeatedInfo
{
	int freq;
	int val;
	public kRepeatedInfo(int val, int freq)
	{
		this.freq = freq;
		this.val = val;
	}
}

class Solution 
{
       public int[] topKFrequent(int[] nums, int k) 
	{
	
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int n : nums)
    	{
    		map.put(n, map.getOrDefault(n, 0)+1);
    	}
    	//1,2,2,3,3,3  -> 1-1  2->2 3->3
    	PriorityQueue<kRepeatedInfo> pq = new PriorityQueue<kRepeatedInfo>
    	(
    			(a,b) -> (a.freq - b.freq)
    	);
    	
    	for(int key : map.keySet())
    	{
    		int freq = map.get(key);
    		
    		pq.add(new kRepeatedInfo(key, freq));
    		
    		if(pq.size()>k)
    		{
    			pq.poll();
    		}
    	}
    	int[] res = new int[k];
    	
    	int i=0;
    	while(!pq.isEmpty())
    	{
    		res[i++] = pq.poll().val;
    	}
    	
    	return res;
    	
	}
}


// int[] res = new int[k];
// if(nums.length<=1)
// {
//     res; //[]
// }
//map bucke
//1 - 1
//2 - 2
//3 - 3

//map.get(key)>=k -> result
//List<> result
//
// nums = [2,2,2,2,3,3,3,3,1,1, 5,5], k = 2
//2 - 4
//3 - 4
//1 - 2

//  
//List<Integer> arrList = new ArrayList[];        
    //   [1,5]   [2,3]  []
//[0 1  2   3   4     5    6 ]

//k=2

//arr  - [1]



// for(i=arrList.len-1 -> i>=0)// o(n) + o(n^k) k-> List  o(n)+o(n)
// {
//  List<Integer> currList = arrList[i];
//     //[2,3
//     int j=0;
//     if(currList == null || currList.length<=0)
//         continue;
//     else
//     {
//         for(int curr :currList)
//         {
//             res[j++] = curr;
//         if(j==k)
//         {
//             return result;
//         }

//         }//for
        
//     }

//     return result;

// }

//

//result->array
