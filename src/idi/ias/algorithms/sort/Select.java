package idi.ias.algorithms.sort;

/**
 * Created by IAS on 2017/2/25.
 */

public class Select {
    public static void sort(Comparable[] a){
        for (int i = 0; i < a.length - 1; i++){
            for (int j = i+1; j < a.length; j++){
                if (!less(a[i], a[j]))
                    exchange(a, i, j);
            }
        }
    }
    public static  boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++)
            if (less(a[i],a[i-1])) return false;
        return true;
    }
    private static boolean less(Comparable i, Comparable j){
        return i.compareTo(j) < 0;
    }
    private static void exchange(Comparable[] a, int i, int j){
        Comparable b = a[i];
        a[i] = a[j];
        a[j] = b;
    }
    private static void show(Comparable[] a){
        for (Comparable b : a)
            System.out.print(b + " ");
        System.out.println();
    }
    public static void main(String[] args){
        Integer[] a = {3,4,1,6,8,4,123,54,3,44,432,666,434};
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
