import java.util.PriorityQueue;
import java.util.Stack;
public class HandOfStraights {
    public static void main (String [] args){
        //this is a sample input , can be modified to take inputs from the user too.
    int [] hand = {1,2,3,6,2,3,4,7,8};
    int groupSize=3;
    System.out.println(isNStraightHand(hand,groupSize));
    }
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        if (hand.length == 1 && groupSize == 1)
            return true;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < hand.length; i++) {
            heap.add(hand[i]);
        }
        Stack<Integer> stk = new Stack<>();
        int min = heap.poll();
        int j = 1;
        for (int i = 0; i < (hand.length / groupSize); i++) {
            while (j < groupSize) {
                if (heap.peek() == null)
                    return false;
                int n = heap.poll();
                if (n == min + 1) {
                    j++;
                    min = n;
                } else {
                    stk.add(n);
                }
            }
            while (stk.size() != 0) {
                int m = stk.pop();
                heap.add(m);
            }
            if (heap.peek() != null)
                min = heap.poll();
            j = 1;
        }
        return true;
    }
}
