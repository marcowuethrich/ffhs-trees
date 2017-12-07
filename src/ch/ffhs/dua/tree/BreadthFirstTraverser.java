package ch.ffhs.dua.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Traverser-Klasse für Breitensuche.
 * EinTraerser besucht zuerst die Wurzel, dann die Kinder der Wurzel, dann die Enkel usw.
 *
 * @param <N>
 */
public abstract class BreadthFirstTraverser<N> {
    /**
     * Methode zum Traversieren eines Baumes.
     *
     * @param node Wurzelknoten des Baumes.
     */
    public void traverse(TreeNode<N> node) {
        if (node == null) return;

        //Init Queue
        Queue<List<TreeNode<N>>> queueNodes = new LinkedList<>();
        List<TreeNode<N>> headlist = new ArrayList<>();
        headlist.add(node);
        queueNodes.add(headlist);


        while (!queueNodes.isEmpty()) {

            List<TreeNode<N>> tempNodeList = queueNodes.poll();

            //Get child print it and save the children
            for (TreeNode<N> childNode : tempNodeList) {
                visitNode(childNode.value());
                queueNodes.add(childNode.children());
            }
        }
    }

    /**
     * Diese Methode gibt an, was beim travsersieren gemacht werden sollte.
     *
     * @param value
     */
    protected abstract void visitNode(N value);

}   