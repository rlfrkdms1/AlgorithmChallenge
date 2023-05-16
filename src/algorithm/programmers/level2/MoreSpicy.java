import java.util.*;

public class MoreSpicy {
    static void swap(int x, int y) {
        int z=0;
        z=y;
        y=x;
        x=z;
    }
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int count = 0;


        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int i : scoville) {
            heap.add(i);
        }

        int first = 0;
        int second = 0;

        while (heap.peek() < K) {

            //if (heap.size() < 2) return -1;

            first=heap.poll();
            second=heap.poll();
            heap.add(first+second*2);

            count++;

        }

        for (Integer integer : heap) {
            System.out.println("integer = " + integer);
        }


    }
}
