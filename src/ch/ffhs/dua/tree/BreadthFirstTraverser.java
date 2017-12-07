package ch.ffhs.dua.tree;

/**
 * Traverser-Klasse für Breitensuche.
 * EinTraerser besucht zuerst die Wurzel, dann die Kinder der Wurzel, dann die Enkel usw.
 *
 * @param <N>
 */
public abstract class BreadthFirstTraverser<N> 
{
	/**
	 * Methode zum Traversieren eines Baumes.
	 * @param node Wurzelknoten des Baumes.
	 */
	public void traverse(TreeNode<N> node) 
	{
		//TODO
	}
	
	/**
	 * Diese Methode gibt an, was beim travsersieren gemacht werden sollte.
	 * @param value
	 */
	protected abstract void visitNode(N value);   
    
}   