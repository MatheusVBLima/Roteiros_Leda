package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes: - Ter
 * contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 * que essa informação possa ser capturada pelo teste. - A cada chamado do
 * método de sort(T[] array) esses contadores são resetados. E a cada chamada
 * interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 * INSERTIONSORT_APPLICATIONS são incrementados. - O InsertionSort utilizado no
 * algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort algorithm
	 * will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		hybridMergeSort(array, leftIndex, rightIndex);

	}
	private void hybridMergeSort (T[] array, int leftIndex, int rightIndex) {
		if ((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length)) {
			return;
		}
		if (rightIndex - leftIndex <= 0) {
			return;
		}

		if ((rightIndex - leftIndex) + 1 > SIZE_LIMIT) {
			int meio = (leftIndex + rightIndex) / 2;

			hybridMergeSort(array, leftIndex, meio);
			hybridMergeSort(array, meio + 1, rightIndex);

			mergeSort(array, leftIndex, meio, rightIndex);
			MERGESORT_APPLICATIONS += 2;
		} else {
			insertionSort(array, leftIndex, rightIndex);
			INSERTIONSORT_APPLICATIONS += 1;
		}
	}

	private void mergeSort(T[] array, int leftIndex, int meio, int rightIndex) {

		T[] auxiliar = (T[]) new Comparable[array.length];

		for (int i = leftIndex; i <= rightIndex; i++) {
			auxiliar[i] = array[i];
		}

		int i = leftIndex;
		int j = meio + 1;
		int k = leftIndex;

		while (i <= meio && j <= rightIndex) {
			if (auxiliar[i].compareTo(auxiliar[j]) < 0) {
				array[k] = auxiliar[i];
				i++;
			} else {
				array[k] = auxiliar[j];
				j++;
			}
			k++;
		}

		while (i <= meio) {
			array[k] = auxiliar[i];
			i++;
			k++;
		}

		while (j <= rightIndex) {
			array[k] = auxiliar[j];
			j++;
			k++;
		}

	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i < rightIndex + 1; i++) {
			T chave = array[i];
			int j = i - 1;
			
			while (j >= leftIndex && array[j].compareTo(chave) > 0) {
				array[j+1] = array[j];
				j--;
				
			}
			array[j+1] = chave;

		}
	}
}
