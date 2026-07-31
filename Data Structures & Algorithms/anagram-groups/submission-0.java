class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> r = new HashMap<>();
        for(String s : strs){
            int[] count = new int[26];
            for(char c:s.toCharArray()){
                count[c - 'a']++;
            }
            String k = Arrays.toString(count);
            r.putIfAbsent(k, new ArrayList<>());
            r.get(k).add(s);
        }
        return new ArrayList<>(r.values());
    }
}
