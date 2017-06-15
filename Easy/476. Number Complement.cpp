/*
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

*/

class Solution {
public:

int complement(int n)
{
 int i,b[32],s_i,comp=0;
 for(i=31;i>=0;i--)
 b[31-i]=(n>>i)&1;
 for(i=0;i<32;i++)
 if(b[i]==1)
 {
     s_i=i;
     break; 
}
for(i=s_i;i<32;i++)
b[i]=!b[i];
for(i=31;i>=0;i--)
comp=comp+b[i]*pow(2,31-i);
cout<<comp;
return comp;
}

int findComplement(int num) {
        return complement(num);
    }
};
