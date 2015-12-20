/**
 * Created by Ксения on 18.12.2015.
 */
public class PriorityQueue {
    private Heap heap;

    public PriorityQueue(int n) {
        heap = new Heap(n);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void insert(int element){
        heap.insert(element);
    }

    public int remove() {
        return heap.remove();
    }

    public int peek() { return heap.top(); }
}
