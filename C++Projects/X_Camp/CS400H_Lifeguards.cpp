#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0); 
    cin.tie(0);

    int n; cin >> n;
    vector<pair<int, pair<int, int>>> events; 
    for(int i=0; i<n; i++){
        int s, e; cin >> s >> e;
        events.push_back(make_pair(s, make_pair(i, 1)));
        events.push_back(make_pair(e, make_pair(i, -1)));
    }
    //(time, (idx, s/e))

    sort(events.begin(), events.end());

    set<int> pool;
    int alone_times[n];
    memset(alone_times, 0, sizeof(alone_times));
    int prevTime = -1;
    int totalTime = 0;

    for(int i=0; i<2*n; ){
        int currTime = events[i].first;

        if(pool.size()==1){
            int idx = *pool.begin();
            alone_times[idx] += currTime - prevTime;
        }
        if(pool.size()>0){
            totalTime += currTime-prevTime;
        }

        while(i<2*n && events[i].first==currTime) {
            if(events[i].second.second==1){
                pool.insert(events[i].second.first);
            }
            else pool.erase(events[i].second.first);
            i++;
        }

        prevTime = currTime;
    }

    int ans=INT_MAX;
    for(int i=0; i<n; i++){
        ans = min(ans, alone_times[i]);
    }
    cout << totalTime-ans << endl;

}