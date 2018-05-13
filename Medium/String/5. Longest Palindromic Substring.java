Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"



class Solution {
    private int lo, maxLength;
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len<2){
            return s;
        }
        for(int i=0; i<len; i++){
            extendPalindrome(s,i,i);
            extendPalindrome(s,i,i+1);
        }
        return s.substring(lo,lo+maxLength);
    }
    
    public void extendPalindrome(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j) ){
            i--;
            j++;
            if(maxLength<j-i-1){
                lo = i+1;
                maxLength = j-i-1;
            }
        }
    }
}
