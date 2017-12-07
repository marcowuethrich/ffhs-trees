package ch.ffhs.dua.tree;

import com.google.common.collect.Lists;

import java.util.Stack;

/**
 * Klasse zum Traversieren eines Baumes mit Tiefensuche.
 * Diese Implementierung verwendet keine Rekursion, sondern einen Stack.
 *
 * @param <N>
 */
public abstract class DepthFirstTraverserStack<N> {

    public void traverse(TreeNode<N> node) {

        if (node == null) return;

        //Init Stack
        Stack<TreeNode<N>> nodeStack = new Stack<>();
        nodeStack.push(node);

        while (!nodeStack.empty()) {

            //Show and Remove highest Node
            TreeNode<N> node1 = nodeStack.pop();
            visitNode(node1.value());

            //Has children
            if (node1.children() != null) {

                //Insert all children from right to left
                for (TreeNode<N> child : Lists.reverse(node1.children())) {
                    nodeStack.push(child);
                }
            }
        }
    }

    /**
     * Operation auf einem Knoten bei der Traversierung; die Operation wird durchgeführt,
     * bevor die Nachkommen besucht werden.
     *
     * @param value
     */
    abstract protected void visitNode(N value);
}