#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1010;
int N;
int a[MAX_N][MAX_N], ans[MAX_N][MAX_N];
vector<int> available[MAX_N*2];
vector<pair<int, int>> idx[MAX_N*2];
bool v[MAX_N][MAX_N];
int amt[MAX_N*2];

int main(){

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin >> a[i][j];
            amt[a[i][j]]++;
            idx[a[i][j]].push_back({i, j});
        }
    }

    int curr = 2;
    for(int cnt = 1; cnt <=N; cnt++){
        available[cnt].push_back(curr);
        if(cnt != N){
            available[cnt].push_back(2*N-(curr-2));
        }
        curr++;
    }

    // for(int cnt=1; cnt <=N; cnt++){
    //     for(int j: available[cnt]) cout << j << " ";
    //     cout << endl;
    // }

    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            if(!v[i][j]) {
                int newValue = available[amt[a[i][j]]][0];
                available[amt[a[i][j]]].erase(available[amt[a[i][j]]].begin());
                for(pair k: idx[a[i][j]]) {
                    v[k.first][k.second] = true;
                    ans[k.first][k.second] = newValue;
                }
            }
        }
    }

    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cout << ans[i][j];
            if(j!=N-1) cout << " ";
        }cout << "\n";
    }


}