Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.


Recursive solution:

class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}


Iterative solution:

class Solution {
    public int trailingZeroes(int n) {
        int sum=0;
        while(n>0)
        {
            n=n/5;
            sum+=n;            
        }
        return sum;
    }
}
