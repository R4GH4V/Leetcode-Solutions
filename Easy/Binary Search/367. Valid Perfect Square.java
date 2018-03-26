Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False


class Solution {
    public boolean isPerfectSquare(int num) {
        int lo=1,hi=num;
        while(lo<=hi)
        {
            long mid=lo+(hi-lo)/2;
            if(mid*mid==num)
            {
                return true;
            }
            else if(mid*mid<num)
            {
                lo=(int) mid+1;
            }
            else
            {
                hi=(int) mid-1;
            }
        }
        return false;
    }
}
