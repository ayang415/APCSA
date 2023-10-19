public class intVector {
    
    private final static int INITIAL_CAPACITY = 10;
    private int[] arr = new int[INITIAL_CAPACITY];
    private int size = 0; 

    //default constructor
    public intVector() { }

    //overloaded constructor
    public intVector(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException();
        }
        arr = new int[capacity];
    }

    public int size() { return size; }
}