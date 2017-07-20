Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.

public class Solution {
    public boolean detectCapitalUse(String word) {
        boolean flag=true;
        int n=word.length();
        int c=0;
        char[] word_c=word.toCharArray();
        if(Character.isUpperCase(word_c[0]))
            {
                for(int j=1;j<n;j++)
                    if(Character.isUpperCase(word_c[j]))
                    {
                        c++;
                    }
                if(c!=n-1 && c!=0)
                    flag=false;
                return flag;
            }
            else if(Character.isLowerCase(word_c[0]))
            {
                for(int j=1;j<n;j++)
                    if(Character.isUpperCase(word_c[j]))
                    {
                        flag=false;
                        return flag;
                    }
            }
            return flag;
        }
}
