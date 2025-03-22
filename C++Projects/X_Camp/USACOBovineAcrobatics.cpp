#include <bits/stdc++.h>
using namespace std;

using ll = long long;

const int MAX_N = 2*(int)1e5;

int N, M, K;
vector<pair<int, int>> a;
deque<pair<int, int>> d;
ll ans = 0;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> K;

    for(int i=0; i<N; i++){
        int x, y; cin >> x >> y;
        a.push_back({x, y});
    }

    sort(a.begin(), a.end(), greater<pair<int, int>>());

    d.push_back({2*(int)1e9+100, M});

    for(auto it = a.begin(); it != a.end(); it++) {

        pair curr = *it;
        int w = curr.first;
        int remaining = curr.second;

        while(d.size()>0 && remaining>0 && w<=d.front().first-K) {
            pair temp = d.front(); d.pop_front();
            if(temp.second > remaining) {
                d.push_front({temp.first, temp.second-remaining});
                remaining = 0;
            } else{
                remaining -= temp.second;
            }
        }

        int used = curr.second-remaining;
        d.push_back({w, used});
        ans += used;
    }

    cout << ans << endl;
}