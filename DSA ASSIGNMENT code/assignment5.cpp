#include <iostream>
using namespace std;

class Node {
public:
    int key;
    Node* left;
    Node* right;

    Node(int value) {
        key = value;
        left = right = nullptr;
    }
};

class BinarySearchTree {
private:
    Node* root;

public:
    BinarySearchTree() {
        root = nullptr;
    }

    void insert(int key) {
        root = _insert(root, key);
    }

    Node* _insert(Node* root, int key) {
        if (root == nullptr) {
            return new Node(key);
        }

        if (key < root->key) {
            root->left = _insert(root->left, key);
        } else if (key > root->key) {
            root->right = _insert(root->right, key);
        }

        return root;
    }


    void remove(int key) {
        root = _remove(root, key);
    }

    Node* _remove(Node* root, int key) {
        if (root == nullptr) {
            return root;
        }

        if (key < root->key) {
            root->left = _remove(root->left, key);
        } else if (key > root->key) {
            root->right = _remove(root->right, key);
        } else {
            if (root->left == nullptr) {
                Node* temp = root->right;
                delete root;
                return temp;
            } else if (root->right == nullptr) {
                Node* temp = root->left;
                delete root;
                return temp;
            }

            Node* temp = minValueNode(root->right);
            root->key = temp->key;
            root->right = _remove(root->right, temp->key);
        }

        return root;
    }

    Node* minValueNode(Node* node) {
        Node* current = node;
        while (current->left != nullptr) {
            current = current->left;
        }
        return current;
    }
    bool search(int key) {
        return _search(root, key) != nullptr;
    }

    Node* _search(Node* root, int key) {
        if (root == nullptr || root->key == key) {
            return root;
        }

        if (key < root->key) {
            return _search(root->left, key);
        }

        return _search(root->right, key);
    }
    void displayTree() {
        cout << "In-order traversal: ";
        _displayTree(root);
        cout << endl;
    }

    void _displayTree(Node* root) {
        if (root != nullptr) {
            _displayTree(root->left);
            cout << root->key << " ";
            _displayTree(root->right);
        }
    }
};

int main() {
    BinarySearchTree bst;
    int choice, key;

    do {
        cout << "\nMenu:\n";
        cout << "1. Insert\n";
        cout << "2. Delete\n";
        cout << "3. Search\n";
        cout << "4. Display Tree\n";
        cout << "5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                cout << "Enter key to insert: ";
                cin >> key;
                bst.insert(key);
                break;

            case 2:
                cout << "Enter key to delete: ";
                cin >> key;
                bst.remove(key);
                break;

            case 3:
                cout << "Enter key to search: ";
                cin >> key;
                if (bst.search(key)) {
                    cout << key << " found in the tree.\n";
                } else {
                    cout << key << " not found in the tree.\n";
                }
                break;

            case 4:
                bst.displayTree();
                break;

            case 5:
                cout << "Exiting...\n";
                break;

            default:
                cout << "Invalid choice. Please enter a valid option.\n";
        }

    } while (choice != 5);

    return 0;
}
