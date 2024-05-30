import java.util.*;
//homework one apna clg | topic - linked list impl.
public class LinkedListOne {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        java.util.LinkedList<Integer> List=new java.util.LinkedList<Integer>();
        System.out.println("enter 10 various digits from 0 to 50");
        for(int i=0;i<=10;i++){
            System.out.print(i+":");
            int value=sc.nextInt();
            List.addLast(value);
            System.out.println();
        }
        System.out.print("ORIGINAL LINKED LIST--->");
        for(int i=0;i<(List.size());i++){
            System.out.print(List.get(i)+" ");
        }
        System.out.println();
        System.out.print("UPDATED LIST WITH VALUES LESS THAN 25--->");

        for(int i=0;i<(List.size());i++){
            if((List.get(i))>25){
                List.remove(i);
            }
        }
        for(int i=0;i<(List.size());i++){
            System.out.print(List.get(i)+" ");
        }
    }
}
