class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product =1, start = 0,end =0;
        int count = 0;
        int n = nums.length;

        while(end < n){
            product *= nums[end];

            while(product >= k && start <= end){
                product /= nums[start];
                start++;
            }
            count += 1 + (end - start);
            end++;
        }
        return count;
    }
}
