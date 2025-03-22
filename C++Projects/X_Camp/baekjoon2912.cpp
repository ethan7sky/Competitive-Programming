#include <bits/stdc++.h>
using namespace std;

int main() {
    
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int N, C, M; cin >> N >> C;

    vector<int> a;
    for(int i=0; i<N; i++){
        int x; cin >> x;
        a.push_back(x);
    }

    vector<vector<int>> c;
    c.resize(C+1);
    for(int i=0; i<N; i++){
        c[a[i]].push_back(i+1);
    }

    // for(auto i: c){
    //     for(int j: i){
    //         cout << j << " ";
    //     }cout << endl;
    // }

    cin >> M;
    while(M--) {
        int A, B; cin >> A >> B;
        bool works = false;

        for(int i=1; i<=C; i++){
            if(c[i].size()==0) continue;

            int idx1 = lower_bound(c[i].begin(), c[i].end(), A) - c[i].begin();
            int idx2 = lower_bound(c[i].begin(), c[i].end(), B) - c[i].begin();

            if(c[i][idx2] != B) idx2--;

            int cnt = idx2-idx1+1;

            if(cnt > (B-A+1)/2.0) {
                works = true;
                cout << "yes " << i << endl;
                break;
            }
        }
        if(!works) {
            cout << "no" << endl;
        }
    }

}