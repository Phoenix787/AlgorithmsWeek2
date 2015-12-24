package segment;

import java.util.Arrays;
import java.util.Scanner;
class SegmentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        Point[] points = new Point[count*2];
        Point[] buf = new Point[points.length];

        for (int i = 0, j = 0; j < count; j++, i+=2) {
            points[i] = new Point(sc.nextInt(), 1);
            points[i+1] = new Point(sc.nextInt(), -1);
        }

        //sort(points,buf,0, points.length-1);
        Arrays.sort(points);


        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < points.length-1; i++) {
            cnt+=points[i].type;
            if( cnt == 1)
            sum+=points[i+1].x - points[i].x;
        }

        System.out.println(sum);
    }

    public static void sort(Point[] array, Point[] buf, int left, int right){
        if(left < right){
            int center = (left + right) / 2;
            sort(array, buf, 0, center);
            sort(array, buf, center+1, right);
            merge(array, buf, left, center+1, right);

        }

    }


    public static void merge(Point[] array, Point[] buf, int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos-1;
        int tmpPos = leftPos;

        int numElements = rightEnd - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (array[leftPos].x < array[rightPos].x){
                buf[tmpPos++]=array[leftPos++];
            } else {
                buf[tmpPos++] =  array[rightPos++];
            }

        }
        while (leftPos <= leftEnd){
            buf[tmpPos++] = array[leftPos++];
        }

        while (rightPos <= rightEnd){
            buf[tmpPos++] = array[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            array[rightEnd] = buf[rightEnd];
        }
    }
}
class Point implements Comparable<Point>{
    public int x;
    public int type;

    public Point(int x, int type){
        this.x = x;
        this.type = type;
    }


    @Override
    public int compareTo(Point o) {
        if (x > o.x) return 1;
        if (x < o.x) return -1;
        return 0;
    }
}