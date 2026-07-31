class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];

        int j = 0;
        for (int i = 0; i < n; i++) {
            ans[j++] = nums[i];
            ans[j++] = nums[i + n];
        }

        return ans;
    }
}
OUTPUT:
case1:
Input
nums =
[2,5,1,3,4,7]
n =
3
Output
[2,3,5,4,1,7]
Expected
[2,3,5,4,1,7]
Case 2
Input
nums =
[1,2,3,4,4,3,2,1]
n =
4
Output
[1,4,2,3,3,2,4,1]
Expected
[1,4,2,3,3,2,4,1]
Case 3
Input
nums =
[1,1,2,2]
n =
2
Output
[1,2,1,2]
Expected
[1,2,1,2]
