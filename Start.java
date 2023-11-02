import LinearStructures.ArrayList;

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

        System.out.println("HI");
        
    }
}