


// ..................... E/17/407 ........................



public class AVLTree{

    // calss node, to imlement a node
    class Node{

      // defining the member variables
        int key,height;
        Node left,right; //left subtree and right subtree

        //deefining the constructor
        Node(int key){
           
          this.key=key;
          
        }
    }


  private Node root; //creating the root node

  //define the AVL tree
  
  private Node mostLeftChild(Node node){

    Node current=node;

    //loop to find the leftmost leaf
    while (current.left != null){
        current=current.left;
    }

    return current;

  }


  // a method to return the height of a subtree with root node n
  private int height(Node n){

    // if the tree is empty (node is null ) return -1,
    // else return the height
    return n == null ? -1 : n.height;

  }

  //a method to update the height 
  private void updateHeight(Node n){

    // evaluate the heigh 
    // 1+ the maximum value of the height of subtrees  
    n.height=1 + Math.max(height(n.left),height(n.right)); 

  }


  //get the difference between the heights of left and right sub trees
  public int getBalance(Node n){

    // if there are no elemnets in the tree return 0
    // otherwise return the balance factor :  height(n.right) - height(n.left)
    return  (n == null) ? 0 : height(n.right) - height(n.left);
  }


  // balance an AVL tree using rotations

  //a method to rotate right
  private Node rotateRight(Node y){

    Node x=y.left; //get the left child of y
    Node z=x.right; //get the right child of x

    x.right=y; // assign y to right child of node  x
    y.left=z; // assign z to left child of node y

    //update the height of the left and right subtrees
    updateHeight(y);
    updateHeight(x);

    return x; //return the root node
  }


  // a method to rotate left
  private Node rotateLeft(Node y){

    Node x=y.right; //get the right child of node y
    Node z=x.left; //get the left child of node x

    x.left=y;  // assign y to left child of node x
    y.right=z; // assign z to right child of node y

    // update the heigh of the left and right subtrees
    updateHeight(y);
    updateHeight(x);

    return x; // return the root node
  }


  // a method to keep AVL tree balanced after any change in its nodes
  // after deleting or inserting

  private Node rebalance(Node z){

    updateHeight(z); //update the height of node z
 
    int balance=getBalance(z); //get the balance factor of node z

    // the balanced factor of a balanced node should be in  between -1 to 1

    if(balance > 1){  // check whether the balance is grater than 1 or not

       //check whether the height of the right subtree is grater than the left subtree or not
        if(height(z.right.right) > height(z.right.left)){

          //perform left rotation
            z=rotateLeft(z);

        }else{

          // perform right rotation
          //if the right subtree is less than left subtree
            z.right=rotateRight(z.right);//rotate right
            z=rotateLeft(z); //left rotation

        }
    }else if (balance < -1){  //check whether the balance is less than -1 or not

        if(height(z.left.left) > height(z.left.right)){

          //rotate right if the height of the left subtree is grater than the right subtree 
            z=rotateRight(z);
        }else{

          //rotate left if the height of left subtree is less than the right subtree
            z.left=rotateLeft(z.left); //rotte left
            z=rotateRight(z); //right rotation
        }
    }

    return z; //return the node
  }


  //method to insert a node to the avl tree

  private Node insert(Node node,int key){

    
    if(node == null){

      //if the node is null then return the new node
        return new Node(key);

    }else if (node.key > key){ 

      //if the key of the current node is grater than the key ,insert it as the left child
        node.left=insert(node.left,key);

    }else if (node.key < key){

       //if the key of the current node is grater than the key ,insert it as the right child
        node.right=insert(node.right,key);
    }else{

      //create a new runtime exception if the given key is already in the tree
        throw new RuntimeException ("duplicate key!");
    }

    // invoke rebalance method to balance the avl tree
    return rebalance(node); 

  }


  //a method to delete a node from avl tree
  private Node delete(Node node,int key){

    if(node == null){ 
      //if the node is null return the node
        return node;

    }else if(node.key > key){

      //if the key of the node is grater than the key delete the left node recursively
        node.left=delete(node.left,key);

    } else if (node.key < key){

       //if the key of the node is less than the key delete the right node recursively
        node.right=delete(node.right, key);
    }else{

        if(node.left == null || node.right == null){ //check whether the right or left child is null or not
            node=(node.left == null ) ? node.right : node.left;

        }else{

          // replace the node with the left most child
            Node mostLeftChild = mostLeftChild(node.right); //get the left most child
            node.key=mostLeftChild.key;
            node.right=delete(node.right,node.key); //delete the right child
        }

        if(node != null){
          // if the node is not null rebalance the avl tree
            node=rebalance(node);
        }

        

    }
    return node; //return the deleted node


  }


  // a method to search a node

  public Node find(int key){

    Node current = root; //access to the root node

    // loop through the avl tree
    while(current != null){

        if(current.key == key){
            break; // go out from the loop if the key is found
        }

        // go to the next node
        // if the key of the current node is less than the given key , go to the right child of the current node
        current=current.key < key ? current.right : current.left;

    }

    return current; //return the expected node
  }


  // a method to do the preorder traversal

  void preOrder(Node node){

    if(node != null){

        System.out.print(node.key + " "); // print the key of the node
        preOrder(node.left); //visit left subtree
        preOrder(node.right); // visit right subtree

    }
  }


  
  // a method to do the inorder traversal
  void inOrder(Node node){

    if(node != null){
        
        inOrder(node.left); //visit the left subtree
        System.out.print(node.key + " "); // print the key of the node
        inOrder(node.right); // visit the right subtree

    }
  }

  
  
  // a method to do the postorder traversal
  void postOrder(Node node){

    if(node != null){
        
        postOrder(node.left); //visit the left subtree
        postOrder(node.right); //visit the right subtree 
        System.out.print(node.key + " "); // print the key of the node 

    }
  }

  


//main method
  public static void main(String [] arg){

    AVLTree tree = new AVLTree(); // create a new object from the avl tree

 /*   // inser nodes to the tree
    tree.root=tree.insert(tree.root,10);
    tree.root=tree.insert(tree.root,20);
    tree.root=tree.insert(tree.root,30);
    tree.root=tree.insert(tree.root,40);
    tree.root=tree.insert(tree.root,50);
    tree.root=tree.insert(tree.root,25);
    */

    tree.root=tree.insert(tree.root,5);
    tree.root=tree.insert(tree.root,12);
    tree.root=tree.insert(tree.root,23);
    tree.root=tree.insert(tree.root,28);
    tree.root=tree.insert(tree.root,60);


// print the preorder traversal of the avl tree
    System.out.println("Preorder traversal" + " of constructed tree is : ");
    tree.preOrder(tree.root); 

  // print the inorder traversal of the avl tree
    System.out.println('\n' + "Inorder traversal" + " of constructed tree is : ");
    tree.inOrder(tree.root);

// print the postorder traversal of the avl tree
    System.out.println('\n' + "Postorder traversal" + " of constructed tree is : ");
    tree.postOrder(tree.root);

    tree.delete(tree.root,28); //delete node 28

    System.out.println('\n' + "Inorder traversal" + " of constructed tree is : ");
    tree.inOrder(tree.root); // inorder traversal of the tree aftre deleting the node 28

    System.out.println( );
    Node searchedNode=tree.find(12);
    System.out.println("searched key :"+searchedNode.key);

    

    



  }


}