import com.apple.laf.resources.aqua;

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

    //CRUD operations- create, read, update, delete

    private void testBounds(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void tryResize() {
        if(size >= arr.length - 1) {
            int[] temp = new int[1 + arr.length * 2]; //add 1 in case capacity=0

            for(int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }

            arr = temp;
        }
    }

    //insert the value 'n' at the end of the vector
    public void add(int n) {
        tryResize(); //no expansions until the end
        arr[size++] = n;
    }

    public int get(int index) {
        testBounds(index);
        return arr[index];
    }

    public void clear() {
        arr = new int[INITIAL_CAPACITY];
        size = 0;
    }

    public void set(int index, int value) {
        testBounds(index);
        arr[index] = value;
    }

    /**
     * Inserts the element at 'index' equal to 'value'
     * Shifts other elements to the right
     * Returns 'true' if the value was successfuly inserted, false otherwise
     * @param index The position in which the value will be inserted
     * @param value The numerical value to be added
     */
    public boolean add(int index, int value) {
        testBounds(index);
        tryResize();
        for(int i = size; i > index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = value;
        size ++;
        return true;
    }

    /**
     * Removes the first instance of 'value' found in the list
     * Shifts remaining values left if necessary
     * Returns 'true' if the value was removed from the list, 'false' otherwise
     * The list remains unchanged if the value does not exist in the list
     * @param value The value to be removed if it exists
     */
    public boolean remove(int value) {
        int sizeChange = 0;
        for(int i = 0; i < size; i++) {
            if(arr[i] == value) {
                for(int j = i; j < size; j++) {
                    arr[j] = arr[j+1];
                }
                sizeChange++;
            }
        }
        size -= sizeChange;
        if(sizeChange > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if(size == 0) return "[]";
        String t = "[" + arr[0];
        for(int i = 1; i < size; i++) {
            t += ", " + arr[i];
        }
        return t + "]";
    }
}