Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"







class Solution {
    public String addBinary(String a, String b) {
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        int carry = 0;
        
        StringBuilder res = new StringBuilder();
        
        while(i>=0 && j>=0){
            
            int av = a.charAt(i) == '0' ? 0:1 ;
            int bv = b.charAt(j) == '0' ? 0:1 ;
            
            int v = av + bv + carry;
            res.append(v % 2);
            carry = v / 2;
            
            i--;
            j--;
        }
        
        while (i >= 0){
            
            int av = a.charAt(i) == '0' ? 0:1 ;
            int v = av + carry;
            res.append(v % 2);
            carry = v / 2;
            i--;
        }
        
        while (j >= 0){
            
            int bv = b.charAt(j) == '0' ? 0:1 ;
            int v = bv + carry;
            res.append(v % 2);
            carry = v / 2;
            j--;
        }
        
        if(carry == 1){
            res.append(1);
        }
        
        return res.reverse().toString();
        
    }
}
