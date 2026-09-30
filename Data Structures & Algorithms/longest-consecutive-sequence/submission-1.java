class Solution {

    public int longestConsecutiveOLD(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int r = 0, c = nums[0], l = 0, i = 0;
        while(i<nums.length){
            if(c!=nums[i]){
                c = nums[i];
                l = 0;
            }
            while(i<nums.length && nums[i] == c){
                i++;
            }
            l++;
            c++;
            r = Math.max(r, l);
        }
        return r;
    }

    public int longestConsecutiveBF(int[] nums) {
        int r = 0;
        Set<Integer> s = new HashSet<>();
        for(int num : nums){
            s.add(num);
        }
        for(int num:nums){
            int l = 0, cur = num;
            while(s.contains(cur)){
                l++;
                cur++;
            }
            r = Math.max(r, l);
        }
        return r;
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int r = 0;
        int l = 0;
        int c = nums[0];
        int i = 0;
        while(i<nums.length){
            if(nums[i]!=c){
                l=0;
                c=nums[i];
            }
            while(i<nums.length && c==nums[i]){
                i++;
            }
            l++;
            c++;
            r =Math.max(r,l);
        }
        return r;
    }
}
