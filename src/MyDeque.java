/**
 * Created by Ксения on 16.12.2015.
 */
public class MyDeque {
        private int bufferSize;
        private int head;
        private int tail;
        private int[] buffer;

        public MyDeque(int size) {
            bufferSize = size;
            head = 0;
            tail = 0;
            buffer = new int[bufferSize];
        }

        public int size() {
            return (bufferSize + tail - head) % bufferSize;
        }

        public void pushFirst(int a) {
            int size = size();
            if(size == bufferSize){
                grow();
            }
            head = (bufferSize - 1 + head) % bufferSize;
            buffer[head] = a;

        }

        public void pushLast(int a) {
            int size = size();
            if(size == bufferSize){
                grow();
            }
            buffer[tail] = a;
            tail = (tail + 1) % bufferSize;
        }

        public int popFirst() {
            if (isEmpty()){
                return -1;
            }

            int res = buffer[head];
            head = (head + 1) % bufferSize;
            return res;
        }
        public int popLast() {

            if (isEmpty()){
                return -1;
            }
            tail = (bufferSize - 1 + tail) % bufferSize;
            int res = buffer[tail];
            //tail = (bufferSize - 1 + tail) % bufferSize;
            return res;
        }

        public boolean isFull() {
            return (head == tail);
        }

        public boolean isEmpty(){ return (size() == 0);}

        private void grow(){
            if (isFull()) {
                bufferSize = Math.max(bufferSize*2, 1);
                int[] newBuffer = new int[bufferSize];
                System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
                buffer = newBuffer;
            }
        }






}
