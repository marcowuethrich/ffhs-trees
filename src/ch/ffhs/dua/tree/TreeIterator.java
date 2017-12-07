package ch.ffhs.dua.tree;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Ein Iterator, der in Depth-First Reihenfolge alle Werte der Knoten eines Baumes ausgibt.
 *
 * @param <N>
 */
public class TreeIterator<N> implements Iterator<N>
{
    private Queue<TreeNode<N>> treeNodeQueue = new LinkedList<>();

	public TreeIterator(TreeNode<N> tree)
	{
        if (tree == null) return;

        //Init Stack
        Stack<TreeNode<N>> nodeStack = new Stack<>();
        nodeStack.push(tree);

        while (!nodeStack.empty()) {

            //Show and Remove highest Node
            TreeNode<N> node1 = nodeStack.pop();
            treeNodeQueue.add(node1);

            //Has children
            if (node1.children() != null) {

                //Insert all children from right to left
                for (TreeNode<N> child : Lists.reverse(node1.children())) {
                    nodeStack.push(child);
                }
            }
        }
	}

	@Override
	public boolean hasNext() 
	{
		return !treeNodeQueue.isEmpty();
	}

	@Override
	public N next() {
		return treeNodeQueue.poll().value();
	}
}
