package ch.ffhs.dua.tree;

import java.util.List;

public interface TreeNode<N> 
{
    N value();
    
    List<TreeNode<N>> children();
}