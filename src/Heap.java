
public class Heap {
    private int[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int mx){
        maxSize = mx;
        currentSize = 0;
        heapArray = new int[maxSize];
    }

    public boolean isEmpty(){
        return (currentSize == 0);
    }

    public void buildHeap(int index){
        //for (int i = heapArray.length / 2 - 1; i >= 0 ; i--) {
            trickleDown(index);
       // }
    }

    public boolean insert(int key){
        if (currentSize == maxSize) {
            return false;
        }

        heapArray[currentSize] = key;

        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index) {
        while(index > 0){
            int parent = (index - 1)/2;
            if (heapArray[index] <= heapArray[parent]){
                return;
            }
            swap(heapArray, index, parent);
            index = parent;
            //trickleUp(index);
        }

//        int parent = (index - 1)/2;
//        int bottom = heapArray[index];
//        while(index > 0 && heapArray[parent] < bottom){
//            heapArray[index] = heapArray[parent];
//            index = parent;
//            parent = (parent - 1) / 2;
//        }
//        heapArray[index] = bottom;
    }

    public int remove(){
        int root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        heapArray[currentSize] = 0;
        if(!isEmpty())
            trickleDown(0);
        return root;
    }

    public void trickleDown(int index) {
        int largest = index;
        int left = 2*index + 1;
        int right = 2 * index + 2;
        if (left < heapArray.length && heapArray[left] > heapArray[index]){
            largest = left;
        }
        if (right < heapArray.length && heapArray[right] > heapArray[largest]){
            largest = right;
        }

        if (largest != index){
            swap(heapArray, index, largest);
            trickleDown(largest);
        }
    }


    public int top(){
        return heapArray[0];
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]= temp;
    }

    private void deleteLast(){
        int[] newArr = new int[heapArray.length-1];
        System.arraycopy(heapArray,0,newArr,0,heapArray.length-1);
        heapArray = newArr;
    }
}
