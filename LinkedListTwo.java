import java.util.*;
public class LinkedListTwo {
    Scanner sc = new Scanner(System.in);
    LinkedList<Integer> List=new LinkedList<Integer>();
    List.addLast(1);
    List.addLast(5);
    List.addLast(7);
    List.addLast(3);
    List.addLast(8);
    List.addLast(2);
    List.addLast(3);
    for(int i=0;i<List.size;i++){
        System.out.println(List.get(i+" "));
    }


}
