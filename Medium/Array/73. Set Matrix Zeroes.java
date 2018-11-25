Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.





class Solution {
    public void setZeroes(int[][] matrix) {
        boolean fr = false, fc = false;
        int r = matrix.length, c = matrix[0].length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }
        if(fr){
            for(int j = 0; j < c; j++){
                matrix[0][j] = 0;
            }
        }
        if(fc){
            for(int i = 0; i < r; i++){
                matrix[i][0] = 0;
            }
        }
    }
}



  // fr = first row
    // fc = first col
    
    // Use first row and first column as markers. 
    // if matrix[i][j] = 0, mark respected row and col marker = 0; indicating
    //  that later this respective row and col must be marked 0;
    // And because you are altering first row and collumn, 
    // you need to  have two variables to track their own status. 
    // So, for ex, if any one of the first row is 0, fr = 0, 
    // and at the end set all first row to 0;
