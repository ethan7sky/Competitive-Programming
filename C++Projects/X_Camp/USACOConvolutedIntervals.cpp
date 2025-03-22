#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MAX_N = 2*1e5+5, MAX_M = 5002;
int N, M;
ll begCnt[MAX_M], endCnt[MAX_M];
ll lCnt[MAX_M*2], rCnt[MAX_M*2];

int main() {
    cin.tie(0) -> sync_with_stdio(0);
    cin >> N >> M;
    for(int i=0; i<N; i++){
        int l, r; cin >> l >> r;
        begCnt[l]++;
        endCnt[r]++;
    }
    for(int i=0; i<=M; i++) {
        lCnt[2*i] += begCnt[i]*(begCnt[i]);
        rCnt[2*i+1] += endCnt[i]*(endCnt[i]);
        for(int j=i+1; j<=M; j++){
            lCnt[i+j] += begCnt[i]*begCnt[j]*2;
            rCnt[i+j+1] += endCnt[i]*endCnt[j]*2;
        }
    }
    ll currCnt = 0;
    for(int i=0; i<=2*M; i++){
        // cout <<i<< lCnt[i] << " " << rCnt[i] << endl;
        currCnt += lCnt[i];
        currCnt -= rCnt[i];
        cout << currCnt << "\n";
    }
}