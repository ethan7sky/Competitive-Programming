#include <bits/stdc++.h>

using namespace std;
using ll = long long;


ll shuffle(ll len, ll idx) {
    if(idx%2==0){
        return idx/2;
    }
    else{
        if(len%2==0){
            ll newIdx = (idx+1)/2;
            ll newLen = len/2;
            return newLen + shuffle(newLen, newIdx);
        }
        else{
            if(idx==1){
                return len/2+1;
            }
            ll newIdx = (idx-1)/2;
            ll newLen = len/2;
            return len/2+1 + shuffle(newLen, newIdx);
        }
    }
}

int main(){
    int t; cin >> t;
    while(t--){
        ll n, k;
        cin >> n >> k;
        cout << shuffle(n, k) << endl;
    }
}