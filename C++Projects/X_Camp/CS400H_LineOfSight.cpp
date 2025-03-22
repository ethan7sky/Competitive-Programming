#include <bits/stdc++.h>
using namespace std;

#define PI 3.1415926535897932384626

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    double r;
    cin >> n >> r;

    vector<pair<double, double>> a;
    for(int i=0; i<n; i++){
        int x, y; cin >> x >> y;
        double alpha = acos(r/sqrt(1.0*x*x+1.0*y*y));
        double theta = atan2(y, x)-alpha;
        if(theta<0)theta+=2*PI;
        a.push_back(make_pair(theta, theta+2*alpha));
    }

    
}