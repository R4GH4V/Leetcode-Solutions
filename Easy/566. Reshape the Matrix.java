/*
In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 1, c = 4
Output: 
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
Example 2:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 2, c = 4
Output: 
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
Note:
The height and width of the given matrix is in range [1, 100].
The given r and c are all positive.

*/

Brute Force Solution:

public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int z=0;
        int r1=nums.length;
        int c1=nums[0].length;
        int[] b=new int[r*c];        
        int[][] d=new int[r][c];
        if(r*c!=r1*c1)
            return nums;
        else
        {
            for(int i=0;i<r1;i++)
                for(int j=0;j<c1;j++)
                {
                    b[z]=nums[i][j];
                    z++;
                }       
            z=0;
            for(int i=0;i<r;i++)
                for(int j=0;j<c;j++)
                {
                    d[i][j]=b[z];
                    z++;
                }
            return d;                    
    }
    }
}

Optimized Solution using the fact that the 2d array can be represented as a 1d array and it can be mapped back to a 2d array:

public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
            int n=nums.length; int m=nums[0].length;
            if(n*m!=r*c) return nums;
            int res[r][c]=new int[r][c];
            for(int i=0;i<r*c;i++)
            res[i/c][i%c]=nums[i/m][i%m];
            return res;
    }
}
