package ch.ffhs.dua.tree;

/**
 * Klasse zum Traversieren eines Baumes mit Tiefensuche.
 *
 * @param <N>
 */
public abstract class DepthFirstTraverserRec<N> {

    public void traverse(TreeNode<N> node) {
        //Pre
        //Square Element
        preOperation(node.value());
        preMethode(node);

        //Post
        postMethod(node);
        postOperation(node.value());

    }

    private void preMethode(TreeNode<N> node) {
        //Isn't the node or the the child null/empty
        if (node != null && node.children() != null && !node.children().isEmpty()) {
            //Iterate over highest children
            for (TreeNode<N> child : node.children()) {
                preOperation(child.value());
                preMethode(child);
            }

        }
    }

    private void postMethod(TreeNode<N> node) {

        for (TreeNode<N> child : node.children()) {
            postMethod(child);
            postOperation(child.value());
        }
    }

    // Only for Strings
    private boolean isLowerThen(N value, N value2) {
        String v1 = (String) value;
        String v2 = (String) value2;

        //Remove the character
        //convert numbers
        //if has no one add 0
        int i1;
        int i2;
        try {
            i1 = Integer.parseInt(v1.substring(1));
        } catch (NumberFormatException e) {
            return true;
        }
        try {
            i2 = Integer.parseInt(v2.substring(1));

        } catch (NumberFormatException ex) {
            return false;
        }

        return i1 < i2;
    }

    /**
     * Operation auf einem Knoten, bevor die NAchkommen besuchr wurden.
     *
     * @param value
     */
    abstract protected void preOperation(N value);

    /**
     * Operation auf einem Knoten, nachdem die Nachkommen besuchr wurden.
     *
     * @param value
     */
    abstract protected void postOperation(N value);

}   