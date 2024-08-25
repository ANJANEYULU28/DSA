package linkedlist.single;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Test add and size methods
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("Size after adding elements: " + list.size()); // Expected: 3

        // Test get method
        System.out.println("Element at index 0: " + list.get(0)); // Expected: 1
        System.out.println("Element at index 1: " + list.get(1)); // Expected: 2
        System.out.println("Element at index 2: " + list.get(2)); // Expected: 3

        // Test add at index method
        list.add(1, 4);
        System.out.println("Element at index 1 after adding 4: " + list.get(1)); // Expected: 4
        System.out.println("Size after adding element at index: " + list.size()); // Expected: 4

        // Test remove method
        list.remove(1);
        System.out.println("Element at index 1 after removing: " + list.get(1)); // Expected: 2
        System.out.println("Size after removing element: " + list.size()); // Expected: 3

        // Test isEmpty method
        System.out.println("Is list empty: " + list.isEmpty()); // Expected: false

        // Test clear method
        list.clear();
        System.out.println("Size after clearing list: " + list.size()); // Expected: 0
        System.out.println("Is list empty after clearing: " + list.isEmpty()); // Expected: true

        System.out.println("----------Running tests with invalid index----------");
        try {
            list.get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught expected exception for get with invalid index: " + e.getMessage());
        }

        // Test add method with invalid index
        try {
            list.add(1, 5);
        } catch (RuntimeException e) {
            System.out.println("Caught expected exception for add with invalid index: " + e.getMessage());
        }

        // Test remove method with invalid index
        try {
            list.remove(0);
        } catch (RuntimeException e) {
            System.out.println("Caught expected exception for remove with invalid index: " + e.getMessage());
        }
    }
}