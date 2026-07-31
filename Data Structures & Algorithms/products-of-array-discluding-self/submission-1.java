class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zeros = 0;
        for(int num:nums){
            if(num!=0){
                prod*=num;
            } else {
                zeros++;
            }
        }
        if(zeros>1){
            return new int[nums.length];
        }
        int[] res = new int[nums.length];
        for(int i = 0; i<nums.length;i++){
            if(zeros>0){
                res[i]=(nums[i]==0)?prod:0;
            } else {
                res[i]=prod/nums[i];
            }
        }
        return res;
    }

    public int[] productExceptSelfBF(int[] nums) {
        int[] p = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            int prod = 1;
            for(int j = 0; j<nums.length; j++){
                if(i!=j){
                    prod*=nums[j];
                }
            }
            p[i] = prod;
        }
        return p;
    }
}  
