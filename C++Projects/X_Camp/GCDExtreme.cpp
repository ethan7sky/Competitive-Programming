#include<bits/stdc++.h>
using ll = long long;
using namespace std;
const ll MAX_N = 1e6;

vector<ll> phi(MAX_N+1);
vector<ll> ans(MAX_N+1);

void precomp() {
    for(int i=1; i<=MAX_N; i++) phi[i] = i;
    for(int i=2; i<=MAX_N; i++){
        if(phi[i]==i){
            for(int j=i; j<=MAX_N; j+=i){
                phi[j] -= phi[j]/i;
            }
        }
    }
    for(int i=1; i<=MAX_N; i++){
        for(int j=i*2; j<=MAX_N; j+=i){
            ans[j] += phi[j/i]*i;
        }
    }
    for(int i=1; i<=MAX_N; i++){
        ans[i] += ans[i-1];
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    precomp();

    int n; cin >> n;
    while(n){
        cout << ans[n] << endl;
        cin >> n;
    }
}