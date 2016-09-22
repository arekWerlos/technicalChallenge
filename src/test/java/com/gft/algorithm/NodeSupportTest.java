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
    public void shouldReturnExpectedNodes() {
        Node root = new NodeImpl(null);

        Iterator<Node> result = NodeSupport.convert(root).iterator();
        Assert.assertThat(result.hasNext(), is(equalTo(false)));
    }

}