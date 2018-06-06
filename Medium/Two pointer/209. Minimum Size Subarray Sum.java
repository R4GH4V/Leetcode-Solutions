Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 




class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0;
        int minLength = nums.length + 1;
        
        for(hi = 0; hi < nums.length; hi++){
            sum = sum + nums[hi];
            while(sum >= s){
                minLength = Math.min(minLength, hi - lo + 1);
                sum = sum - nums[lo];
                lo++;
            }
        }
        
        return minLength == nums.length + 1 ? 0 : minLength;
    }
}
