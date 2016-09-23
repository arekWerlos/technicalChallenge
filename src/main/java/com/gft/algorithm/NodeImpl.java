package com.gft.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by azws on 2016-09-22.
 */
public final class NodeImpl implements Node {

    private final List<Node> childrenList;

    public NodeImpl(Node... childrenList) {
        if (childrenList != null)
            this.childrenList = Arrays.asList(childrenList);
        else
            this.childrenList = Collections.emptyList();
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            @Override
            public boolean hasNext() {
                if (!childrenList.isEmpty() && childrenList.iterator().next() != null) {
                    return true;
                }
                return false;
            }
            @Override
            public Node next() {
                return childrenList.iterator().next();
            }
        };
    }


}
