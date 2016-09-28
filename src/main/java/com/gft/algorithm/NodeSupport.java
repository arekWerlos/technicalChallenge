package com.gft.algorithm;

import java.util.Collections;
import java.util.Iterator;
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

        private Node current;
        private Stack<Iterator<Node>> stack = new Stack<>();
        private Iterator<Node> childrenIterator;

        public IteratorImpl(Node root) {
            this.current = root;
            if (root.getChildrenList().iterator().hasNext()) {
                this.childrenIterator = root.getChildrenList().iterator();
            } else {
                this.childrenIterator = Collections.emptyIterator();
            }
        }

        @Override
        public boolean hasNext() {
            return childrenIterator.hasNext();
        }

        @Override
        public Node next() {
            Iterator<Node> grandChildrenIterator = getGrandChildrenIterator();

            if (grandChildrenIterator != null) {

                if (grandChildrenIterator.hasNext()) {
                    stack.push(grandChildrenIterator);
                }
                return current;
            } else if (!stack.isEmpty()) {
                Iterator<Node> poppedIterator = stack.pop();

                if (poppedIterator.hasNext()) {
                    stack.push(poppedIterator);
                    return poppedIterator.next();
                } else {
                    while (!stack.isEmpty()) {
                        poppedIterator = stack.pop();
                        if (poppedIterator.hasNext()) {
                            return poppedIterator.next();
                        }
                    }

                }
            }
            return null;
        }

        private Iterator<Node> getGrandChildrenIterator() {

            if (childrenIterator.hasNext()) {

                if (!stack.contains(childrenIterator)) {
                    stack.push(childrenIterator);
                }
                this.current = childrenIterator.next();
                return current.getChildrenList().iterator();
            }
            return null;
        }



    }


}