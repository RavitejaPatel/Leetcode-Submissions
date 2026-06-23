class Solution 
{
   
public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    Set<Integer> set = new HashSet<>();
    for (int num : nums) set.add(num);

    int maxCt = 0;

    for (int i = 0; i < nums.length; i++) {
        int curr = nums[i];

        if (!set.contains(curr - 1)) { // start of a sequence
            int len = 1;
            int next = curr + 1;

            while (set.contains(next)) {
                next++;
                len++;
            }

            maxCt = Math.max(maxCt, len);
        }
    }

    return maxCt;
}

}
