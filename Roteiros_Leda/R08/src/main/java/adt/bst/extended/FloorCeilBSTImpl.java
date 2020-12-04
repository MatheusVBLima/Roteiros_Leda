package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bt.BTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		for (Integer inteiro : array) {
			this.insert(inteiro);
		}
		
		return floorRec(this.root, numero, null);
	}
	
	private Integer floorRec(BTNode<Integer> node, double numero, Integer floor) {
		Integer resposta = floor;
		
		if(!node.isEmpty()) {
			if(numero == node.getData()) {
				resposta = node.getData();
			}else if(numero < node.getData()) {
				resposta = floorRec(node.getLeft(), numero, floor);
			}else if(numero > node.getData()) {
				resposta = floorRec(node.getRight(), numero, node.getData());
			}
		}
		
		return resposta;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for (Integer inteiro : array) {
			this.insert(inteiro);
		}
		
		return ceilRec(this.root, numero, null);
	}
	
	private Integer ceilRec(BTNode<Integer> node, double numero, Integer ceil) {
		Integer resposta = ceil;
		
		if(!node.isEmpty()) {
			if(numero == node.getData()) {
				resposta = node.getData();
			}else if(numero < node.getData()) {
				resposta = ceilRec(node.getLeft(), numero, ceil);
			}else if(numero > node.getData()) {
				resposta = ceilRec(node.getRight(), numero, ceil);
			}
		}
		
		return resposta;
	}

}
