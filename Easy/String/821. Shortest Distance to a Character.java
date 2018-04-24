Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 

Note:

S string length is in [1, 10000].
C is a single character, and guaranteed to be in string S.
All letters in S and C are lowercase.





class Solution {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        
        int prev = Integer.MIN_VALUE/2;
        for(int i=0;i<n;i++){
            if(S.charAt(i)==C) prev=i;
            res[i] = i-prev;
        }
        
        prev= Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            if(S.charAt(i)==C) prev=i;
            res[i] = Math.min(res[i], prev-i);
        }
        return res;        
    }
}
