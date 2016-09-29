package com.gft.algorithm;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by azws on 2016-09-22.
 */
public final class NodeSupport {

    public static Iterable<Node> convert(Node root) {
        return new IterableSupport(root);
    }

    static class IterableSupport implements Iterable<Node> {

        private Node root;

        public IterableSupport(Node root) {
            this.root = root;
        }

        @Override
        public Iterator<Node> iterator() {
            return new IteratorImpl(root);
        }
    }

    static class IteratorImpl implements Iterator<Node> {

        private Stack<Iterator<Node>> stack = new Stack<>();

        public IteratorImpl(Node root) {
            if (root.getChildrenList() != null) {
                stack.push(root.getChildrenList().iterator()) ;
            }
        }

        @Override
        public boolean hasNext() {
            boolean hasNext = false;
            if (!stack.isEmpty()) {
                Iterator<Node> iterator = stack.pop();
                stack.push(iterator);
                hasNext = iterator.hasNext();
            }
            return hasNext;
        }

        @Override
        public Node next() {
            while (!stack.isEmpty()) {
                Iterator<Node> iterator = stack.pop();
                if (iterator.hasNext()) {
                    Node node = iterator.next();
                    stack.push(iterator);
                    if (node.getChildrenList().iterator().hasNext()) {
                        stack.push(node.getChildrenList().iterator());
                    }
                    return node;
                }
            }
            throw new NoSuchElementException();
        }
    }


}