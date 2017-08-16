Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.


Using HashMap:

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!hmap.containsKey(nums[i]))
                hmap.put(nums[i], 1);
            else
                hmap.put(nums[i], hmap.get(nums[i])+1);
            if(hmap.get(nums[i]) > Math.floor(nums.length/2))
                return nums[i];
        }
        return 0;
    }
}


Using Moore's Voting Algorithm to find Majority element:

public class Solution {
    public int majorityElement(int[] nums) {
           int major=nums[0],count=1,n=nums.length;
            for(int i=1;i<n;i++)
            {
                if(count==0)
                {
                    major=nums[i];
                    count=1;
                }
                else
                {
                    count+=(nums[i]==major)?1:-1;
                }
            }
        return major;
    }
}
