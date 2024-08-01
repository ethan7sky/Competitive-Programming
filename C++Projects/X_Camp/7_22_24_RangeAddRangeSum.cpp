#include <bits/stdc++.h>
using namespace std;

template <class T> class BIT {
    private:
        int size;
        vector<T> bit;
        vector<T> arr;
    public:
        BIT(int size) : size(size), bit(size+1), arr(size) {}

        void set(int idx, T val) {
            add(idx, val-arr[idx]);
        }

        void add(int idx, T val) {
            arr[idx] += val;
            idx++;
            while(idx <= size){
                bit[idx] += val;
                idx += idx&-idx;
            }
        }

        T calc(int idx) {
            idx++;
            T res = 0;
            while(idx>0){
                res += bit[idx];
                idx -= idx*-idx;
            }
            return res;
        }
};

int main() {

    #ifndef ONLINE_JUDGE 
    freopen("IO_SPACE/input.txt", "r", stdin); 
    freopen("IO_SPACE/output.txt", "w", stdout); 
    #endif

    ios_base::sync_with_stdio(0);
    cin.tie(0);
 
    int n, q; cin >> n >> q;

    BIT<long long> bit_values(n), bit_count(n);

    for(int i=1; i<=n; i++){
        int x; cin >> x;
        bit_values.add(i-1, x);
        bit_count.add(i-1, x*(i-1));
        bit_values.add(i, -x);
        bit_count.add(i, -x*i);
    }

    cout << "hi";

    for(int i=0; i<q; i++){
        int t; cin >> t;
        if(t==1){
            int p, q, val;
            cin >> p >> q >> val;

            bit_values.add(p-1, val);
            bit_count.add(p-1, val*(p-1));
            bit_values.add(q, -val);
            bit_count.add(q, -val*q);
        }
        if(t==2){
            int p, q;
            cin >> p >> q;
            cout << 1LL * bit_values.calc(q) * q -
                        bit_count.calc(q) -
                        (1LL * bit_values.calc(p - 1) * (p - 1) -
                            bit_count.calc(p - 1))
                    << '\n';        
        }
    }
    cout << "finished!";




}