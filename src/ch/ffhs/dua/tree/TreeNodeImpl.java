package ch.ffhs.dua.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNodeImpl<N> implements TreeNode<N> {

    private N value;

    private ArrayList<TreeNode<N>> children = new ArrayList<>();

    public TreeNodeImpl(N value) {
        this.value = value;
    }

    public TreeNodeImpl<N> addNode(N value) {
        TreeNodeImpl<N> newChild = new TreeNodeImpl<N>(value);
        children.add(newChild);
        return newChild;
    }

    @Override
    public N value() {
        return value;
    }

    @Override
    public List<TreeNode<N>> children() {
        return Collections.unmodifiableList(children);
    }




}
