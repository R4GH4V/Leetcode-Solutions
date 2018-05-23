Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.




class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        HashSet<Character> set = new HashSet<>();
        int i=0;
        int j=0;
        
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j-i);
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}