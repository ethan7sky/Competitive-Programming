#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int maxC = 1e9;

int newIdx[100+1];

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t; cin >> t;
    while(t--) {
        int n; cin >> n;

        vector<int> a, b;
        for(int i=0; i<n; i++){
            int x; cin >> x;
            a.push_back(x);
            b.push_back(x);
        }

        sort(a.begin(), a.end());

        long sum=0;
        long prefix=0;
        for(int i=0; i<n; i++){
            prefix += a[i];
            sum += prefix;
        }

        for(int i=n-1; i>=0; i--){
            newIdx[a[i]] = i;
        }

        vector<int> ans;

        for(int i=0; i<n; i++){
            ans.push_back(newIdx[b[i]]+1);
            newIdx[b[i]]++;
        }

        cout << sum << endl;
        for(int i: ans) cout << i << " ";
        cout << endl;
        
    }
}