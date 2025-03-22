#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 200000;

int N, M;
vector<int> sz;
unordered_set<int> notAdj[MAX_N+1];
set<int> notV;
int componentCnt, currSz;

void dfs(int i);

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;

    for(int i=0; i<M; i++){
        int a, b;
        cin >> a >> b;
        notAdj[a].insert(b);
        notAdj[b].insert(a);
    }

    for(int i=1; i<=N; i++){
        notV.insert(i);
    }

    for(int i=1; i<=N; i++){
        auto it = notV.find(i);
        if(it != notV.end()) {
            notV.erase(i);
            currSz=0;
            dfs(i);
            componentCnt++;
            sz.push_back(currSz);
        } else{
            continue;
        }
    }

    cout << componentCnt << endl;
    sort(sz.begin(), sz.end());
    for(int i: sz) cout << i << " ";
    
}

void dfs(int i) {
    currSz++;
    auto it = notV.begin();
    while(it != notV.end()) {
        if(notAdj[i].count(*it)) {
            it++;
        } else{
            int c = *it;
            notV.erase(it);
            dfs(c);
            it = notV.upper_bound(c);
        }
    }
}