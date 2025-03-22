#include <bits/stdc++.h>
using namespace std;

#include <ext/pb_ds/assoc_container.hpp> 
#include <ext/pb_ds/tree_policy.hpp> 
using namespace __gnu_pbds; 
#define ordered_set tree<int, null_type,less<int>, rb_tree_tag,tree_order_statistics_node_update> 


const int MOD = 99999997;

int main() {
    // #ifndef ONLINE_JUDGE 
    // freopen("IO_SPACE/input.txt", "r", stdin); 
    // freopen("IO_SPACE/output.txt", "w", stdout); 
    // #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; cin >> n;

    pair<int, int> a[n], b[n];
    for(int i=0; i<n; i++){
        cin >> a[i].first;
        a[i].second = i;
    }
    for(int i=0; i<n; i++) {
        cin >> b[i].first;
        b[i].second = i;
    }
    sort(a, a+n);
    sort(b, b+n);
    
    int x[n];
    for(int i=0; i<n; i++){
        x[a[i].second] = b[i].second;
    }

    ordered_set os;
    long long ans = 0;
    for(int i=0; i<n; i++){
        ans += os.size()-os.order_of_key(x[i]);
        os.insert(x[i]);
    }
    ans %= MOD;
    cout << ans << endl;
}