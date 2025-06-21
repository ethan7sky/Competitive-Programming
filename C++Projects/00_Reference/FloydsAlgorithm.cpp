#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node(int x) {
        data = x;
        next = nullptr;
    }
};

bool detectLoop(Node* head) {
  
    // Fast and slow pointers initially points to the head
    Node *slow = head, *fast = head;

    // Loop that runs while fast and slow pointer are not
    // nullptr and not equal
    while (slow && fast && fast->next) {
        slow = slow->next;
        fast = fast->next->next;

        // If fast and slow pointer points to the same node,
        // then the cycle is detected
        if (slow == fast) {
            return true;
        }
    }
    return false;
}

int main() {

    // Create a hard-coded linked list:
    // 1 -> 3-> 4
    Node* head = new Node(1);
    head->next = new Node(3); 
    //the -> operator is used to access the next pointer of the Node
    head->next->next = new Node(4);
  
	// Create a loop
    head->next->next->next = head->next;

    if (detectLoop(head))
        cout << "true";
    else
        cout << "false";

    return 0;
}