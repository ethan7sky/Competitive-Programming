#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0); 
    cin.tie(0);

    int n; cin >> n;
    vector<pair<int, int>> events; 
    for(int i=0; i<n; i++){
        int s, e; cin >> s >> e;
        events.push_back(make_pair(s, 1));
        events.push_back(make_pair(e+1, -1));
    }

    sort(events.begin(), events.end());

    int cnt=0; 
    int freq=-1;
    int ans=0;
    for(int i=0; i<2*n; ){
        int time = events[i].first;
        while(i<2*n && events[i].first==time) {
            cnt+=events[i].second;
            i++;
        }
        if(cnt>freq){
            freq = cnt;
            ans = time;
        }
    }

    cout << ans << endl;
}