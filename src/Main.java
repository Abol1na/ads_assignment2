/**
@add
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();
        Scanner scanner = new Scanner(System.in);
        myList.add(6);
        myList.add(4);
        myList.add(1);
        myList.add(10);
        myList.add(6);
        myList.add(5);
        for (int i = 0; i< myList.size();i++){
            System.out.print(myList.get(i)+ " ");
        }
        System.out.println();
        myList.sort();
        for (int i = 0; i< myList.size();i++){
            System.out.print(myList.get(i)+ " ");
        }
        System.out.println();
        System.out.println(myList.size());
        System.out.println(myList.contains(1));
        System.out.println(myList.contains(2));
        myList.add(8, 2);
        for (int i = 0; i< myList.size();i++){
            System.out.print(myList.get(i)+ " ");
        }
        System.out.println();
        myList.remove(2);
        for (int i = 0; i< myList.size();i++){
            System.out.print(myList.get(i)+ " ");
        }
        System.out.println();
        System.out.println(myList.indexOf(6));
        System.out.println(myList.lastIndexOf(6));
    }
}
