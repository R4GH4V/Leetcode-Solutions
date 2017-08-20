Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.



class Solution {
public:
    int counter(int n)
    {
        int count=0;
        while(n)
        {
            n=n&(n-1);
            count++;
        }
        return count;
    }
    
    vector<int> countBits(int num) {
        vector<int> res;
        for(int i=0;i<=num;i++)
        {
            res.push_back(counter(i));
        }
        return res;
    }
};


Another way: //Count the set bits by shifting bits to right and adding the rightmost bit to it.

class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> res(num+1,0);
        for(int i=0;i<=num;i++) res[i]=res[i>>1]+(i&1);
        return res;
    }
};
