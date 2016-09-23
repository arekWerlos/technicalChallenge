package com.gft.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by azws on 2016-09-22.
 */
public class NodeSupportTest {

    @Test
    public void shouldCheckIfNextNodesDoesntExists() {
        Node root = new NodeImpl(null);

        Iterator<Node> result = NodeSupport.convert(root).iterator();

        Assert.assertThat(result.hasNext(), is(equalTo(false)));
    }

    @Test
    public void shouldCheckIfNextNodesDoesExists() {
        Node root = new NodeImpl(new NodeImpl(null));

        Iterator<Node> result = NodeSupport.convert(root).iterator();

        Assert.assertThat(result.hasNext(), is(equalTo(true)));
    }

    @Test
    public void shouldReturnNextExpectedNode() {
        Node child1 = new NodeImpl(null);
        Node root = new NodeImpl(child1);

        Iterator<Node> result = NodeSupport.convert(root).iterator();

        Assert.assertThat(result.next(), is(equalTo(child1)));
    }

    @Test
    public void shouldReturnNextFewExpectedNodes() {
        Node child1 = new NodeImpl(null);
        Node child2 = new NodeImpl(null);
        Node child3 = new NodeImpl(null);
        Node root = new NodeImpl(child1, child2, child3);

        Iterator<Node> result = NodeSupport.convert(root).iterator();

        Assert.assertThat(result.next(), is(equalTo(child1)));
        Assert.assertThat(result.next(), is(equalTo(child2)));
        Assert.assertThat(result.next(), is(equalTo(child3)));
    }

    @Test
    public void shouldReturnNestedNodes() {
        Node nestedChild = new NodeImpl();
        Node child = new NodeImpl(nestedChild);
        Node root = new NodeImpl(child);

        Iterator<Node> result = NodeSupport.convert(root).iterator();
        Iterator<Node> nestedResult = NodeSupport.convert(result.next()).iterator();

        Assert.assertThat(nestedResult.next(), is(equalTo(nestedChild)));
    }

}