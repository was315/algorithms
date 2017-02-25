package idi.ias.algorithms.sort;

/**
 * Created by IAS on 2017/2/26.
 */
public class Shell {
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3*h + 1;
        while (h > 0){
            for (int i = h; i < N; i++){
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exchange(a, j, j-h);
            }
            h /= 3;
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
        Integer[] a = {3,4,1,6,8,4,123,54,3,44,432,66,33,44,55,77,56,666,434};
        sort(a);
        show(a);
    }
}
