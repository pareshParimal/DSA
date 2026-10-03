class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int currProduct = 1;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            currProduct = currProduct * nums[i];
            maxProduct = Math.max(maxProduct, currProduct);
            if (nums[i] == 0) {
                currProduct = 1;
            }
        }

        currProduct = 1;

        for (int i = len - 1; i >= 0; i--) {
            currProduct = currProduct * nums[i];
            maxProduct = Math.max(maxProduct, currProduct);
            if (nums[i] == 0) {
                currProduct = 1;
            }
        }

        return maxProduct;
    }
}
