#include <bits/stdc++.h>
using namespace std;

using ll = long long;

int T, N;
deque<ll> a, b;
ll sum;

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;

    int caseNum = 1;
    while(T-->0) {
        
        a.clear();
        b.clear();
        sum=0;

        cin >> N;
        for(int i=0; i<N; i++){
            ll x; cin >> x;
            a.push_back(x);
        }
        for(int i=0; i<N; i++){
            ll x; cin >> x;
            b.push_back(x);
        }

        sort(a.begin(), a.end());
        sort(b.begin(), b.end());

        // while(a.front()<0 && b.back()>0) {
        //     sum += a.front() * b.back();
        //     a.pop_front();
        //     b.pop_back();
        // } while(b.front()<0 && a.back() > 0){
        //     sum += b.front() * a.back();
        //     b.pop_front();
        //     a.pop_back();
        // }

        while(!a.empty()) {
            sum += a.front() * b.back();
            a.pop_front();
            b.pop_back();
        }
        cout << "Case #" << caseNum << ": " << sum << endl;
        caseNum++;
    }

}