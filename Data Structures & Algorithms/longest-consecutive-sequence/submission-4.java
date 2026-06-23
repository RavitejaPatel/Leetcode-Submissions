class Solution {
  public int longestConsecutive(int[] nums) 
	{
		if(nums.length<=1)
			return nums.length;
		
		Set<Integer> set = new HashSet<>();
		
		for(int n : nums)
			set.add(n);
		
		int consecutiveSeqLen = 0;
		
		for(int i=0;i<nums.length;i++)
		{
			int curr = nums[i];
			
			int ltIdx = i;
			int rtIdx = i;
			
			int ltLen=0;
			int rtLen=0;
			
//			while(ltIdx>=0)
//			{
//				if(set.contains(curr-1))
//					ltLen++;
//				else
//					break;
//				
//				ltIdx--;
//			}
			
			while(set.contains(--curr))
			{		
				ltLen++;	
			}
			
			curr = nums[i];
			
			while(set.contains(++curr))
			{		
				rtLen++;	
			}
			
//			while(rtIdx<nums.length)
//			{
//				if(set.contains(curr+1))
//					rtLen++;
//				else
//					break;
//				rtIdx++;
//			}
			
			consecutiveSeqLen = Math.max(consecutiveSeqLen, ltLen+rtLen+1);
		}
		
		return consecutiveSeqLen;
		
	}
}


// [0 3 2 5 4 6 1]
// int length = 0;
// Set<Integer> set = new HashSet<>();
// for(int n : nums)
// {
//     set.add(n);
// }

// for(i=0;i<nums.length;i++)
// {
//     int prev = nums[i]-1;//i=1 prev=2
//     int next = nums[i]+1;//i=1 next = 4

//     while(set.contains(prev))
//     {
//         prev--;//1 0
//     }
//     while(set.contains(next))
//     {
//         next++;//5 6 
//     }

//     length = Math.Max(length, (next-prev)-1);
// }
// return length;
