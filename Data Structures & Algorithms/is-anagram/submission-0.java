class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> cs = new HashMap<>();
        Map<Character, Integer> ct = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            cs.put(s.charAt(i), cs.getOrDefault(s.charAt(i), 0)+1);
            ct.put(t.charAt(i), ct.getOrDefault(t.charAt(i), 0)+1);
        }
        return cs.equals(ct);
    }
}
