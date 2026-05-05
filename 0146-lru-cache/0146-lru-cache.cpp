class LRUCache {
    list<pair<int,int>> dll;
    int capacity;
    unordered_map<int,list<pair<int,int>>::iterator> ourmap;
public:
    LRUCache(int capacity) {
        this->capacity = capacity;
    }
    
    int get(int key) {
        if(ourmap.find(key)==ourmap.end()) return -1;
        auto it = ourmap[key];
        int k = it->first;
        int value = it->second;
        dll.erase(it);
        dll.push_front({key,value});
        ourmap[key] = dll.begin();
        return value;
    }
    
    void put(int key, int value) {
        if(ourmap.find(key)!=ourmap.end()) {
            dll.erase(ourmap[key]);
            ourmap.erase(key);
        } 
        if(dll.size()<capacity) {
            dll.push_front({key,value});
            ourmap[key]=dll.begin();
        } else {
            auto it = dll.end();
            it--;
            int k = it->first;
            int v = it->second;
            dll.erase(it);
            ourmap.erase(k);
            dll.push_front({key,value});
            ourmap[key]=dll.begin();
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */