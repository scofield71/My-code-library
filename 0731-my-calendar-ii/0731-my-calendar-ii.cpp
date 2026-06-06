class MyCalendarTwo {
public:
    map<int,int> ourmap;
    MyCalendarTwo() {
        
    }
    
    bool book(int startTime, int endTime) {
        ourmap[startTime]++;
        ourmap[endTime]--;
        int sum = 0;
        for(auto& it:ourmap) {
            sum+=it.second;
            if(sum==3) {
                ourmap[startTime]--;
                ourmap[endTime]++;
                return false;
            }
        }
        return true;
    }
};

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo* obj = new MyCalendarTwo();
 * bool param_1 = obj->book(startTime,endTime);
 */