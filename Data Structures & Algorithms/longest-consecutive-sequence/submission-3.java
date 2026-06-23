class Solution {
     public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxLen = 0;

        for (int num : set) { // iterate over set (avoid duplicates)
            // Only start counting when 'num - 1' is not in set
            if (!set.contains(num - 1)) {
                int curr = num;
                int temp = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    temp++;
                }

                maxLen = Math.max(maxLen, temp);
            }
        }
        return maxLen;
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
