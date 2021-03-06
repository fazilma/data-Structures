import java.util.Stack;

public class BinaryTree {

     
     public static void main(String args[]){
         print("Program Starting \n");
     
     
     //         7 
     //     5       6
     //  10   2  3    8
     Node root = new Node(7);
     Node n1 = new Node(5);
     Node n2 = new Node(6);
     Node n3 = new Node(10);
     Node n4 = new Node(2);
     Node n5 = new Node(3);
     Node n6 = new Node(8);
     root.left = n1;
     root.right = n2;
     n1.left = n3;
     n1.right = n4;
     n2.left = n5;
     n2.right = n6;
     
     //preOrder traversal
     print("The preoder travesal of the tree is \n");
     preOrder(root);
     print("\n");
     print(search(root,1));
     print(searchLoop(root,8));
     
     
    }
    
    private static boolean searchLoop(Node root, int key) {
        boolean flag=false;
        Node currentNode=root;
        Stack<Node> stack = new Stack<Node>();
        while(!flag ){
            print(currentNode.data);
            if(currentNode.data==key)
                flag=true;
            else if(currentNode.left !=null){
                stack.push(currentNode);
                currentNode=currentNode.left;
            }    
            else if(currentNode.right !=null){
                stack.push(currentNode);
                currentNode=currentNode.right;

            }
            else if(!stack.empty()){
                currentNode=stack.pop().right;
            }else {
                break;
            }
        }
        

        return flag;
    }

    public static boolean search(Node root, int key) {
        if(root ==null)
            return false;
        
        if(root.data == key)
            return true;
            
        if(search(root.left,key)==true)
            return true;
         return search(root.right,key);
    }
    
    public static void preOrder(Node root){
        if(root !=null){
            print(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void print(Object obj){
        System.out.print(obj+" ");
    }
}

 class Node{
         Node left;
         Node right;
         int data;

         public Node(int data){
             this.data = data;
         }
     }
