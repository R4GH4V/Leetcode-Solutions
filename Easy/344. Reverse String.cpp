/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

*/

class Solution {
public:
    string reverseString(string s) {
        string rev="";
        int n=s.length();
        for(int i=n-1;i>=0;i--)
        rev+=s[i];
        return rev;
    }
};
