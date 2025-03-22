#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MAX_N = 5*(int)1e5+10;
int N;
vector<int> a, b;
ll ans = 0;
vector<int> breedIdx[MAX_N];
vector<int> pref[MAX_N], suff[MAX_N];

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    a.push_back(-1);
    b.push_back(-1);

    for(int i=1; i<=N; i++){
        int x; cin >> x;
        a.push_back(x);
    }
    for(int i=1; i<=N; i++){
        int x; cin >> x;
        b.push_back(x);
        breedIdx[x].push_back(i);
    }
    for(int i=1; i<MAX_N; i++) {
        sort(breedIdx[i].begin(), breedIdx[i].end());
        int sz = breedIdx[i].size();
        pref[i].resize(sz+1);
        suff[i].resize(sz+1);
        pref[i][0] = 0;
        suff[i][sz] = 0;
        int idx=1;
        for(int j: breedIdx[i]) {
            pref[i][idx] = pref[i][idx-1]+j;
            idx++;
        }
        idx = sz-1;
        for(auto it = breedIdx[i].rbegin(); it != breedIdx[i].rend(); it++) {
            suff[i][idx] = suff[i][idx+1]+(N-*it+1);
            idx--;
        }
    }
    for(int i=0; i<4; i++){
        for(int j: pref[i]) cout << j << " ";
        cout << endl;
        for(int j: suff[i]) cout << j << " ";
        cout << endl << endl;
    }


    //solve!
    for(ll i=1; i<=N; i++){
        if(a[i] == b[i]) {
            // ans += i+i*(i-1)/2;
            // ans += (N-i-1) + (N-i-1)*(N-i-2)/2;
        }


    }


}