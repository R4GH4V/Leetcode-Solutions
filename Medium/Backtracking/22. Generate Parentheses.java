Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]




class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "",0,0,n);
        return res;
    }
    
    public void backtrack(List<String> res, String str, int open, int close, int max){
        if(str.length() == 2*max){
            res.add(str);
            return;
        }
        if(open<max){
            backtrack(res, str+"(", open+1, close,max);
        }
        if(close<open){
            backtrack(res, str+")", open, close+1, max);
        }
    }
}
