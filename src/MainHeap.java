/**
 * Created by Ксения on 20.12.2015.
 */
public class MainHeap {
    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(1);
        heap.insert(4);
        heap.insert(9);
        heap.insert(5);
        heap.insert(7);
        heap.insert(3);

        while (!heap.isEmpty()){
            System.out.println(heap.remove());
        }
    }
}
