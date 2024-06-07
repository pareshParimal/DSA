import java.util.PriorityQueue;

class KthLargest_703 {

    PriorityQueue<Integer> heap ;
    public static int  k;
    public static void main( String [] args){
        KthLargest_703 kthLargest703 = new KthLargest_703(3,new int[] {9, 5, 1, 2});
        System.out.println(kthLargest703.add(17));   // return 4
        /*kthLargest703.add(5);   // return 5
        kthLargest703.add(10);  // return 5
        kthLargest703.add(9);   // return 8
        kthLargest703.add(4);   // return 8*/

    }

    public  KthLargest_703(int k, int[] nums) {
        this.k=k;
        heap= new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
        while(heap.size() >k){
            heap.poll();
        }
    }
    public int add(int val) {
        heap.add(val);
        while(heap.size()>k)
            heap.poll();
        return heap.peek();
    }
}
