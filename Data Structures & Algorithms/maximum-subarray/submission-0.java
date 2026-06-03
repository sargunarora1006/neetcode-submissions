class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            max = Math.max(max, solve(nums, i));
        }
        return max;
    }

    private int solve(int[] nums, int i){
        if(i == 0) return nums[i];
        int prev = solve(nums,i-1);
        return Math.max(nums[i], prev+nums[i]);
    }

    private int dfs(int[] nums, int i, boolean flag){
        if(i == nums.length - 1){//i = 0 // i = 1 // i = 2 // i = 3
            return flag ? Math.max(0, nums[i]) : nums[i]; //
        }
        if(flag){
            return Math.max(0, nums[i]+dfs(nums, i+1, true));
        }
        return Math.max(dfs(nums, i+1, false), nums[i]+dfs(nums,i+1,true));//max(dfs(nums,1,false),dfs(nums,))
    }

    public int bf(int[] nums) {
        int n = nums.length, r = nums[0];
        for (int i = 0; i<n; i++){
            int c = 0;
            for (int j = i; j<n; j++){
                c += nums[j];
                r = Math.max(r, c);
            }
        }
        return r;
    }
}
