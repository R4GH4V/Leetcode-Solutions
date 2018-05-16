The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I



Solution using an Array of StringBuilder:

class Solution {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int n = c.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0; i < numRows ; i++) sb[i]= new StringBuilder();
        
        int i=0 ;
        while(i< n){
            for(int idx=0; idx< numRows && i< n; idx++){              //Going Down vertically
                sb[idx].append(c[i++]);
            }
            for(int idx= numRows-2; idx>= 1 && i< n; idx--){          //Going Up obliquely
                sb[idx].append(c[i++]);
            }
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder x: sb){
            res.append(x).toString();
        }
        return res.toString();
    }
}


Solution using ArrayList of StringBuilder and logic for goingdown and going up:

class Solution {
    public String convert(String s, int numRows) {
        
        if(s == null || s.length()<2 || numRows<2){
            return s;
        }
        boolean isGoingDown = true;
        int index = 0;
        List<StringBuilder> list = new ArrayList<>();
        
        for(int i=0; i< numRows ; i++){
            list.add(new StringBuilder());
        }
        
        for(int i=0; i<s.length(); i++){
            list.get(index).append(s.charAt(i));
            if(isGoingDown){
                if(index == numRows-1){
                    index = numRows-2;
                    isGoingDown = false;
                }
                else
                    index++;
            }
            else{
                if(index == 0){
                    index = 1;
                    isGoingDown = true;
                }
                else
                    index--;
            }            
        }
        StringBuilder res = new StringBuilder();
        
        for(StringBuilder sb : list){
            res.append(sb).toString();
        }
        
        return res.toString();        
    }
}
