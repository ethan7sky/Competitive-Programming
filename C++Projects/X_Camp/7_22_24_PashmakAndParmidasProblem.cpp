#include <bits/stdc++.h>
using namespace std;
 
const int MAXN = 1000001;
int BIT[MAXN];
 
void insert(int x, int c){
    for (int i=x+1; i<MAXN; i += i &-i) {
        BIT[i]+=c;
    }
}
 
int find(int x) {
    int ans = 0;
    for (int i = x; i > 0; i -= i & (-i)) ans += BIT[i];
    return ans;
}

set<int> cc;
int last[MAXN], cnt[MAXN], a[MAXN], temp[MAXN], sz;

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(0);
 
    int n;
    cin >> n;

    //coordinate compresion
    for (int i = 0; i < n; i ++) cin >> a[i], temp[i] = a[i];
 
    sort(temp, temp + n);
    sz = unique(temp, temp + n) - temp;
 
    for (int i = 0; i < n; i ++) a[i] = lower_bound(temp, temp + sz, a[i]) - temp;
 

    //solve
    for(int i = n-1; i>=0; i--) {
        cnt[a[i]]++;
        insert(cnt[a[i]], 1);
        last[i] = cnt[a[i]];
    }
 
    memset(cnt, 0, sizeof cnt);
    long long ans = 0;

    for (int i=0; i<n; i++) {
        insert(last[i], -1);
        cnt[a[i]]++;
        ans += find(cnt[a[i]]);
    }
 
    cout << ans << "\n";
    return 0;
}