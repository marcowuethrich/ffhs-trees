package ch.ffhs.dua.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TraverserTest {
    private TreeNodeImpl<String> tree;

    @Before
    public void init() {
        tree = new TreeNodeImpl<>("A");
        TreeNodeImpl<String> nodeA1 = tree.addNode("A1");
        TreeNodeImpl<String> nodeA2 = tree.addNode("A2");
        nodeA1.addNode("A11");
        nodeA1.addNode("A12");
        nodeA2.addNode("A21");
        nodeA2.addNode("A22");
    }

    @Test
    public void testRecursiveTraverser() {
        final ArrayList<String> listPre = new ArrayList<>();
        final ArrayList<String> listPost = new ArrayList<>();
        DepthFirstTraverserRec<String> trav = new DepthFirstTraverserRec<String>() {
            @Override
            protected void preOperation(String value) {
                listPre.add(value);
            }

            @Override
            protected void postOperation(String value) {
                listPost.add(value.toLowerCase());
            }
        };
        trav.traverse(tree);
        ArrayList<String> listPreExp = new ArrayList<>();
        Collections.addAll(listPreExp, "A", "A1", "A11", "A12", "A2", "A21", "A22");
        ArrayList<String> listPostExp = new ArrayList<>();
        Collections.addAll(listPostExp, "a11", "a12", "a1", "a21", "a22", "a2", "a");
        assertEquals(listPreExp, listPre);
        assertEquals(listPostExp, listPost);
    }

    @Test
    public void testDepthFirstTraverserStack() {
        final ArrayList<String> listPre = new ArrayList<>();
        DepthFirstTraverserStack<String> trav = new DepthFirstTraverserStack<String>() {
            @Override
            protected void visitNode(String value) {
                listPre.add(value);
            }
        };
        trav.traverse(tree);
        ArrayList<String> listPreExp = new ArrayList<>();
        Collections.addAll(listPreExp, "A", "A1", "A11", "A12", "A2", "A21", "A22");
        assertEquals(listPreExp, listPre);
    }

    @Test
    public void testBreadFirstTraverser() {
        final ArrayList<String> listPre = new ArrayList<>();
        BreadthFirstTraverser<String> trav = new BreadthFirstTraverser<String>() {
            @Override
            protected void visitNode(String value) {
                listPre.add(value);
            }
        };
        trav.traverse(tree);
        ArrayList<String> listPreExp = new ArrayList<>();
        Collections.addAll(listPreExp, "A", "A1", "A2", "A11", "A12", "A21", "A22");
        assertEquals(listPreExp, listPre);
    }

    @Test
    public void testTreeIterator() {
        TreeIterator<String> iter = new TreeIterator<>(tree);
        assertEquals("A", iter.next());
        assertEquals("A1", iter.next());
        assertEquals("A11", iter.next());
        assertEquals("A12", iter.next());
        assertEquals("A2", iter.next());
        assertEquals("A21", iter.next());
        assertEquals("A22", iter.next());
        assertFalse(iter.hasNext());
    }
}
