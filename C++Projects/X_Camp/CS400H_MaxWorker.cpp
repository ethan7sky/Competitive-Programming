#include <bits/stdc++.h>
using namespace std;

bool comp(pair<int, int> a, pair<int, int> b) {
    if(a.first==b.first){
        return a.second > b.second;
    }
    return a.first < b.first;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; cin >> n;

    vector<pair<int, int>> events;

    for(int i=0; i<n; i++){
        int a, b; cin >> a >> b;
        events.push_back(make_pair(a, 1));
        events.push_back(make_pair(b, -1));
    }

    sort(events.begin(), events.end(), comp);

    int ans=0;
    int cnt=0;
    for(int i=0; i<n*2; i++){
        cnt += events[i].second;
        ans = max(ans, cnt);
    }
    cout << ans << endl;
}