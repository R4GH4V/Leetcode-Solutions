Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.



class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() == 0) return true;
        int[] recordS = new int[256];
        int[] recordT = new int[256];
        int label = 1;
        for(int i = 0; i < s.length(); i++){
            int charS = s.charAt(i);
            int charT = t.charAt(i);
            if(recordS[charS] != recordT[charT])
                return false;
            if(recordS[charS] == 0){
                recordS[charS] = label;
                recordT[charT] = label;
                label++;
            }
        }
        return true;
    }
}
