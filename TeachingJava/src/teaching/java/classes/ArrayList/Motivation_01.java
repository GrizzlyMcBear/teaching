package teaching.java.classes.ArrayList;

import java.util.ArrayList;

public class Motivation_01 {
    public static void run() {
//        predeclareSize();
//        addItems();

    }
    private static void predeclareSize() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(10);

        System.out.println(arrayList);
    }

    /**
     * Adding items both regularly and in a specified index.
     */
    private static void addItems() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(10);

        arrayList.add(1);
        arrayList.add(3);

        // This is an error, we only have 2 items at this point in time.
//        arrayList.add(3, 2);

        arrayList.add(1, 2);
        arrayList.add(3, 2);

        System.out.println(arrayList.toString());
    }
}
