package heap;

import java.util.Scanner;

/**
 * Created by Ксения on 22.12.2015.
 * РЕШЕНО
 */
public class HeapSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Point[] points = new Point[size];
        for (int i = 0; i < size; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }
//        System.out.println("--------------");
//
//        for (Point point : points) {
//            System.out.println(point.toString());
//        }

        heapSort(points, size);
        for (Point point : points) {
            System.out.println(point.toString());
        }
    }

    public static void heapSort(Point[] points) {
        buildHeap(points, points.length);

        for (int i = points.length-1; i > 0 ; i--) {
            swap(points, 0, i);
            siftDown(points, 0, i-1);
        }
    }

    public static void heapSort(Point[] points, int n) {
        int heapSize = n;
        buildHeap(points, heapSize);
        while(heapSize > 0){
            swap(points, 0, heapSize-1);
            --heapSize;
            siftDown(points, 0, heapSize-1);
        }
    }

    public static void buildHeap(Point[] a, int size){
        for (int i = size / 2 - 1; i >= 0; --i) {
            siftDown(a, i);

        }
    }

    private static void siftDown(Point[] a, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left <= size && a[left].x > a[i].x ||
                left <= size && a[left].x == a[i].x && a[left].y > a[i].y) {
            largest = left;
        }

        if (right <= size && a[right].x > a[largest].x ||
                right <= size && a[right].x == a[largest].x && a[right].y > a[largest].y ) {
            largest = right;
        }

        if (largest != i) {
            swap(a, i, largest);
            siftDown(a, largest, size-1);
        }
    }

    private static void siftDown(Point[] a, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < a.length && a[left].x > a[i].x) {
            largest = left;
        }
        if (left < a.length && a[left].x == a[i].x){
            if(a[left].y > a[i].y){
                largest = left;
            }
        }

        if (right < a.length && a[right].x > a[largest].x) {
            largest = right;
        }
        if (right < a.length && a[right].x == a[largest].x){
            if(a[right].y > a[largest].y){
                largest = right;
            }
        }

        if (largest != i) {
            swap(a, i, largest);
            siftDown(a, largest);
        }
    }

    public static void swap(Point[] arr, int i, int j) {
        Point temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
 class Point{
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return  x + " " + y;
    }
}
