import java.io.*;
import java.util.*;


/**
 * Created by НР on 30-Nov-14.
 */
public class Main {


    static ArrayList TreeSearch(double[] array, double step) {
        TreeMap<Double, Double> tree = new TreeMap<Double, Double>();
        boolean a, b;
        int i = 0;
        double num;
        if (i < array.length) {
            do {
                a = false;
                b = false;
                num = array[i];
                tree.put(num, num);
                if (tree.lowerKey(num) == null) {
                    a = true;
                } else if (num - tree.lowerKey(num) > step) {
                    a = true;
                }
                if (tree.higherKey(num) == null) {
                    b = true;
                } else if (tree.higherKey(num) - num > step) {
                    b = true;
                }
                i++;
            }
            while (i < array.length & a & b);
        }
        int size = tree.size();
        ArrayList<Double> newArray = new ArrayList<Double>();
        for (int j = 0; j < size; j++) {
            num = tree.firstKey();
            newArray.add(num);
            tree.remove(tree.firstKey());
        }
        return newArray;
    }

    static boolean Test(ArrayList arrayList) {
        ArrayList<Double> secondArray = new ArrayList<Double>();
        secondArray.add(0.0);
        secondArray.add(1.0);
        secondArray.add(2.0);
        secondArray.add(4.0);
        secondArray.add(6.0);
        if (arrayList.equals(secondArray)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        double[] array = {0.0, 2.0, 4.0, 0.0, 6.0, 1.0, 7.0, 6.0};
        double step = 1.0;
        ArrayList<Double> arrayList = TreeSearch(array, step);
        System.out.println();
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
        System.out.println(Test(arrayList));
    }
}
