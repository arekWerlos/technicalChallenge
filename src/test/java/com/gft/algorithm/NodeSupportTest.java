package com.gft.algorithm;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by azws on 2016-09-22.
 */
public class NodeSupportTest {

    @Test
    public void shouldCheckIfNextNodesDoesntExist() {
        Node root = new NodeImpl();

        Iterator<Node> result = NodeSupport.convert(root).iterator();

        Assert.assertThat(result.hasNext(), is(equalTo(false)));
    }

    @Test
    public void shouldCheckIfNextNodesDoesExist() {
        Node child = new NodeImpl();
        Node root = new NodeImpl(child);

        Iterator<Node> result = NodeSupport.convert(root).iterator();

        Assert.assertThat(result.hasNext(), is(equalTo(true)));
        Assert.assertThat(result.next(), is(equalTo(child)));
    }

    @Test
    public void shouldReturnNextExpectedNode() {
        Node child1 = new NodeImpl();
        Node root = new NodeImpl(child1);

        Iterator<Node> result = NodeSupport.convert(root).iterator();

        Assert.assertThat(result.next(), is(equalTo(child1)));
    }

    @Test
    public void shouldReturnNextFewExpectedNodes() {
        Node child1 = new NodeImpl();
        Node child2 = new NodeImpl();
        Node child3 = new NodeImpl();
        Node root = new NodeImpl(child1, child2, child3);

        Iterator<Node> result = NodeSupport.convert(root).iterator();

        Assert.assertThat(Lists.newArrayList(result), containsInAnyOrder(child1, child2, child3));
    }

    @Test
    public void shouldReturnNestedNodes() {
        Node nestedChild = new NodeImpl();
        Node nestedChild2 = new NodeImpl();
        Node child = new NodeImpl(nestedChild,nestedChild2);
        Node root = new NodeImpl(child);

        Iterator<Node> result = NodeSupport.convert(root).iterator();

        assertThat(result).containsOnly(child, nestedChild, nestedChild2);
    }

}