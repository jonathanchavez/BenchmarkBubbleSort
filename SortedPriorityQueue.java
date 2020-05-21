import java.util.ArrayList;
import java.util.Collections;


public class SortedPriorityQueue <T extends Comparable>{

        private ArrayList<T> queue = new ArrayList();
        public void add(T element)
        {
            queue.add(element);
            queue.sort(Collections.reverseOrder());
        }
        public T remove()
        {
            if (queue.size() != 0){
                T largestValue = queue.get(0);
                queue.remove(0);

                return largestValue;
            }
            return null;

        }
    }

