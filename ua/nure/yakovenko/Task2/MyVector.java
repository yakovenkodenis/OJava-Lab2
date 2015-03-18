package ua.nure.yakovenko.Task2;

/**
 * Class that represents Vector and
 * provides several methods with vectors.
 * @author Yakovenko Denis
 *
 */
public class MyVector {
	
    private Object[] ar;
    private int size;

    public MyVector(int capacity) {
        ar = new Object[capacity];
        size = 0;
    }

    public MyVector() {
        this(10);
    }

    /**
     * Addition of the element to the existing vector.
     * @param element any object can be added to the vector.
     */
    public void add(Object element) {
        if (size == ar.length) {
            increaseCapacity();
        }
        ar[size++] = element;
    }

    /**
     * Increases the capacity of the vector if needed.
     */
    private void increaseCapacity() {
		Object[] temp = new Object[ar.length + 1];
        System.arraycopy(ar, 0, temp, 0, ar.length);
        ar = temp;
    }

    /**
     * Gets an element from the vector
     * @param j index of the required element
     * @return object that is located in the vector 
     * with the index j.
     */
    public Object get(int j) {
        tryThrowArgumentException(j);
    	return ar[j];
    }
    
    private void tryThrowArgumentException(int j) {
        if (j >= size) {
            throw new IllegalArgumentException(
                    "Cannot obtain element, j=" + j + ", size=" + size);
        }
    }

    /**
     * Deletes an element from the vector.
     * @param j index of the element to be deleted.
     */
    public void delete(int j) {
    	tryThrowArgumentException(j);
        Object[] tmp = new Object[ar.length - 1];
        int i;
        for(i = 0; i < tmp.length; ++i) {
            tmp[i] = i == j ? ar[i+1] : ar[i];
        }
        ar = tmp;
        size = i;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Vector [");
        for (int j = 0; j < size; j++) {
            result.append(ar[j]).append(", ");
        }
        result.delete(result.length() - 2, result.length()).append("]");
        return result.toString();
    }

    public void print() {
        System.out.println(toString());
    }

    /**
     * Shows the capabilities of the class.
     */
    public static void main(String[] args) {
        MyVector vector = new MyVector(1);
        vector.add("A");
        vector.add("B");
        vector.add("B");
        vector.add("B");
        System.out.println("===Vector===");
        System.out.println(vector);
        System.out.println("Vector[1] is: " + vector.get(1));
        System.out.println("===END Vector===");
    }
}
