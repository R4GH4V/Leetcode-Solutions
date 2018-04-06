Write a function to find the longest common prefix string amongst an array of strings.



14 ms Solution in Java:

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        String lcp=strs[0];
        for(int i=1;i<strs.length;i++)
        {
            String currString=strs[i];
            int j=0;
            while(j<currString.length() && j<lcp.length() && currString.charAt(j)==lcp.charAt(j))
            {
                j++;
            }
            if(j==0){
                return "";
            }
            lcp=currString.substring(0,j);
            
        }
        return lcp;
    }
}



-------------

11 ms solution in Java.

class Solution {
   public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    String pre = strs[0];
    for (int i = 1; i < strs.length; i++)
        while(strs[i].indexOf(pre) != 0)
            pre = pre.substring(0,pre.length()-1);
    return pre;
}
}
