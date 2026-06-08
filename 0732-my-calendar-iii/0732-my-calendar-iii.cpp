class MyCalendarThree {
public:
    map<int,int> ourmap;
    MyCalendarThree() {
        
    }
    
    int book(int startTime, int endTime) {
        ourmap[startTime]++;
        ourmap[endTime]--;
        int ans = 0;
        int sum = 0;
        for(auto& it:ourmap) {
            sum+=it.second;
            ans=max(ans,sum);
        }
        return ans;
    }
};

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree* obj = new MyCalendarThree();
 * int param_1 = obj->book(startTime,endTime);
 */