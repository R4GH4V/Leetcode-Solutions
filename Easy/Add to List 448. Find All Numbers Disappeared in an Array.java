Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]


My solution using HashSet in Java (Takes extra space and not very efficient):

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        HashSet kinds=new HashSet();
        for(int i=0;i<n;i++)
            kinds.add(nums[i]);
        List disp=new ArrayList();
        for(int i=1;i<=n;i++)
            if(kinds.contains(i)==false)
                disp.add(i);
        return disp;            
    }
}

Java accepted simple solution (Author: mnv.koundinya)

public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
