import java.util.*;
public class LL {
    Node head;
    private int size;
    LL(){
        size=0;
    }

    public class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next=null;
            size++;
        }   
    }
    public static void main(String[] args) {
        LL list=new LL();
        list.addFirst("d");
        list.addFirst("a");
        list.addFirst("m");
        list.addLast("y");
        list.printList();
    }
    public void addFirst(String data){
        Node newN= new Node(data);//specify data bcus constructor requires it 
        newN.next=head;
        head=newN;
    }

    public void addLast(String data){
        Node newN=new Node(data);
        if(head==null){
            head=newN;//not newN.data bcus head is node type its not data/String type
            return;
        }
        Node traverseN=head;
        while(traverseN.next!=null){
            traverseN=traverseN.next;
        }
        traverseN.next=newN;
    }
    public void addInMiddle(int index,String data){
        //checking for invalid bounds
        if(index>size||index<0){
            System.out.println("INVALID INDEX VALUE");
            return;
        }
        size++;//incrementing size of linked list
        Node newN=new Node(data);
        Node traverN=head;//node before the new node
        for(int i=0;i<size;i++){
            if(i==size){
                Node nextN=traverN.next;//saving the pointer of traverN to safely keep the afternodes
                Node traverNode=newN;//pointing traverN to newNode 
                newN.next=nextN;//pointing  newly added Node to the previous saved node
            }
        }
    }
    public void removeFirst(){
        if(head==null){
            System.out.println("EMPTY LIST...");
            return;
        }
        head=head.next;
        size--;//reducing the size of LL while making the second node as head hence removing first node
    }
    public void removeLast(){
        if(head==null){
            System.out.println("EMPTY LIST...");
            return;
        } 
        Node traverseN=head;
        Node lastN=head.next;
        if(lastN.next!=null){
            traverseN=traverseN.next;
            lastN=lastN.next;
        }
        traverseN.next=null;//pointing 2nd last to null -->making it the last node
    }
    public void printList(){
        Node traverseN=head;//starting from first node
        while(traverseN!=null){
            System.out.print(traverseN.data+" ");
            traverseN=traverseN.next;//looping to next node
        }System.out.print("->null");
    }


































}
