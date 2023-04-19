import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        System.out.println(list.size());

        list.add(25);
        list.add(30);
        list.add(35);
        System.out.println(list.size());
        System.out.println(list.get(1));

        list.remove(1);
        System.out.println(list.size());
        System.out.println(list.get(1));

        list.add(40, 1);
        System.out.println(list.size());
        System.out.println( list.get(1));

        System.out.println(list.indexOf(35));
        System.out.println(list.indexOf(40));
    }
}
