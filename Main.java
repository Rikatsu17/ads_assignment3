import java.util.Random;

public class Main {
    public static void main(String[] args) {
        testHashTable();

        testBST();
    }

    private static void testHashTable() {
        System.out.println("----- Testing MyHashTable -----");

        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10_000; i++) {
            MyTestingClass key = new MyTestingClass(
                    random.nextInt(1000),
                    "Name" + random.nextInt(100)
            );
            Student value = new Student(
                    "Student" + i,
                    18 + random.nextInt(10)
            );
            table.put(key, value);
        }

        System.out.println("Bucket distribution:");
        table.printBucketSizes();

        MyTestingClass testKey = new MyTestingClass(42, "Name42");
        Student testValue = new Student("TestStudent", 20);
        table.put(testKey, testValue);

        System.out.println("\nGet test:");
        System.out.println("Value for key '42, Name42': " + table.get(testKey));

        System.out.println("\nContains test:");
        System.out.println("Contains value 'TestStudent, 20'? " + table.contains(testValue));
    }

    private static void testBST() {
        System.out.println("\n----- Testing BST -----");

        BST<Integer, String> tree = new BST<>();

        tree.put(5, "Apple");
        tree.put(3, "Banana");
        tree.put(7, "Cherry");
        tree.put(2, "Date");
        tree.put(4, "Elderberry");
        tree.put(6, "Fig");
        tree.put(8, "Grape");

        System.out.println("Size: " + tree.size());

        System.out.println("\nIn-order traversal:");
        for (BST<Integer, String>.Node node : tree) {
            System.out.println("Key: " + node.getKey() + ", Value: " + node.getValue());
        }

        System.out.println("\nGet value for key 3: " + tree.get(3));
        tree.delete(3);
        System.out.println("After deleting key 3, size: " + tree.size());
    }
}