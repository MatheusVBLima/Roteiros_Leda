package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada
 * 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return equalsRec(tree1.getRoot(), tree2.getRoot());
	}

	private boolean equalsRec(BTNode<T> node1, BTNode<T> node2) {
		if (node1.isEmpty() && node2.isEmpty()) {
			return true;
		}

		if (!node1.equals(node2)) {
			return false;
		}

		if (!node1.isEmpty() && !node2.isEmpty()) {
			if (!equalsRec(node1.getLeft(), node2.getLeft())) {
				return false;
			} else if (!equalsRec(node1.getRight(), node2.getRight())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return isSimilarRec(tree1.getRoot(), tree2.getRoot());
	}

	private boolean isSimilarRec(BTNode<T> node1, BTNode<T> node2) {
		if (node1.isEmpty() && node2.isEmpty()) {
			return true;
		}

		if (!node1.isEmpty() && !node2.isEmpty()) {
			if (!isSimilarRec(node1.getLeft(), node2.getLeft())) {
				return false;
			} else if (!isSimilarRec(node1.getRight(), node2.getRight())) {
				return false;
			}
		}

		return true;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T resposta = null;

		if (k >= 1 && k <= tree.size()) {
			BSTNode<T> minimo = tree.minimum();
			resposta = orderStatisticRec(tree, k, minimo);
		}

		return resposta;
	}

	private T orderStatisticRec(BST<T> tree, int k, BTNode<T> node) {
		T resposta = node.getData();

		if (k > 1) {
			resposta = orderStatisticRec(tree, k - 1, tree.sucessor(node.getData()));
		}

		return resposta;
	}

}
