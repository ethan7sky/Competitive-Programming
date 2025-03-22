#include<bits/stdc++.h>
using namespace std;
using ll = long long;

const int MOD = 998244353; 
const int MAX_N = 1e6;
ll inv[MAX_N+1];

void euclid_inv() {
    inv[1] = 1;
    for(int i=2; i<=MAX_N; i++){
        inv[i] = MOD - (ll)(MOD/i)*inv[MOD%i]%MOD;
    }
}

int main() {

    euclid_inv();

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    

}