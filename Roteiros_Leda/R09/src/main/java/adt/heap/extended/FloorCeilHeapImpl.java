package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	private void insertAux(Integer[] array) {
		this.heap = new Integer[array.length];
		this.index = -1;

		for (Integer i : array) {
			insert(i);
		}
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer resultado = null;

		if (array.length > 0) {
			insertAux(array);

			if (comparator.compare(1, 2) > 0) {
				resultado = floorMiniHeap(numero, null);
			} else {
				resultado = floorMaxHeap(numero, null);
			}

		}

		return resultado;
	}

	private Integer floorMiniHeap(double numero, Integer floor) {
		Integer resultado = floor;

		if (!isEmpty()) {
			if (rootElement() == numero) {
				resultado = rootElement();
			} else if (rootElement() < numero) {
				Integer root = extractRootElement();
				resultado = floorMiniHeap(numero, root);
			}
		}

		return resultado;
	}

	private Integer floorMaxHeap(double numero, Integer floor) {
		Integer resultado = floor;

		if (!isEmpty()) {
			if (rootElement() <= numero) {
				resultado = rootElement();
			} else {
				extractRootElement();
				resultado = floorMaxHeap(numero, floor);
			}
		}

		return resultado;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer resultado = null;

		if (array.length > 0) {
			insertAux(array);
			if (comparator.compare(1, 2) > 0) {
				resultado = ceilMiniHeap(numero, null);
			} else {
				resultado = ceilMaxHeap(numero, null);
			}
		}

		return resultado;
	}

	private Integer ceilMiniHeap(double numero, Integer ceil) {
		Integer resultado = ceil;

		if (!isEmpty()) {
			if (rootElement() >= numero) {
				resultado = rootElement();
			} else {
				extractRootElement();
				resultado = ceilMiniHeap(numero, ceil);
			}
		}

		return resultado;
	}
	
	private Integer ceilMaxHeap(double numero, Integer ceil) {
		Integer resultado = ceil;
		
		if (!isEmpty()) {
			if (rootElement() == numero) {
				resultado = rootElement();
			} else if (rootElement() > numero) {
				Integer root = extractRootElement();
				resultado = ceilMaxHeap(numero, root);
			}
		}

		return resultado;
	}

}
