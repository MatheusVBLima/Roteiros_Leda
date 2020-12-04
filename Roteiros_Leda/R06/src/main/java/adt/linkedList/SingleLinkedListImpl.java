package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return (this.head.isNIL());
	}

	@Override
	public int size() {
		int length = 0;

		if (this.head.getData() != null) {
			SingleLinkedListNode<T> node = this.head;
			while (node.getData() != null) {
				length++;
				node = node.getNext();
			}
		}
		return length;
	}

	@Override
	public T search(T element) {
		T result = null;
		if (element != null) {
			SingleLinkedListNode<T> node = this.getHead();
			while (!node.isNIL()) {
				if (node.getData().equals(element)) {
					result = (T) node.getData();
					break;
				}
				node = node.getNext();
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> node = this.head;
		if (element != null) {
			if (this.head.isNIL()) {
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>();
				newHead.setData(element);
				newHead.setNext(new SingleLinkedListNode<T>());
				this.setHead(newHead);
			} else {
				while (!node.isNIL()) {
					node = node.getNext();
				}
				node.setData(element);
				node.setNext(new SingleLinkedListNode<T>());
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()) {
			if (this.getHead().getData().equals(element)) {
				this.head = this.head.getNext();
			} else {
				SingleLinkedListNode<T> nextNode = this.head;
				SingleLinkedListNode<T> previousNode = this.head;

				while (!nextNode.isNIL() && !nextNode.getData().equals(element)) {
					previousNode = nextNode;
					nextNode = nextNode.getNext();
				}
				if (!nextNode.isNIL()) {
					previousNode.setNext(nextNode.getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		List<T> array = new ArrayList<>();
		SingleLinkedListNode<T> node = this.head;
		while (!node.isNIL()) {
			array.add((T) node.getData());
			node = node.getNext();
		}
		return (T[]) array.toArray();
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
