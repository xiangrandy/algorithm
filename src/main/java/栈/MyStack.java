package 栈;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月15日
 */
public class MyStack {

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.empty());
    }

    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> q = new LinkedList<>();
        while (queue.size() != 1) {
            q.add(queue.poll());
        }
        int poped = queue.poll();
        while (!q.isEmpty()) {
            queue.add(q.poll());
        }
        return poped;
    }

    /** Get the top element. */
    public int top() {
        Queue<Integer> q = new LinkedList<>();
        while (queue.size() != 1) {
            q.add(queue.poll());
        }
        int poped = queue.poll();
        q.add(poped);
        while (!q.isEmpty()) {
            queue.add(q.poll());
        }
        return poped;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}
