Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.



class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int lo=0,hi=n-1;
        while(lo<hi)
        {
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<nums[hi])
            {
                hi=mid;
            }
            else if(nums[mid]>nums[hi])
            {
                lo=mid+1;
            }
            else
            {
                hi--;
            }            
        }
        return nums[lo];
    }
}
