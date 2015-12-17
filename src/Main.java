import java.util.Scanner;

/**
 * Created by Ксения on 15.12.2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        int count;
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        int a;
        int b;
        int result = 0;

        MyDeque d = new MyDeque(count);

        for (int i = 0; i < count ; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            switch (a){
                case 1:
                    d.pushFirst(b);
                    break;
                case 2:
                    if(b != d.popFirst()){
                        result = -1;
                    }
                    break;
                case 3:
                    d.pushLast(b);
                    break;
                case 4:
                    if(b != d.popLast()){
                        result = -1;
                    }
                    break;
            }
        }

        System.out.println((result == -1) ? "NO" : "YES");

    }

    public static String toString(Node tail){
        return (tail == null) ? "*" : tail.value + "->" + toString(tail.next);
    }
}
