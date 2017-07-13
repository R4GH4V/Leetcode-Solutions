You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int c,sum=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]==1)
                {
                    c=4;
                    if((j-1)>=0 && (j-1)<=m-1 && grid[i][j-1]==1)     //Left Element
                        c--;
                    if((j+1)>=0 && (j+1)<=m-1 && grid[i][j+1]==1)     //Right Element
                        c--;
                    if((i-1)>=0 && (i-1)<=n-1 && grid[i-1][j]==1)     //Above Element
                        c--;
                    if((i+1)>=0 && (i+1)<=n-1 && grid[i+1][j]==1)     //Below Element
                        c--;   
                    sum=sum+c;
                }
        return sum;
    }
}

*/
 Elegant Solution by observing the pattern and framing a formula:

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}

*/
