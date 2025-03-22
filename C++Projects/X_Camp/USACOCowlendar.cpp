#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MAX_N = (int)1e4+10;
int N;
ll a[MAX_N];
unordered_set<ll> v;
vector<ll> uA;
ll sum = 0;
ll maxWeek = INT_MAX;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    for(int i=0; i<N; i++){
        cin >> a[i];
        maxWeek = min(maxWeek, a[i]/4);
        if(!v.count(a[i])) {
            uA.push_back(a[i]);
            v.insert(a[i]);
        }
    }

    if(uA.size()<=3) {
        cout << (ll)maxWeek*(maxWeek+1)/2;
        return 0;
    }

    vector<int> diff;
    for(int i=0; i<4; i++){
        for(int j=i+1; j<4; j++){
            diff.push_back(abs(uA[i]-uA[j]));
        }
    }

    // for(int i: diff) cout << i << " ";
    // cout << endl;

    unordered_set<int> possibleAnswers;
    for(ll i=1; i<(ll)1e5; i++){
        for(ll d: diff) {
            if(d%i==0L) {
                possibleAnswers.insert(i);
                if(i*i!=d) {
                    possibleAnswers.insert(d/i);
                }
            }
        }
    }

    // for(int i: possibleAnswers) cout << i << " ";
    // cout << endl;


    for(int d: possibleAnswers) {
        if(d>maxWeek) continue;
        set<int> mod;
        for(int i=0; i<N; i++){
            mod.insert(a[i]%d);
            if(mod.size()>3) break;
        }
        if(mod.size()<=3) {
            sum+=(ll)d;
        }
    }
    cout << sum;

}