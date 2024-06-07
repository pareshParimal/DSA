import java.util.PriorityQueue;

class KthLargestInArray_215 {
    public static  void main(String [] args){
        System.out.println(findKthLargest(new int []{1,23, 45,56},4));
    }
    public static  int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size() > k)
                heap.poll();
        }
        return heap.peek();
    }
}