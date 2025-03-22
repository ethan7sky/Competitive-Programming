#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll n;

const ll MAX_N = 1e12;


int main() {
    cin >> n;

    int sum = 0;
    for(ll i=2; i*i<=n; i++){
        int cnt=0;
        while(n%i==0){
            cnt++; n/=i;
        }

        int power=1;
        while(power<=cnt){
            sum++;
            cnt -= power;
            power++;
        }
    }
    if(n>1) sum++;
    cout << sum;
}