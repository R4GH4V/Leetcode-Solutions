Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    
    public class Solution {
    public int titleToNumber(String s) {
            int sum=0;
            s=s.toUpperCase();
            int n=s.length();
            for(int i=0;i<n;i++)
            {
                sum=sum*26+(s.charAt(i)-64);
            }
        return sum;
    }
}
