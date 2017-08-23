Start from integer 1, remove any integer that contains 9 such as 9, 19, 29...
So now, you will have a new integer sequence: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...

Given a positive integer n, you need to return the n-th integer after removing. Note that 1 will be the first integer.

Example 1:
Input: 9
Output: 10
Hint: n will not exceed 9 x 10^8.

//To remove 9 we can change the base of the number from Decimal to 9-Base
//This can be done using Radix-9 toString(n,radix)

class Solution {
    public int newInteger(int n) {        
        return Integer.parseInt(Integer.toString(n,9));
    }
}


//Self Implemented.

class Solution{
    public int newInteger(int n){
      int base=1;
      int ans=0;
      while(n)
      {
        n=n/9;        
        ans=n%9*base;
        base*=10;
        }
        return ans;
     }      
