import java.util.Arrays;

public class zz {

    public static void main(String[] args) {
        int[] a = {2, 3, 35, 1, 5, 6, 4};

        Arrays.sort(a);

        // Reverse the sorted array using for-each loop
        for (int i : a) {
            System.out.print(i + " ");
        }

        // Alternatively, you can use a traditional for loop
        // for (int i = a.length - 1; i >= 0; i--) {
        //     System.out.print(a[i] + " ");
        // }
    }
}