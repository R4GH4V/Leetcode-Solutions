Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?



class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int x = 0;
        for(int i=0; i < nums.length; i++){
            x = nums[i] ^ x;              //Find XOR of the target numbers
        }
        
        x = x & (-x);     //Last set bit
        
        for(int i=0; i< nums.length; i++){
            if((nums[i]&x) == 0){             //Divide the numbers based on Last set bit of target numbers
                res[0] = res[0] ^ nums[i]; 
            }
            else{
                res[1] = res[1] ^ nums[i];
            }
        }
        return res;
    }
}

Explaination:
If you were stuck by this problem, it's easy to find a solution in the discussion. However, usually, the solution lacks some explanations.

I'm sharing my understanding here:

The two numbers that appear only once must differ at some bit, this is how we can distinguish between them. Otherwise, they will be one of the duplicate numbers.

One important point is that by XORing all the numbers, we actually get the XOR of the two target numbers (because XORing two duplicate numbers always results in 0). Consider the XOR result of the two target numbers; if some bit of the XOR result is 1, it means that the two target numbers differ at that location.

Let’s say the at the ith bit, the two desired numbers differ from each other. which means one number has bit i equaling: 0, the other number has bit i equaling 1.

Thus, all the numbers can be partitioned into two groups according to their bits at location i.
the first group consists of all numbers whose bits at i is 0.
the second group consists of all numbers whose bits at i is 1.

Notice that, if a duplicate number has bit i as 0, then, two copies of it will belong to the first group. Similarly, if a duplicate number has bit i as 1, then, two copies of it will belong to the second group.

by XoRing all numbers in the first group, we can get the first number.
by XoRing all numbers in the second group, we can get the second number.



Using HashMap :

class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        for(int i =0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else
            {
                map.put(nums[i], 1);
            }
        }
        int i=0;
                for(Integer x: map.keySet()){
                    if(map.get(x)==1)
                        res[i++]= x;
                }
            return res;
        }
    }
