package ch.ffhs.dua.tree;

/**
 * Klasse zum Traversieren eines Baumes mit Tiefensuche.
 * Diese Implementierung verwendet keine Rekursion, sondern einen Stack.
 *
 * @param <N>
 */
public abstract class DepthFirstTraverserStack<N> 
{

	public void traverse(TreeNode<N> node) 
	{
		//TODO
	}
	
	/**
	 * Operation auf einem Knoten bei der Traversierung; die Operation wird durchgeführt,
	 * bevor die Nachkommen besucht werden.
	 * @param value
	 */
	abstract protected void visitNode(N value);   

}   