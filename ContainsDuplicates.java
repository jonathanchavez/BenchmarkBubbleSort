import java.util.ArrayList;
import java.util.Collections;

public class ContainsDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> queue = new ArrayList();

        queue.add(7);
        queue.add(6);
        queue.add(3);
        queue.add(9);
        queue.sort(Collections.reverseOrder());
        System.out.println(queue);
//        System.out.println(queue.get(0).compareTo(queue.get(1)));

    }



}
