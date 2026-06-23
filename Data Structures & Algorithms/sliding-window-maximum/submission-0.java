
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        if (k == 0 || N == 0) return new int[0];
        if (k == 1) return nums.clone();

        int[] res = new int[N - k + 1];
        int j = 0;

        // Slide windows starting at st = 0..N-k
        for (int st = 0; st <= N - k; st++) {
            int ed = st + k - 1;
            res[j++] = maxInRange(nums, st, ed);
        }
        return res;
    }

    private int maxInRange(int[] nums, int st, int ed) {
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = st; i <= ed; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
        }
        return maxSoFar;
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
