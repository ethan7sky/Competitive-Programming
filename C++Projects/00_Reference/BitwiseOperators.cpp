#include <bits/stdc++.h>
using namespace std;

int main() {

    // & operator: bitwise AND
    // | operator: bitwise OR
    // ^ operator: bitwise XOR
    // ~ operator: bitwise NOT
    // << operator: left shift
    // >> operator: right shift
    int a = 5; // 0101 in binary
    int b = 3; // 0011 in binary
    int c = a & b; // 0001 in binary (1 in decimal)
    int d = a | b; // 0111 in binary (7 in decimal)
    int e = a ^ b; // 0110 in binary (6 in decimal)
    int f = ~a; // 1010 in binary (in 2's complement, this is -6 in decimal)
    int g = a << 1; // 1010 in binary (10 in decimal, left shift by 1)
    int h = a >> 1; // 0010 in binary (2 in decimal, right shift by 1)

    int x = 1<<2; // 0001 becomes 0100 (4 in decimal)
    int y = 1<<3; // 0001 becomes 1000 (8 in decimal)
    int pow = 10;
    int z = 1 << pow; // 1 shifted left by 10 bits (1024 in decimal)
    //etc.

}