A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.



//Beats 100% Java Solutions :)

class Solution {
    public int findPeakElement(int[] nums) {
       return helper(nums,0,nums.length-1);
    }
    public int helper(int[] nums,int l,int r)
    {
        if(l==r)
            return l;
        else if(r==l+1)
        {
            if(nums[r]>nums[l]) return r;
            return l;
        }
        else
        {
            int m=l+(r-l)/2;
            if(nums[m]>nums[m-1] && nums[m]>nums[m+1]) return m;
            else if(nums[m-1]>nums[m] && nums[m]>nums[m+1]) return helper(nums,l,m-1);
            else return helper(nums,m+1,r);
        }
    }
}
