class Solution {
    public int trapBF(int[] height) {
        if(height == null || height.length == 0)
         return 0;
        int n = height.length;
        int res = 0;
        for( int i = 0; i<n; i++){
            int leftmax = height[i];
            int rightmax = height[i];
            for(int j = 0; j<i; j++){
                leftmax = Math.max(leftmax, height[j]);
            }
            for(int j = i+1; j<n; j++){
                rightmax = Math.max(rightmax, height[j]);
            }
            res+=Math.min(leftmax, rightmax) - height[i];
        }
        return res;
    }

    public int trap(int[] height) {
        if(height == null || height.length == 0)
         return 0;
        int n = height.length;
        int res = 0;
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        leftmax[0] = height[0];
        for(int i = 1; i< n; i++){
            leftmax[i] = Math.max(leftmax[i-1],height[i]);
        }
        rightmax[n-1] = height[n-1];
        for(int i = n-2; i>=0; i--){
            rightmax[i] = Math.max(rightmax[i+1],height[i]);
        }
        for(int i = 0; i<n; i++){
            res+=Math.min(leftmax[i],rightmax[i]) - height[i];
        }
        return res;
    }
}
