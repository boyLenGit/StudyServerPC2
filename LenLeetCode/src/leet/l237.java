package leet;

import leet.help.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class l237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode in = new ListNode(1, new ListNode(2, new ListNode(3)));
        l237 l = new l237();
        l.deleteNode(in);
        System.out.println(in.toString());

        Thread thread1 = new Thread(() ->{
            System.out.println(1);
        });
        Thread thread2 = new Thread(() ->{
            System.out.println(2);
        });
        Thread thread3 = new Thread(() ->{
            System.out.println(3);
        });
        CompletableFuture.runAsync(() -> thread1.start()).thenRun(() -> thread2.start()).thenRun(() -> thread3.start());
    }
}
