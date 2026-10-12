class Solution {
    public int[] dailyTemperaturesn2(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = 0; i<n; i++){
            int count = 1;
            int j = i+1;
            while(j<n){
                if(temperatures[j]>temperatures[i]){
                    break;
                }
                j++;
                count++;
            }
            count = (j==n) ? 0 : count;
            res[i] = count;
        }
        return res;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i<temperatures.length; i++){
            int t = temperatures[i];
            while(!stack.isEmpty() && t > stack.peek()[0]){
                int[] pair = stack.pop();
                res[pair[1]] = i-pair[1];
            }
            stack.push(new int[]{t,i});
        }
        return res;
    }
}
