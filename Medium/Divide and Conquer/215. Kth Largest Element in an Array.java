Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.







class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return Integer.MAX_VALUE;
        shuffle(nums);
        return findKthLargest(nums, 0, nums.length-1, nums.length-k);
    }
    public int findKthLargest(int[] nums, int start, int end, int k){
        if(start > end) return Integer.MAX_VALUE;
        int pivot = nums[end];
        int left = start;
        for(int i = start; i < end; i++){
            if(nums[i] <= pivot){
                swap(nums, left++, i);
            }
        }
        swap(nums, left, end);
        
        if(left == k) return nums[left];
        else if(left < k) return findKthLargest(nums, left+1, end, k);
        else return findKthLargest(nums, start, left -1, k);
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }
}
