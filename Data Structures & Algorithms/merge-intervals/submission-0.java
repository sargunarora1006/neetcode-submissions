class Solution {
    public int[][] mergenlogn(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);
        for(int[] interval: intervals){
            int start = interval[0];
            int end = interval[1];
            int lastEnd = output.get(output.size()-1)[1];
            if(start<=lastEnd){
                output.get(output.size()-1)[1]=Math.max(lastEnd,end);
            } else{
                output.add(new int[]{start,end});
            }
        }
        return output.toArray(new int[output.size()][]);
    }

    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] interval:intervals){
            map.put(interval[0], map.getOrDefault(interval[0],0)+1);
            map.put(interval[1], map.getOrDefault(interval[1],0)-1);
        }
        List<int[]> res = new ArrayList<>();
        int have = 0;
        int[] interval = new int[2];
        for(int point:map.keySet()){
            if(have==0) interval[0]=point;
            have+=map.get(point);
            if(have==0){
                interval[1]=point;
                res.add(new int[] {interval[0], interval[1]});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
