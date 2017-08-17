iven a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.


public class Solution {
    public int romanToInt(String s) {
        int sum=0;
        char c[]=s.toCharArray();
        for(int i=c.length-1;i>=0;i--)
        {
            if(c[i]=='I') sum+=(sum<5?1:-1);
            else if(c[i]=='V') sum+=5;
            else if(c[i]=='X') sum+=(sum<50?10:-10);
            else if(c[i]=='L') sum+=50;
            else if(c[i]=='C') sum+=(sum<500?100:-100);
            else if(c[i]=='D') sum+=500;
            else if(c[i]=='M') sum+=1000;
            else continue;
        }
        return sum;
    }
}
