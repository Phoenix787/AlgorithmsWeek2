package heap;

/**
 * Created by Ксения on 22.12.2015.
 */
public class MainHeapSort {

    public static void main(String[] args) {
        int[] a = {5, 4, 11, 8, 15, 3, 2, 1, 9, 16, 2, 4, 7};
        heapSort(a);

        for (int i : a) {
            System.out.printf("%d ", i);
        }
    }

    public static void heapSort(int[] arr) {
        buildHeap(arr, arr.length);
        for (int i = arr.length - 1; i >= 1; i--) {
            swap(arr, 0, i);
            siftDown(arr, 0, i-1);
        }
    }

    public static void buildHeap(int[] arr, int size) {
        for (int i = size / 2 - 1; i >= 0; --i) {
            siftDown(arr, i);

        }
    }

    public int remove(int[] arr, int size) {
        int root = arr[0];
        arr[0] = arr[--size];
        arr[size] = 0;
        if (size >= 0)
            siftDown(arr, 0);
        return root;
    }


    private static void siftDown(int[] arr, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < arr.length && arr[left] > arr[i]) {
            largest = left;
        }

        if (right < arr.length && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            siftDown(arr, largest);
        }
    }
    private static void siftDown(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left <= size && arr[left] > arr[i]) {
            largest = left;
        }

        if (right <= size && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            siftDown(arr, largest, size-1);
        }
    }

    private static void siftUp(int[] arr, int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (arr[index] <= arr[parent]) {
                return;
            }
            swap(arr, index, parent);
            index = parent;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
