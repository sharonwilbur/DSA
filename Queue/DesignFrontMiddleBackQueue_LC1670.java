package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DesignFrontMiddleBackQueue_LC1670 {
    Deque<Integer> front, back;

    public DesignFrontMiddleBackQueue_LC1670() {
        front = new ArrayDeque<>();
        back = new ArrayDeque<>();
    }

    private void rebalance() {
        // Maintain: front.size() == back.size() or front.size() == back.size()-1
        while (front.size() > back.size()) {
            back.offerFirst(front.pollLast());
        }
        while (back.size() > front.size() + 1) {
            front.offerLast(back.pollFirst());
        }
    }

    public void pushFront(int val) {
        front.offerFirst(val);
        rebalance();
    }

    public void pushMiddle(int val) {
        if (front.size() < back.size()) {
            front.offerLast(val);
        } else {
            back.offerFirst(val);
        }
        rebalance();
    }

    public void pushBack(int val) {
        back.offerLast(val);
        rebalance();
    }

    public int popFront() {
        if (front.isEmpty() && back.isEmpty()) return -1;
        int res = !front.isEmpty() ? front.pollFirst() : back.pollFirst();
        rebalance();
        return res;
    }

    public int popMiddle() {
        if (front.isEmpty() && back.isEmpty()) return -1;
        int res;
        if (front.size() == back.size()) {
            res = front.pollLast();
        } else {
            res = back.pollFirst();
        }
        rebalance();
        return res;
    }

    public int popBack() {
        if (back.isEmpty()) return -1;
        int res = back.pollLast();
        rebalance();
        return res;
    }

    public static void main(String[] args) {
        DesignFrontMiddleBackQueue_LC1670 q = new DesignFrontMiddleBackQueue_LC1670();
        q.pushFront(1);      // [1]
        q.pushBack(2);       // [1, 2]
        q.pushMiddle(3);     // [1, 3, 2]
        q.pushMiddle(4);     // [1, 4, 3, 2]
        System.out.println(q.popFront());   // 1
        System.out.println(q.popMiddle());  // 4
        System.out.println(q.popMiddle());  // 3
        System.out.println(q.popBack());    // 2
        System.out.println(q.popFront());   // -1 (empty)
    }
}
