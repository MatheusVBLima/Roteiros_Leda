package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {

	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}

	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		return isBSTRec(bst.getRoot());
	}

	private boolean isBSTRec(BSTNode<T> node) {
		boolean right = true;
		boolean left = true;

		if (!node.getRight().isEmpty()) {
			if (node.getRight().getData().compareTo(node.getData()) < 0) {
				right = false;
			} else {
				right = isBSTRec((BSTNode<T>) node.getRight());
			}
		}

		if (!node.getLeft().isEmpty()) {
			if (node.getLeft().getData().compareTo(node.getData()) > 0) {
				left = false;
			} else {
				left = isBSTRec((BSTNode<T>) node.getLeft());
			}
		}

		return left && right;
	}

}
