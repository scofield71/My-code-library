class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        Set<String> ourset = new HashSet<>();
        for(String d : deadends) ourset.add(d);
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        int move = 0;
        if(ourset.contains("0000")) return -1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size>0) {
                // System.out.println("Hi");
                String org = q.poll();
                StringBuilder val = new StringBuilder(org);
                if(val.toString().equals(target)) return move;
                for(int i=0;i<4;i++) {
                    val = new StringBuilder(org);
                    int p = val.charAt(i) - '0';
                    int forward = (p+1)%10;
                    int backward = p-1;
                    backward = (backward==-1)?9:backward;
                    val.setCharAt(i,(char)(backward+'0'));
                    if(!visited.contains(val.toString()) && !ourset.contains(val.toString())) {
                        visited.add(val.toString());
                        q.add(val.toString());
                    }
                    val.setCharAt(i,(char)(forward+'0'));
                    if(!visited.contains(val.toString()) && !ourset.contains(val.toString())) {
                        visited.add(val.toString());
                        q.add(val.toString());
                    }
                }
                size--;
            }
            move++;
        }
        return -1;
    }
}