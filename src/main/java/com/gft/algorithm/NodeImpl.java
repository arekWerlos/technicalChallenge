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
    public List<Node> getChildrenList() {
        return childrenList;
    }

}
