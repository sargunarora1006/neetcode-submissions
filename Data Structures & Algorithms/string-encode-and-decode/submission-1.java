class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        StringBuilder r = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for(String str: strs){
            sizes.add(str.length());
        }
        for(int size:sizes){
            r.append(size).append(',');
        }
        r.append('#');
        for(String str:strs){
            r.append(str);
        }
        return r.toString();
    }

    public List<String> decode(String str) {
        if(str.length()==0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while(str.charAt(i) != '#'){
            StringBuilder cur = new StringBuilder();
            while(str.charAt(i) != ','){
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;
        for(int s:sizes){
            res.add(str.substring(i, i+s));
            i+=s;
        }
        return res;
    }
}
