Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.


Using Sorting:      //first we convert the strings to character arrays and then sort it, and then compare individual characters to be same.

public class Solution {
    public boolean isAnagram(String s, String t) {
            char[] c=s.toCharArray();
            char[] d=t.toCharArray();
            if(c.length!=d.length)
                return false;
            Arrays.sort(c);
            Arrays.sort(d);
            int n=c.length;
            for(int i=0;i<n;i++)
            {
                if(c[i]!=d[i])
                return false;
            }
        return true;
    }
}


More Element solution using array:

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] a=new int[26];
        for(int i=0;i<s.length();i++) a[s.charAt(i)-'a']++;
        for(int i=0;i<t.length();i++) a[t.charAt(i)-'a']--;
        for(int i:a) if(i!=0)return false;
        return true;
    }
}


Note: If all unicode characters are to be stored then a HashMap would be used.
