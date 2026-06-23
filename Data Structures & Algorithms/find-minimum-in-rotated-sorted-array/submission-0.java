class Solution 
{
    public int findMin(int[] nums) 
    {
        // 3 4 5 6 1 2
        // 0 1 2 3 4 5
        int st = 0;
        int ed = nums.length-1;

        while(st<ed)
        {
            //A rotated sorted array is two increasing runs. The minimum (pivot) 
            //is the only place where an element is less than its previous. 
            //We can detect which half contains the pivot by comparing to the rightmost element.
            // 3 4 5 6 1        2
            // 0 1 2 3 4(pivot) 
            
            int mid = (st+ed)/2;// 2 4
            
            if(nums[mid]>nums[ed])//5>2  1>
                st = mid+1;//3
            else
                ed = mid;//4
        }
        return nums[st];
    }
}



// 3 4 5 6 1 2          while(st<=ed)
// 0 1 2 3 4 5          {
// st ed mid           mid =st+ed/2
 // 0   5   2  //0 // st<mid && nums[mid-1]>nums[mid] && nums[mid]<nums[ed] // return nums[mid]
// 3   5   4          //  else if(nums[mid]>nums[ed])
// 4   5   4                //st=mid+1//
                    //else if (nums[mid] > nums[st] )
                        // ed = mid-1;
                        //}

//4,5,6,7
//st   mid  ed
//0     1(5) 3         
//0          0

//