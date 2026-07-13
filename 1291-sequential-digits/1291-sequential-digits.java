class Solution {
    public ArrayList<Integer> getCompleteList() {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int digit = 1; digit < 10; digit++) {
            String adder = "";
            String initialVal = "";
            int prev = 0;
            for (int i=0;i<digit;i++) {
                adder+=String.valueOf('1');
                prev++;
                initialVal+=String.valueOf(prev);
            }
            Integer presentVal = Integer.valueOf(initialVal);
            ans.add(presentVal);
            Integer add = Integer.valueOf(adder);
            for (int i=1;i<(10-digit);i++) {
                presentVal+=add;
                ans.add(presentVal);
            }
        }
        return ans;
    }
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> total = getCompleteList();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<total.size();i++) {
            if (total.get(i)>=low && total.get(i)<=high) ans.add(total.get(i));
        }
        return ans;
    }
}