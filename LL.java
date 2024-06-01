//important questions based on Linked List
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
        list.addFirst("m");
        list.addFirst("o");
        list.addFirst("m");
        //list.addLast("d");
        list.printList();//mom
        boolean x=list.isPalindrome(list.head);
        if(x){
            System.out.println("it is a palindrome");
        }else{System.out.println("Nope it's not a palindrome");}
        int index=3;
        list.RemoveFromEnd(index);
        boolean y=list.HasCycle(list.head);
        if(y){
            System.out.println("there is a cycle !!!");
        }else{System.out.println("there is no cycle !!!");}
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
        }System.out.println("->null");
    }
    // to remove element at specified index of LL
    public Node RemoveFromEnd(int index) {
        if (head == null || index <= 0) {
            System.out.println("invalid index/empty list");
        }
        // First calculate the size of the list
        int size = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        if (index > size) {
            System.out.println(index+"is greater than size of linked list");;
        }
        int indexToSearch = size - index;
        if (indexToSearch == 0) {
            head = head.next;
            return head;
        }
        Node prev = head;
        int i = 1;
        while (i < indexToSearch) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        printList();
        return head;
    }
    //to check whether its is a palindrome 
    public boolean isPalindrome(Node head){
        if(head==null||head.next==null){
            return false; 
        }
        Node middle=findMiddle(head);
        Node SecondhalfStart=reverse(middle.next);

        Node FirstHalfStart=head;
        
        while(SecondhalfStart!=null){
            if(FirstHalfStart.data!=SecondhalfStart.data){
                return false;
            }
            FirstHalfStart=FirstHalfStart.next;//iterating 
            SecondhalfStart=SecondhalfStart.next;//iterating
        }
        return true;
    }
    public Node findMiddle(Node head){
        Node hare=head;//two steps per move
        Node turtle=head;//one step per move
        
        while (hare.next!=null&&hare.next.next!=null) {//checking the two steps
            hare=hare.next.next;
            turtle=turtle.next;
        }
        return turtle;//turtle node is returned when hare becomes null
            
        
    }

    public Node reverse(Node head){
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    //check if there is a cycle in LinkedList
    public boolean HasCycle(Node head){
        Node hare=head;//two step
        Node turtle=head;//one step
        if(head==null){
            return false;
        }
        while(hare!=null&&hare.next!=null){
            hare=hare.next.next;
            turtle=turtle.next;
            if(hare==turtle){
                return true;
            }
        }
        return false;
    }


































}
