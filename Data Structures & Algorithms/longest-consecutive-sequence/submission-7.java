class Solution 
{
   
// public int longestConsecutive(int[] nums) {
//     if (nums == null || nums.length == 0) return 0;

//     Set<Integer> set = new HashSet<>();
//     for (int num : nums) set.add(num);

//     int maxCt = 0;

//     for (int i = 0; i < nums.length; i++) 
//     {
//         int curr = nums[i];

//         if (!set.contains(curr - 1)) 
//         { // start of a sequence
//             int len = 1;
//             int next = curr + 1;

//             while (set.contains(next)) 
//             {
//                 next++;
//                 len++;
//             }

//             maxCt = Math.max(maxCt, len);
//         }
//     }

//     return maxCt;
// }



public int longestConsecutive(int[] nums) 
{
    if (nums == null || nums.length == 0) return 0;

    Set<Integer> set = new HashSet<>();
    for (int num : nums) set.add(num);

    int maxLen = 0;
    for(int i=0;i<nums.length;i++)
    {
        int num = nums[i];

        if(!set.contains(num)) continue;

        set.remove(num);
        int len = 1;

        int left = num-1;

        while(set.contains(left))
        {
            left-=1;
            len++;
        }

        int right = num+1;
        while(set.contains(right))
        {
            right+=1;
            len++;
        }

        maxLen = Math.max(maxLen,len);
    }
    return maxLen;
}


//by removing values from set


// public int longestConsecutive(int[] nums) {
//     if (nums == null || nums.length == 0) return 0;

//     Set<Integer> set = new HashSet<>();
//     for (int num : nums) set.add(num);

//     int maxLen = 0;

//     for (int num : nums) {
//         // If num was already consumed as part of another sequence, skip
//         if (!set.contains(num)) continue;

//         // Remove the anchor and expand both sides
//         set.remove(num);
//         int len = 1;

//         // Expand left
//         int left = num - 1;
//         while (set.remove(left)) {  // remove returns true if element was present
//             left--;
//             len++;
//         }

//         // Expand right
//         int right = num + 1;
//         while (set.remove(right)) {
//             right++;
//             len++;
//         }

//         maxLen = Math.max(maxLen, len);
//     }

//     return maxLen;
// }


}
