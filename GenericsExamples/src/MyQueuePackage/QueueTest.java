package MyQueuePackage;

import java.util.ArrayList;

public class QueueTest {
    public static void main(String[] args) {
        String a = new String("first string");
        String b = new String("second string");
        String c = new String("third string");
        LQueue<String> q = new LQueue<>();

        q.enqueue(a);
        q.enqueue(b);
        q.enqueue(c);
        q.dequeue();

        System.out.println("queue empty?: "+q.isEmpty());
        System.out.println("head: " +q.head());
        ArrayList<String> q2 = new ArrayList<String>();
        String d = new String("fourth string");
        String e = new String("fifth string");
        System.out.println("adding fourth and fifth strings... ");
        q2.add(d);
        q2.add(e);
        q.addAll(q2);
        q.dequeue();
        System.out.println("head: " + q.head());
        System.out.println("dequeueing... ");
        q.dequeue();
        System.out.println("head: " + q.head());
        System.out.println("dequeueing... ");
        q.dequeue();
        System.out.println("head: " + q.head());
    }
}
