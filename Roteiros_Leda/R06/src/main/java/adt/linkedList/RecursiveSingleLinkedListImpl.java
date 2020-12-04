package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}
	
	public RecursiveSingleLinkedListImpl(T data) {
		this.data = data;
		
	}

	@Override
	public boolean isEmpty() {
		return (this.getData() == null);
	}

	@Override
	public int size() {
		int size = 0;
		if (!this.isEmpty()) {
			size = 1 + this.getNext().size();
		}
		return size;
	}

	@Override
	public T search(T element) {
		if (element != null) {
			if (isEmpty())
				return null;
			else {
				if (getData().equals(element))
					return getData();
				else
					return next.search(element);
			}
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveSingleLinkedListImpl<T>());
			} else {
				next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if(isEmpty()) {
			return;
		}
		if (element != null) {
			if (!isEmpty()) {
				if (getData().equals(element)) {
					setData(next.getData());
					setNext(next.next);
				} else
					next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		List<T> array = new ArrayList<>();
		recursiveToArray(array);
		return (T[]) array.toArray();
	}

	private void recursiveToArray(List<T> array){
		if (!this.isEmpty()) {
			array.add(this.getData());
			if(this.getNext() == null) {
				return;
			}
			this.getNext().recursiveToArray(array);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
