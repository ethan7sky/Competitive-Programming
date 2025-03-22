#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int T, N, M;
const int MAX_N = (int)1e5+5;
vector<int> adj[MAX_N];
vector<int> temp;
bool v[MAX_N];
ll minCost;

void dfs(int c, int p) {
    if(v[c]) return;
    v[c] = true;
    temp.push_back(c);
    for(int i: adj[c]) {
        dfs(i, c);
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while(T--) {
        cin >> N >> M;

        for(auto &i: adj) i.clear();
        for(int i=0; i<M; i++){
            int x, y; cin >> x >> y;
            adj[x].push_back(y);
            adj[y].push_back(x);
        }  

        for(int i=1; i<=N; i++) v[i] = false;

        vector<vector<int>> connected;
        vector<int> c1, cN;

        temp.clear();
        dfs(1, -1);
        c1 = temp;
        
        //case 1
        if(v[N]) {
            cout << 0 << endl;
            continue;
        }

        for(int i=2; i<N; i++){
            if(!v[i]) {
                temp.clear();
                dfs(i, -1);
                if(v[N] && cN.empty()) {
                    cN = temp;
                } else {
                    connected.push_back(temp);
                }
            }
        }
        if(!v[N]){
            cN = {N};
        }


        minCost = LLONG_MAX;
        
        //case 2
        c1.push_back(-(int)1e6); c1.push_back((int)1e6);
        cN.push_back(-(int)1e6); cN.push_back((int)1e6);
        sort(c1.begin(), c1.end());
        sort(cN.begin(), cN.end());

        vector<int> cDistFrom1 = {-1};
        vector<int> cDistFromN = {-1};

        for(int i=1; i<=N; i++){

            auto ptr = lower_bound(c1.begin(), c1.end(), i);
            int l = *(ptr-1);
            int r = *ptr;
            cDistFrom1.push_back(min(abs(i-l),abs(i-r)));
            
            ptr = lower_bound(cN.begin(), cN.end(), i);
            l = *(ptr-1);
            r = *ptr;
            cDistFromN.push_back(min(abs(i-l),abs(i-r)));
        }


        //case 2
        for(int i=1; i<=N; i++){
            minCost = min(minCost, (ll)cDistFrom1[i]*cDistFrom1[i]+(ll)cDistFromN[i]*cDistFromN[i]);
        }

        //case 3
        for(vector<int> &i: connected) {
            ll minCostFrom1 = LLONG_MAX;
            ll minCostToN = LLONG_MAX;

            for(int j: i) {
                minCostFrom1 = min(minCostFrom1, (ll)cDistFrom1[j]*cDistFrom1[j]);
                minCostToN = min(minCostToN, (ll)cDistFromN[j]*cDistFromN[j]);
            }

            minCost = min(minCost, minCostFrom1+minCostToN);
        }

        cout << minCost << endl;
    }


}