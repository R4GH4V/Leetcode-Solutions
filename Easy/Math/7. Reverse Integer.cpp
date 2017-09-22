Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.


class Solution {
public:
    int reverse(int x) {
        long long rev=0;
        while(x){
            rev=rev*10+x%10;
            x=x/10;
        }
        return (rev>INT_MAX || rev<INT_MIN)?0:rev;
    }
};
