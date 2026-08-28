class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        int maxSubarraySum = nums[0];
        int currentMax = 0;
        
        int minSubarraySum = nums[0];
        int currentMin = 0;
        
        for (int num : nums) {
            totalSum += num;
  
            currentMax = Math.max(num, currentMax + num);
            maxSubarraySum = Math.max(maxSubarraySum, currentMax);
          currentMin = Math.min(num, currentMin + num);
            minSubarraySum = Math.min(minSubarraySum, currentMin);
        }
        if (maxSubarraySum < 0) {
            return maxSubarraySum;
        }
        
        return Math.max(maxSubarraySum, totalSum - minSubarraySum);
    }
}


Input
nums =
[1,-2,3,-2]
Output
3
Expected
3
