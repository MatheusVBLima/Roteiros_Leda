package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree() {
		return isBST() && isAVLTreeRec(avlTree.getRoot());
	}

	private boolean isAVLTreeRec(BSTNode<T> node) {
		boolean right = true;
		boolean left = true;

		if (!node.isEmpty()) {
			int balance = this.avlTree.calculateBalance(node);

			if (balance > 1 || balance < -1) {
				right = false;
				left = false;
			} else {
				right = isAVLTreeRec((BSTNode<T>) node.getRight());
				left = isAVLTreeRec((BSTNode<T>) node.getLeft());
			}
		}

		return left && right;
	}

}
