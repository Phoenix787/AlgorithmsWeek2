import java.util.*;
import java.util.PriorityQueue;

/**
 * Created by Ксения on 18.12.2015.
 * Вовочка ест фрукты из бабушкиной корзины. В корзине лежат фрукты разной массы. Вовочка может поднять не более K грамм.
 * Каждый фрукт весит не более K грамм. За раз он выбирает несколько самых тяжелых фруктов, которые может поднять одновременно,
 * откусывает от каждого половину и кладет огрызки обратно в корзину.
 * Если фрукт весит нечетное число грамм, он откусывает большую половину. Фрукт массы 1гр он съедает полностью.
 Определить за сколько подходов Вовочка съест все фрукты в корзине.
 Напишите свой класс кучи, реализующий очередь с приоритетом.

 Формат входных данных. Вначале вводится n - количество фруктов и строка с целочисленными массами фруктов через пробел.
 Затем в отдельной строке K - "грузоподъемность".

 Формат выходных данных. Неотрицательное число - количество подходов к корзине.

 Sample Input:
 3
 1 2 2
 2

 Sample Output:
 4

 */
public class VovanApple {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int[] fruits = {1, 2, 2};

        int attempt = 0;
        Stack<Integer>vovka = new Stack<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(n, (Comparator<Integer>) (o1, o2) -> {
            if (o1 > o2) return -1;
            if (o2 > o1) return 1;
            return 0;
        });

        //MyStack vovka = new MyStack(n);
      //  PriorityQueue pq = new PriorityQueue(n); // что-то не то с моей очередью

        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt()); //.insert(sc.nextInt());
        }
        int k = sc.nextInt();


        while(!pq.isEmpty()){
            int weight = 0;
            int fr = pq.remove();
            vovka.push(fr);
            if(fr < k) {
                weight = weightSum(weight, vovka.peek());
                while (!pq.isEmpty()) {
                    if (weightSum(weight, pq.peek()) <= k) {
                        weight = weightSum(weight, pq.peek());
                        vovka.push(pq.remove());

                    } else {

                        break;
                    }
                }
            }
                while (!vovka.isEmpty()){
                    int fruit = vovka.pop();
                    if (fruit > 1){
                        fruit = (fruit / 2) ;
                        pq.add(fruit);
                    }
                }

            attempt++;
        }
        System.out.println(attempt);
    }

    public static int weightSum(int a, int b) {

        return a + b;
    }

}
