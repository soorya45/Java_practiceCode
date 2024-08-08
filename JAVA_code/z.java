import java.util.Arrays;
import java.util.Comparator;

public class z {

    public static void main(String[] args) {
        int[] a = {2, 3, 35, 1, 5, 6, 4};
        Arrays.sort(a);
        Arrays.sort(a,Comparator.reverseOrder());

        // Sort in reverse order using a custom comparator


        // Print the sorted array
        System.out.println(Arrays.toString(a));
    }
}
