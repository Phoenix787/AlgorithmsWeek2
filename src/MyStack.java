/**
 * Created by Ксения on 15.12.2015.
 * реализация стека с помощью массива
 */
public class MyStack {
    private int bufferSize;
    private int top;
    private int[] buffer;

    MyStack(int size){
        bufferSize = size;
        top = -1; // обозначает индекс последнего элемента в массиве, она же может использоваться для определения количества элементов в массиве (t+1)
        buffer = new int[bufferSize];
    }

    public int size(){
       return top + 1;
    }

    public boolean isEmpty(){
        return (top < 0);
    }

    public void push(int a) {
        if (top + 1 == bufferSize) {
            throw new StackOverflowError();
        }

        buffer[++top] =  a;
    }

    public int top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return buffer[top];
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is Empty");
        }
        return buffer[top--];
    }


}
