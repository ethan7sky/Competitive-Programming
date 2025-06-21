#include <bits/stdc++.h>
using namespace std;


struct Edge;
struct CustomCompartor;

//forward declaration does not work because of the lambda function in sort
// Forward declaration of the Edge structure
struct Edge{ 
    int a, b, c;
    bool operator<(const Edge &y) {
        if (a != y.a) {
            return a < y.a; 
        }
        else if(b!=y.b) {
            return b < y.b;
        }
        return c < y.c;
    }
};

bool bcomp(const Edge &x, const Edge &y) {
    return x.b < y.b;
}

vector<array<int, 3>> edges;
vector<Edge> edges2(100000);
const int n = 100000;
Edge p[n];


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);   

    sort(edges.begin(), edges.end());
    sort(edges.begin(), edges.end(), CustomComparator());
    sort(edges.begin(), edges.end(), greater<>());
    sort(edges.begin(), edges.end(), bcomp);
    // Custom comparator for sorting edges based on the first element, then second

    //sorting an array of Edge objects
    sort(p, p+n);
    sort(p, p+n, bcomp);
    //etc.


    sort(edges2.begin(), edges2.end(), [](const Edge &a, const Edge &b) {
        if (a.a != b.a) {
            return a.a < b.a; 
        } else if (a.b != b.b) {
            return a.b < b.b;
        }
        return a.c < b.c;
    });

}

struct CustomComparator {
    bool operator()(const pair<int, int>& a, const pair<int, int>& b) {
        if (a.first != b.first) {
            return a.first < b.first; // Compare by first element
        }
        return a.second < b.second; // If first elements are equal, compare by second element
    }
};

