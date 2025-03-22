#include<bits/stdc++.h>
using namespace std;

int T, N, K;

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while(T--) {
        cin >> N >> K;

        set<int> trees;
        for(int i=0; i<N; i++){
            int x; cin >> x;
            trees.insert(x);
        }
        
        map<int, int> chng; //idx, -1 = end of range, 0 = add to cnt, 1 = start of range
        vector<pair<pair<int, int>, int>> ranges;

        for(int i=0; i<K; i++){
            int l, r, t; cin >> l >> r >> t;
            ranges.push_back({{l, r}, t});
            if(chng.count(l)) {
                chng.insert(l, chng[l]+1);
            }
            //  else chng.insert(l, 1);
            // if(chng.count(r+1)) {
            //     chng.insert(r+1, chng[r+1]-1);
            // } else chng.insert(r+1, -1);
        }

        // for(pair<int, int> i: chng) {
        //     cout << i.first << " " << i.second << endl;
        // }



    }
}