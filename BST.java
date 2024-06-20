//Binary Search Tree
public class BST {
    //defining node datatype
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;//1)1
            this.left=null;
            this.right=null;
        }
    }

    //check order of tree-must be in ascending order
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static Node insert(Node root,int val){//time Complexity=O(H)
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left, val);
        }else{
            root.right=insert(root.right, val);
        }
        return root;
    }

    public static boolean search(Node root,int key){//time Complexity=O(H)
        if(root==null){
            return false;
        }
        else if(root.data>key){
            return search(root.left,key);
        }
        else if(root.data==key){
            return true;
        }
        else{//root.data<key
            return search(root.right,key);
        }
    }

    public static Node delete(Node root,int val){
        if(root.data>val){
            root.left=delete(root.left, val);
        }else if(root.data<val){
            root.right=delete(root.right, val);
        }else{//root.data==val : nxt lines check for no of child (0,1,2)

            //case 1- no child
            if(root.left==null && root.right==null){
                return null;
            }

            //case 2- one child
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }

            //case 3- two child
            Node IS=inorderSuccessor(root.right);//finding inorder IS
            root.data=IS.data;//Replacing with inorder IS
            root.right=delete(root.right,IS.data);//Deleting previous/original IS
        }
        return root;
    }

    public static Node inorderSuccessor(Node root){
        while(root.left!=null){//finding leftmost node of right subtree
            root=root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int values[]={5,1,3,4,2,7};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=insert(root,values[i]);
        }
        inorder(root);//check tree
        System.out.println("<--after insertion");

        if(search(root,4)){
            System.out.println("found");
        }else{
            System.out.println("not found");
        }
        inorder(root);//check tree
        System.out.println("<--after search");

        delete(root, 2);
        inorder(root);//check tree
        System.out.println("<--after deletion");
    }

}
