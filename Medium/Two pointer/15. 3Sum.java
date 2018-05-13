Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]




class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int lo = i+1, hi =nums.length-1, sum=0-nums[i];
                while(lo<hi){
                    if(sum == nums[lo]+nums[hi]){
                        res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        while(lo<hi && nums[lo]==nums[lo+1]) lo++;      //remove duplicates
                        while(lo<hi && nums[hi]==nums[hi-1]) hi--;      //remove duplicates
                        lo++; hi--;
                    }
                    else if(nums[lo]+nums[hi]< sum) lo++;
                    else hi--;
                }
            }             
        }    
               return res;
    }
}
