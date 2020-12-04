package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		sort(array, 0, array.length - 1);
		return buscaBinariaRecursiva(array, x, 0, array.length);
	}

	public int buscaBinariaRecursiva(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		int meio = (leftIndex + rightIndex) / 2;
		if (contemNum(array, x)) {
			if (x > array[meio]) {
				return buscaBinariaRecursiva(array, x, meio + 1, rightIndex);
			} else if (x < array[meio]) {
				return buscaBinariaRecursiva(array, x, leftIndex, meio - 1);
			}

			return x;
		} else {
			boolean temMaior = false;
			int floor = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] > x) {
					floor = array[i - 1];
					temMaior = true;
				}
			}
			if (temMaior == true) {
				return floor;
			} else if (temMaior == false && x < array[0]) {
				return -1;
			} else {
				return array[array.length - 1];
			}
		}

	}

	private boolean contemNum(Integer[] array, Integer x) {
		boolean contem = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == x) {
				contem = true;
				break;
			}
		}
		return contem;

	}

	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if ((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length)) {
			return;
		}
		if (rightIndex - leftIndex <= 0) {
			return;
		}
		if (leftIndex < rightIndex) {
			int pivot = separa(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex);
		}
	}

	private Integer separa(Integer[] array, int leftIndex, int rightIndex) {
		int i = leftIndex;
		int pivot = array[leftIndex];

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j] < pivot) {
				i++;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;

	}
}
