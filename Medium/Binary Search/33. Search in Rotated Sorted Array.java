Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.




class Solution {
public int search(int A[], int target) {
        int n=A.length;
        if (n == 0) return -1;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left+(right-left)/2;
            if (A[mid] == target) return mid;
            else if (A[mid] < A[right]) {
                if (A[mid] < target && A[right] >= target) left = mid + 1;
                else right = mid - 1;
            } else {
                if (A[left] <= target && A[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }
};
