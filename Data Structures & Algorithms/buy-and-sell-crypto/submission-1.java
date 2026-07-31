class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for(int s:prices){
            max = Math.max(max, s-min);
            min = Math.min(min, s);
        }
        return max;
        //10,1,5,6,7,1
        //max = 0
        //min = 10
        //s = 10
        //max = 0,0 = 0
        //min = 10,10 = 10
        //s = 1
        //max = 0,-9 = 0
        //min = 10,1 = 1
        //s = 5
        //max = 0,4 = 4
        //min = 1,5 = 1
        //s = 6
        //max = 4,5 = 5
        //min = 1,6 = 1
        //s = 7
        //max = 5,6 = 6
        //min = 1,7 = 1
        //s = 1
        //max = 6,0 = 6
        //min = 1,1 = 1
        //return max = 6
    }

    public int twoPointers(int[] prices) {
        int l = 0, r= 1;
        int m = 0;
        while (r<prices.length){
            if(prices[l]<prices[r]){
                int p = prices[r]- prices[l];
                m = Math.max(m,p);
            } else {
                l = r;
            }
            r++;
        }
        return m;
    }

    public int bf(int[] prices) {
        int r = 0;
        for(int i = 0; i<prices.length; i++){
            int b = prices[i];
            for(int j = i+1; j<prices.length; j++){
                int s = prices[j];
                r = Math.max(r, s-b);
            }
        }
        return r;
    }
}
