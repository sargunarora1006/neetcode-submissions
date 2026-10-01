class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder ns = new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                ns.append(Character.toLowerCase(c));
            }
        }
        return ns.toString().equals(ns.reverse().toString());
    }
}
