Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.



class Solution {
    public int maxProduct(int[] nums) {
         int n=nums.length;
        int r=nums[0];
        for(int i=1,imin=r,imax=r;i<n;i++)
        {
            if(nums[i]<0)
            {
                int temp=imin;
                imin=imax;
                imax=temp;
            }            
            imin=Math.min(nums[i],nums[i]*imin);
            imax=Math.max(nums[i],nums[i]*imax);
            
            r=Math.max(r,imax);
        }
        return r;   
    }
}
