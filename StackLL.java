public class StackLL {
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    static class Stack{
        public static Node head=null;
        public static boolean isEmpty(){
            return head==null;
        }
        //push function
        public static void push(int data){
            Node newN=new Node(data);
            if(isEmpty()){
                head=newN;
                return;
            }
            newN.next=head;
            head=newN;
        }
        //pop function
        public static Node pop(){
            if(isEmpty()){
                return null;
            }
            Node top=head;
            head=head.next;
            return top;
        }
        //peek function
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            Node top=head;
            return top.data;
        }
    }
    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        //printing the list
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
