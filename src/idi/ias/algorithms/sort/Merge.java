package idi.ias.algorithms.sort;

/**
 * Created by IAS on 2017/2/27.
 */
public class Merge {

    public static void sortA(Comparable[] a){
       sortA(a, 0, a.length-1);
    }
    public static void sortA(Comparable[] a, int low, int high){
        int middle = (low + high)/2;
        if (low >= high) return;
        sortA(a, low, middle);
        sortA(a, middle+1, high);
        Comparable[] b = new Comparable[high-low+1];
        for (int i = 0; i < high-low+1; i++)
            b[i] = a[i+low];
        int l = 0;
        int r = (high - low)/2 + 1;
        for (int i = low; i <= high; i++){
            if (l > (high - low)/2) a[i] = b[r++];
            else if (r > high-low) a[i] = b[l++];
            else if (less(b[l], b[r])) a[i] = b[l++];
            else a[i] = b[r++];
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
    private static void show(Comparable[] a){
        for (Comparable b : a)
            System.out.print(b + " ");
        System.out.println();
    }
    public static void main(String[] args){
        Integer[] a = {3,4,1,6,8,4,123,54,3,44,432,66,33,44,55,77,56,666,434};
        sortA(a);
        show(a);
    }
}
