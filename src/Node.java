/**
 * Created by Ксения on 15.12.2015.
 */
public class Node {
    public int value;
    public Node next;

    public Node() {
        value = 0;
        next = null;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public String toString(){
        return (this.next == null) ? this.value + "->*" : this.value + "->" + this.next.toString();
    }
}
