#include <bits/stdc++.h>
using namespace std;

int n;

int partition(vector<int>& a, int l, int r) {

    int pivot = a[r];

    int idx = l;

    for(int i=l; i<r; i++){
        if(a[i]<pivot){
            swap(a[i], a[idx]);
            idx++;
        }
    }
    swap(a[idx], a[r]);
    return idx;
}

void quickSort(vector<int>& a, int l, int r){
    
    if(l<r){
        int idx = partition(a, l, r);

        quickSort(a, l, idx-1);
        quickSort(a, idx+1, r);
    }
}

int main() {
    cin >> n;
    vector<int> a;
    for(int i=0; i<n; i++){
        int x; cin >> x;
        a.push_back(x);
    }
    quickSort(a, 0, n-1);
    for(int i=0; i<n; i++){
        cout << a[i] << " ";
    }
    cout << endl;
}