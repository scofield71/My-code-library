class Solution {
    public int minOperations(String s) {
        if (s.length()==1) return 0;
        if (s.length()==2) return s.charAt(0)<=s.charAt(1) ? 0 : -1;
        String p = new String(s);
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        p = new String(chars);
        if (p.compareTo(s)==0) return 0;
        if (p.charAt(0)==s.charAt(0) 
            || p.charAt(p.length()-1)==s.charAt(s.length()-1)) return 1;
        if (p.charAt(0)==s.charAt(s.length()-1)
            && p.charAt(p.length()-1)==s.charAt(0)
            && p.charAt(1)!=s.charAt(s.length()-1)
            && p.charAt(p.length()-2)!=s.charAt(0)) return 3;
        return 2;
    }
}