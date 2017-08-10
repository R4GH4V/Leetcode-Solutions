Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.


class Solution {
public:
    void swap(int *x,int *y)
    {
        int temp=*x;
        *x=*y;
        *y=temp;
    }
    
    void moveZeroes(vector<int>& nums) {
            int n=nums.size();
            for(int lastnonzero=0,c=0;c<n;c++)
            {
                if(nums[c]!=0)
                {
                    swap(&nums[lastnonzero++],&nums[c]);
                }
            }
    }
};


JAVA Solution:

public class Solution {
    public void moveZeroes(int[] nums) {
            int n=nums.length;
            int c=0;
            for(int i=0;i<n;i++)
            {
                if(nums[i]!=0)
                {
                    nums[c++]=nums[i];
                }                    
            }       
            for(int i=c;i<n;i++)
            {
                nums[i]=0;
            }
        }
}
