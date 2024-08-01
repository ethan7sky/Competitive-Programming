#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp> 
#include <ext/pb_ds/tree_policy.hpp>
#define ordered_set tree<int, null_type,less<int>, rb_tree_tag,tree_order_statistics_node_update> 
#define LL long long
using namespace __gnu_pbds;
using namespace std;
const int MAX_N = 100005;
const int MOD = 1e8-3;

struct node {
    long long val, num;
};

LL n, ans, x[MAX_N], t[MAX_N];
node a[MAX_N], b[MAX_N];

bool cmp(node x, node y){
    if(x.val==y.val) return x.num < y.num;
    return x.val < y.val;
}

void merge(LL l, LL r, LL mid){
    LL i = l;
    LL j = mid+1;
    LL k = l;
    while(i <= mid && j <= r){
        if(x[i] <= x[j]) t[k++] = x[i++];
        else{
            ans += mid-i+1;
            ans %= MOD;
            t[k++] = x[j++];
        }
    }
    while(i <= mid) t[k++] = x[i++];
    while(j <= r) t[k++] = x[j++];
    for(int i=l; i<=r; i++) x[i] = t[i];
}

void mergesort(LL l, LL r){
    if(l<r){
        LL mid = (l+r)/2;
        mergesort(l, mid);
        mergesort(mid+1, r);
        merge(l, r, mid);
    }
}

int main() {
    #ifndef ONLINE_JUDGE 
    freopen("IO_SPACE/input.txt", "r", stdin); 
    freopen("IO_SPACE/output.txt", "w", stdout); 
    #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; cin >> n;

    for(LL i=1; i<=n; i++){
        cin >> a[i].val;
        a[i].num = i;
    }
    for(LL i=1; i<=n; i++){
        cin >> b[i].val;
        b[i].num = i;
    }
    sort(a+1, a+n+1, cmp);
    sort(b+1, b+n+1, cmp);

    mergesort(1, n);

    cout << ans << "\n";
}
