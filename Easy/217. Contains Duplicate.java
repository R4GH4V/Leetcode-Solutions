Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.


Solution using HashSet:

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet m=new HashSet();
        for(int x:nums)
            m.add(x);
        if(m.size()!=nums.length)
            return true;
        else
            return false;
    }
}
