#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int MAX_N = 1e6;

int max_div[MAX_N+1];
void sieve() {
    for(int i=2; i<=MAX_N; i++){
        if(max_div[i]==0) {
            for(int j=0; j<=MAX_N; j+=i) {
                max_div[j] = i;
            }
        }
    }
}
int gcd2(int a, int b) {
    return b==0 ? a : gcd(b, a % b);
}
int lcm(int a, int b) {
    return (a / gcd(a, b)) * b;
}

void example() {
    int o = gcd(5, 10); //std function
    int p = lcm(6, 8); //std function
}
int phi(int n) {
    //counts # of integers [1,n] coprime to n
    // O(sqrt(n))
    int ans = n;
    for(int p=2; p*p<=n; p++) {
        if(n%=p==0) {
            while(n%p==0) {
                n /= p;
            }
            ans -= ans / p;
        }
        // ans = p^q*x, so ans/p = p^(q-1)*x
        // and p^q*x-p^(q-1)*x = p^(q-1)*(p-1)*x
        // which is the totient function
        // so we can subtract ans/p from ans
    }
    if(n > 1) {
        ans -= ans / n; //n is prime
    }
    return ans;
}
int phi_arr[MAX_N+1];
int phi_precompute() {
    // O(n log log n)
    for(int i=1; i<MAX_N; i++) phi_arr[i] = i;
    for(int i=2; i<MAX_N; i++){
        if(phi_arr[i]==i) {
            for(int j=i; j<MAX_N; j+=i) {
                phi_arr[j] -= phi_arr[j] / i;
            }
        }
    }
}

ll inverse[MAX_N];
const ll MOD = 1e9 + 7;

ll mod_inverse(ll a) {
    ll m = MOD;
    ll x = 1, y = 0;

    ll q, t;
    while(a>1) {
        q = a/m;
        t = m;
        m = a%m;
        a=t;
        t=y;
        y=x-q*y;
        x=t;
    }
    if(x<0) x+= MOD;
    return x;
}
void mod_inverse_precompute() {
   for(int i=1; i<MAX_N; i++) {
        inverse[i] = mod_inverse(i);
   }
}

void mod_inverse_precompute_fast() {
    inverse[1] = 1;
    for(int i=2; i<MAX_N; i++) {
        inverse[i] = (MOD - (MOD / i) * inverse[MOD % i] % MOD) % MOD;
    }
}


ll binary_exponentation(ll base, ll exp) {
    //MOD*MOD must be less than 2^63 to prevent ll overflow
    base %= MOD;
    if(base < 0) base += MOD; // Ensure base is non-negative
    ll result = 1;
    while(exp > 0) {
        if(exp % 2 == 1) {
            result = (result * base) % MOD;
        }
        base = (base * base) % MOD;
        exp /= 2;
    }
    return result;
}

ll fac[MAX_N+1];
ll fac_inv[MAX_N+1];

void factorial_precompute() {
    fac[0] = 1;
    for(int i=1; i<=MAX_N; i++) {
        fac[i] = (fac[i-1] * i) % MOD;
    }
}
void factorial_inverse_precompute() { //O(n+log MOD)
    fac_inv[MAX_N] = binary_exponentation(fac[MAX_N], MOD - 2); //if we do this for all i<MAX_N, then the runtime is O(n log MOD)
    for(int i=MAX_N; i>=1; i--) {
        fac_inv[i-1] = (fac_inv[i] * i) % MOD;
    }
}

ll choose(int n, int k) {
    if(k<0 || k>n) return 0;
    return (fac[n] * fac_inv[k] % MOD) * fac_inv[n-k] % MOD;
}

ll derangement[MAX_N+1];
void derangement_precompute() {
    derangement[0] = 1;
    derangement[1] = 0;
    for(int i=2; i<=MAX_N; i++) {
        derangement[i] = (i - 1) * (derangement[i - 1] + derangement[i - 2]) % MOD;
        //first case: person 1 gets person i's seat and person i gets person 1's seat
        //second case: person 1 gets person i's seat and person i gets someone else's seat, so assign whoever got person 1's seat to person i's seat
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    mod_inverse_precompute_fast();

    return 0;

}