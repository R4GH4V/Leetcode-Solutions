Determine whether an integer is a palindrome. Do this without extra space.


class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0) return false;
        int rev=0,num;
        num=x;
        while(x)
        {
            rev=rev*10+x%10;
            x=x/10;
        }
        if(rev==num)
            return true;
        else
            return false;
    }
};


Checking only uptil half of the reverse number.

class Solution{
  public:
    bool isPalindrome(int x){
      if(x<0 || (x!=0 && x%10==0)) return false;
      int sum=0;
      while(x>sum)
      {
        sum=sum*10+x%10;
        x=x/10;
      }
        return (sum==x) || (x==sum/10);
    }
};
