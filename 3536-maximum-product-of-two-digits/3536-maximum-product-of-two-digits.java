class Solution {
    public int maxProduct(int n) {
        String s = String.valueOf(n);
        char[] p = s.toCharArray();
        Arrays.sort(p);
        s = new String(p);
        return Integer.parseInt(String.valueOf(s.charAt(s.length()-1)))*Integer.parseInt(String.valueOf(s.charAt(s.length()-2)));
    }
}