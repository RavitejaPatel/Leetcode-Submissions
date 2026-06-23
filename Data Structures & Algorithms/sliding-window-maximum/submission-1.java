
class Solution 
{
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        Deque<Integer> dq = new ArrayDeque<>();
        int N = nums.length;
        int[] res = new int[N-k+1];
        int j=0;
        
        for(int i=0;i<nums.length;i++)
        {
        int curr = nums[i];
        while(!dq.isEmpty() && i-k >= dq.getFirst())
        {
            dq.removeFirst();
        }
        while(!dq.isEmpty() && curr>=nums[dq.getLast()])
        {
            dq.removeLast();
        }
        dq.add(i);
        
        if(i-(k-1)>=0)
            res[j++] = nums[dq.peekFirst()];
        
        }
        
        for(int l : res)
            System.out.print(l+" ");
            
        return res;
    }  
}


// class Solution 
// {
//     public int[] maxSlidingWindow(int[] nums, int k) 
//     {
//         int N = nums.length;
//         int[] res = new int[N-k-1];
//         int j=0;
//         int st=0;
//         int ed=k-1;
        
//         while(st<=ed && st<N-k)
//         {
//             if( (ed-st)+1 >= k)
//             {
//                 res[j++] = storeMaxNumFromGivenRange(st,ed,nums);
//                 st++;
//             }
//             ed++;
//         }
//         return res;
//     }
//     private int storeMaxNumFromGivenRange(int st, int ed, int[] nums)
//     {
//         System.out.println(st+" "+ed);
//         int maxSoFar = Integer.MIN_VALUE;

//         while(st<=ed)
//         {
//             maxSoFar = Math.max(maxSoFar, nums[st]);
//             st++;
//         }
//         return maxSoFar;
//     }
// }
