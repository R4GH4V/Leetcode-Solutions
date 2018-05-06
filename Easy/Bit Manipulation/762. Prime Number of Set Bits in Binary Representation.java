Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.

(Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)

Example 1:

Input: L = 6, R = 10
Output: 4
Explanation:
6 -> 110 (2 set bits, 2 is prime)
7 -> 111 (3 set bits, 3 is prime)
9 -> 1001 (2 set bits , 2 is prime)
10->1010 (2 set bits , 2 is prime)
Example 2:

Input: L = 10, R = 15
Output: 5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
Note:

L, R will be integers L <= R in the range [1, 10^6].
R - L will be at most 10000.



class Solution {
    public int countPrimeSetBits(int L, int R) {
        int count=0;
        for(int i=L;i<=R;i++)
        {
            if(isPrime(setBits(i)))
                count++;
        }
        return count;
    }
    
    public int setBits(int n){
        int count=0;
        while(n>0){
            count++;
            n=n&(n-1);            
        }
        return count;
    }
    
    public boolean isPrime(int c){
        boolean flag = true;
        if(c<2) return false;
        for(int i=2;i<=Math.sqrt(c);i++){
            if(c%i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}


//Considering the bounds of the problem:

class Solution {
    public int countPrimeSetBits(int l, int r) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19 /*, 23, 29 */ ));
        int cnt = 0;
        for (int i = l; i <= r; i++) {
            int bits = 0;
            for (int n = i; n > 0; n >>= 1)
                bits += n & 1;
            cnt += primes.contains(bits) ? 1 : 0;
        }
        return cnt;        
    }
}