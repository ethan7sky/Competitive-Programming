#include <bits/stdc++.h>

using namespace std;

int n;

void merge(vector<int>& arr, int l, int m, int r) {

    vector<int> lA, rA;

    for(int i=l; i<=r; i++){
        if(i<=m) lA.push_back(arr[i]);
        else rA.push_back(arr[i]);
    }

    int i=0, j=0, k=l;

    while(i<=(m-l) && j<(r-m)){
        if(lA[i]<=rA[j]){
            arr[k] = lA[i];
            i++;
        }
        else{
            arr[k] = rA[j];
            j++;
        }
        k++;
    }
    while(i<=(m-l)){
        arr[k] = lA[i];
        i++; k++;
    }
    while(j<r-m){
        arr[k] = rA[j];
        j++; k++;
    }
}

void mergeSort(vector<int>& arr, int l, int r) {

    int m = (l+r)/2;

    if(l>=r) return;

    mergeSort(arr, l, m);
    mergeSort(arr, m+1, r);

    merge(arr, l, m, r);
}

int main() {
    cin >> n;
    vector<int> a;
    for(int i=0; i<n; i++) {
        int x; cin >> x;
        a.push_back(x); 
    }

    mergeSort(a, 0, n-1);

    for(int i=0; i<a.size(); i++){
        cout << a[i] << " ";
    }cout << endl;
}