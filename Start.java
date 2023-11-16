import LinearStructures.ArrayList;
import LinearStructures.LinkedList;

public class Start {
    public static void main(String[] args) {
        ArrayList<Integer> testInt = new ArrayList<Integer>();
        ArrayList<String> testStr = new ArrayList<String>();
        testStr.add("Cat");
        testStr.add("Dog");
        testStr.add("Mouse");
        
        for(int i = 0; i < 20; i++) {
            testInt.add(i);
        }
        testInt.add(5, 100);
        testStr.add(1, "goat");
        System.out.println(testInt);
        System.out.println(testStr);
        System.out.println(testInt.indexOf(40));
        System.out.println(testInt.get(5));
        System.out.println(testInt.contains(40));
        System.out.println(testStr.remove("Mouse"));

        for(String s : testStr) {
            System.out.println(s);
        }

        LinkedList<Integer> testIntL = new LinkedList<Integer>();
        testIntL.addFirst(3);
        testIntL.addFirst(4);
        testIntL.add(1, 45);
        testIntL.addLast(300);
        System.out.println(testIntL.get(2));
        testIntL.set(1, 200);
        System.out.println(testIntL.lastIndexOf(3));
        System.out.println(testIntL);
        testIntL.remove(1);
        System.out.println(testIntL);
        for(int i : testIntL) {
            System.out.println(i);
        }
        
    }
}