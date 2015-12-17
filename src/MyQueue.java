/**
 * Created by Ксения on 15.12.2015.
 */
public class MyQueue {
    private int bufferSize;
    private int head;
    private int tail;
    private int[] buffer;

    public MyQueue(int size) {
        bufferSize = size;
        head = 0;
        tail = 0;
        buffer = new int[bufferSize];
    }

    public int size() {
        return (bufferSize + tail - head) % bufferSize;
    }

    public void edqueue(int a) throws Exception {
        int size = size();
        if(size == bufferSize){
            throw new Exception("Queue is full");
        }
        buffer[tail] = a;
        tail = (tail + 1) % bufferSize;
    }

    public int dequeue() {

        int res = buffer[head];
        head = (head + 1) % bufferSize;
        return res;
    }

    public boolean isEmpty() {
        return (head == tail);
    }
}
