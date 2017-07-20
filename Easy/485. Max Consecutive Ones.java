Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000


public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count,max;
        count=max=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==1)
                count++;
            if(nums[i]==0)
                count=0;
            if(max<count)
                max=count;            
        }
            return max;
    }
}
