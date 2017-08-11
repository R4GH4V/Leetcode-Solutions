Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].




public class Solution {
    public int[] twoSum(int[] nums, int target) {
            int[] res=new int[2];
            if(nums==null || nums.length<2)
                return res;
            HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
            int n=nums.length,t;
            for(int i=0;i<nums.length;i++)
            {
                t=target-nums[i];
                if(map.containsKey(t))
                {
                    res[0]=map.get(t);
                    res[1]=i;
                    return res;
                }
                else
                    map.put(nums[i],i);
            }
        return res;
    }
}
