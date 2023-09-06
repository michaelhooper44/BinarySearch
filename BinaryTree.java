import java.util.ArrayList;

public class BinaryTree<T extends Comparable<T>> {
        public NodeType<T> root;
        private int count = 0;
   
     public BinaryTree() {}
   
        // Function to return root instance variable
        public NodeType<T> getRoot() {
           return this.root;
       } // getRoot
  
       // Reset count function for getNumLeafNodes calculation
       public void resetCount() {
           this.count = 0;
       }
  
       // Auxiliary function for delete
       public NodeType<T> getPredecessor(NodeType<T> predNode) {
           // Finds predecessor of predNode
           while (predNode.right != null) {
               predNode = predNode.right;
           } // while
          return predNode;
       }
  
      // Insert function for binary search tree
       public void insert(T key) {
           NodeType<T> predloc = null;
           NodeType<T> location = root;
           NodeType<T> node = new NodeType<>(key);
           // checks for empty tree
           if (root == null) {
               root = node;
           } else {
              // iterates through tree, comparing values to
               // determine left or right movements
               while (location != null) {
                  if (key.compareTo(location.info) >= 0) {
                       predloc = location;
                       location = location.right;
                   } else if (key.compareTo(location.info) < 0) {
                       predloc = location;
                       location = location.left;
                   }
               }
               if (key.compareTo(predloc.info) >= 0) {
                  predloc.right = node;
                   node.parent = predloc;
  
               } else if (key.compareTo(predloc.info) < 0) {
                   predloc.left = node;
                   node.parent = predloc;
               }
           }
       }
  
       // Delete function for binary search tree
       public void delete(T key) {
           // Checks for empty tree, null key, and if key is not present
           // in the tree
           if (this.root == null) {
               return;
           } else if (key == null) {
               return;
           } else if (!search(key, this.root)) {
               System.out.println("Item is not present in the tree.");
               return;
           } // if
  
           NodeType<T> temp = root;
   /*        if (key.compareTo(root.info) == 0) {
               temp = temp.right;
               while (temp.left != null) {
                   temp = temp.left;
               } // while
               root.info = temp.info;
               temp.parent.left = null;
               return;
           }
   */
           // Iterates through tree to find the node
           // with the value of key
           while (temp.info.compareTo(key) != 0) {
               if (key.compareTo(temp.info) > 0) {
                   temp = temp.right;
               } else {
                  temp = temp.left;
               } // if
           } // while
  
           // Checks if leaf node and deletes
           if (temp.right == null && temp.left == null) {
               if (temp.info.compareTo(temp.parent.info) < 0) {
                   temp.parent.left = null;
               } else {
                   temp.parent.right = null;
               }
               return;
 
              // Checks for one child nodes (right)
          } else if (temp.right == null && temp.left != null) {
              if (temp.info.compareTo(temp.parent.info) < 0) {
                  temp.parent.left = temp.left;
                  temp.left = null;
              } else {
                  temp.parent.right = temp.left;
                  temp.left = null;
              }
              return;
 
              // Checks for one child nodes (left)
          } else if (temp.right != null && temp.left == null) {
              if (temp.info.compareTo(temp.parent.info) < 0) {
                  temp.parent.left = temp.right;
                  temp.right = null;
             } else {
                  temp.parent.right = temp.right;
                  temp.right = null;
              }
              return;
          } else {
              // Nodes with two children, finds predecessor
              // and handles accordingly, updating values
              // and pointers
              NodeType<T> predNode = temp.left;
              if (predNode.right == null && predNode.left == null) {
                  temp.info = predNode.info;
                  temp.left = null;
              } else {
                  predNode = getPredecessor(predNode);
             temp.info = predNode.info;
                  predNode.parent.right = null;
              }
              return;
          } // if
      }
 
      // Search function for binary search tree
      public boolean search(T item, NodeType<T> root) {
          // checks if root
          if (root != null && item.compareTo(root.info) == 0) {
              return true;
              // recursively iterates through tree, updating root
              // and returning true if found, false if not found
         } else if (root != null && item.compareTo(root.info) != 0) {
              return search(item, root.left) || search(item, root.right);
          }
          return false;
      }
 
      public void inOrder() {
          inOrderAux(root);
 
      }
 
      // Handles bulk of inOrder operation
      public void inOrderAux(NodeType<T> root) {
          // Recursively prints tree in order
          if (root != null) {
              inOrderAux(root.left);
              System.out.print(root.info + " ");
              inOrderAux(root.right);
          }
 
      }
 
      // getSingleParent function for binary search tree
      public void getSingleParent(NodeType<T> root) {
          ArrayList<T> singleParents = new ArrayList<>();
          // checks if tree is empty
          if (root != null) {
              // recursively calls getSingleParent, inserting
              // item into ArrayList if it has one child
              getSingleParent(root.left);
              if ((root.left == null && root.right != null) ||
                  (root.left != null && root.right == null)) {
                  singleParents.add(root.info);
             }
              getSingleParent(root.right);
          }
          // Prints out ArrayList
          for (T item: singleParents) {
              System.out.print(item + " ");
          }
      }
 
      // getNumLeafNodes function for binary search tree
      public int getNumLeafNodes(NodeType<T> root) {
          // checks if tree is empty
          if (root != null) {
              // recursively calls getNumLeafNodes, incrementing
              // count if current node is a leaf node
              getNumLeafNodes(root.left);
              if (root.left == null && root.right == null) {
                  count++;
              }
              getNumLeafNodes(root.right);
          }
          return count;
      }
 
      // getCousins function for binary search tree
      public void getCousins(T item, NodeType<T> root) {
          NodeType<T> location = null;
          location = root;
          // checks if tree is empty
          if (root != null) {
              // recursively calls getCousins
              getCousins(item, root.left);
              if (item.compareTo(location.info) == 0) {
                  getCousinsAux(location);
              }
              getCousins(item, root.right);
          }
      }
 
      // Auxiliary function for getCousins
      public void getCousinsAux(NodeType<T> location) {
          if (location.parent != null && location.parent.parent != null) {
              NodeType<T> temp = location.parent;
              T item = temp.info;
              temp = temp.parent;
 
              // Checks for cousins based on current tree location
             if (item.compareTo(temp.left.info) == 0) {
                  temp = temp.right;
                  if (temp.left != null) {
                      System.out.print(temp.left.info + " ");
                  }
                  if (temp.right != null) {
                      System.out.print(temp.right.info + " ");
                  }
              } else if (item.compareTo(temp.right.info) == 0) {
                  temp = temp.left;
                  if (temp.left != null) {
                      System.out.print(temp.left.info + " ");
                  }
                  if (temp.right != null) {
                      System.out.print(temp.right.info + " ");
                  }
              }
 
          } else {
              System.out.print(" ");
          }
      }
  }


