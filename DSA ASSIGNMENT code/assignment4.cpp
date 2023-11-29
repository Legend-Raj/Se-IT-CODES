#include<bits/stdc++.h>
using namespace std;
#define int long long

struct tree{
    char data;
    struct tree *right, *left, *next;
};

bool check(char ele){
    if(ele == '*' || ele == '-' || ele == '+' || ele == '/')return false;
    return true;
}
tree * top = NULL, *curr = NULL;

tree* pop_subtree(){
    struct tree *tmp = top;
    top = tmp -> next;
    struct tree *get;
    get = (struct tree*)malloc(sizeof(struct tree));
    get = tmp;
    curr = top;
    return get;
}

void make_node(char ele){
    struct tree *tmp;
    tmp = (struct tree*)malloc(sizeof(struct tree));
    
    if(check(ele)){
        tmp -> data = ele;
        tmp -> next = top;
        top = tmp;
        tmp -> right = NULL;
        tmp -> left = NULL;
    }
    else{
        struct tree *tmp1 = pop_subtree();
        struct tree *tmp2 = pop_subtree();
        tmp -> data = ele;
        tmp -> next = top;
        top = tmp;
        tmp -> left = tmp2;
        tmp -> right = tmp1;
    }
    curr = top;
}

void inorder_withoutrecur(struct tree *curr){
    stack<tree*> s;
    tree* current = curr;
    while(current != NULL || !s.empty()){
        if(current != NULL){
            s.push(current);
            current = current -> left;
        }
        else{
            current = s.top();
            s.pop();
            cout << current -> data;
            current = current -> right;
        }
    }
}

void preorder_withoutrecur(tree *node){
    stack<tree*> s;
    tree *current = curr;
    while(current != NULL || !s.empty()){
        if(current != NULL){
            s.push(current);
            cout << current -> data;
            current = current -> left;
        }
        else{
            current = s.top();
            s.pop();
            current = current -> right;
        }
    }
    cout << endl;
}

void postorder_withoutrecur(tree *node){
    stack<tree*> s;
    tree *current = curr;
    while(current != NULL || !s.empty()){
        if(current != NULL){
            s.push(current);
            current = current -> left;
        }
        else{
            tree *tmp;
            tmp = s.top() -> right;
            if(tmp == NULL){
                tmp = s.top();
                s.pop();
                cout << tmp -> data;
                while(!s.empty() && tmp == s.top() -> right){
                    tmp = s.top();
                    s.pop();
                    cout << tmp -> data;
                }
            }
            else current = tmp;

        }
    }
}

void inorder_withrecur(tree *node){
    if(node == NULL){
        return ;
    }
    inorder_withrecur(node -> left);
    cout << node -> data;
    inorder_withrecur(node -> right);
}

void preorder_withrecur(tree *node){
    if(node == NULL){
        return ;
    }
    cout << node -> data;
    preorder_withrecur(node -> left);
    preorder_withrecur(node -> right);
}

void postorder_withrecur(tree *node){
    if(node == NULL){
        return ;
    }
    postorder_withrecur(node -> left);
    postorder_withrecur(node -> right);
    cout << node -> data;
}

void print(struct tree *top){
    if(top != NULL){
        cout << top -> data << " ";
        print(top -> left);
        print(top -> right);
    }
}


signed main(){
    int ch;
    do{
        string s;
        int run;
        cout << "1.Postfix Expression \n2.Prefix Expression \n3.Print Inorder traversal \n4.Print Preorder Traversal \n5.Print Postorder Traversal \n6.Print Inorder with recur \n7.Print Preorder with recur \n8.Print Postorder with recur \nEnter your choice here : ";
        cin >> run;
        switch(run){
            case 1 : {
                cout << "Enter the postfix Expression : ";
                cin >> s;
                for(int j = 0; j < s.size(); j++){
                    make_node(s[j]);
                }
                break;
            }
            case 2 : {
                cout << "Enter the Prefix Expression : ";
                cin >> s;
                reverse(s.begin(), s.end());
                for(int j = 0; j < s.size(); j++){
                    make_node(s[j]);
                }
                break;
            }
            case 3 : {
                inorder_withoutrecur(curr);
                cout << endl;
                break;
            }
            case 4 : {
                preorder_withoutrecur(curr);
                break;
            }
            case 5 : {
                postorder_withoutrecur(curr);
                break;
            }
            case 6 : {
                inorder_withrecur(curr);
                cout << endl;
                break;
            }
            case 7 : {
                preorder_withrecur(curr);
                cout << endl;
                break;
            }
            case 8 : {
                postorder_withrecur(curr);
                cout << endl;

            }
        }
        cout << "If you want to continue press 1 : (else press 0) : \n";
        cin >> ch;

    }
    while(ch == 1);
    
}