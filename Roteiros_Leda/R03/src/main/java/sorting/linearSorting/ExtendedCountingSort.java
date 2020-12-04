package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if ((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length))
			return;

		if (leftIndex >= rightIndex)
			return;
		
		int menor = menorDoArray(array, leftIndex, rightIndex);
		int maior = maiorDoArray(array, leftIndex, rightIndex);

		int[] arrayFrequencia = new int[maior - menor + 1];

		for (int i = leftIndex; i <= rightIndex; i++)
			arrayFrequencia[array[i] - menor] += 1;

		for (int i = 1; i < arrayFrequencia.length; i++)
			arrayFrequencia[i] += arrayFrequencia[i - 1];

		Integer[] arrayAux = Arrays.copyOf(array, array.length);

		for (int i = rightIndex; i >= leftIndex; i--) {
			array[leftIndex + arrayFrequencia[arrayAux[i] - menor] - 1] = arrayAux[i];
			arrayFrequencia[arrayAux[i] - menor] -= 1;
		}

	}

	private int maiorDoArray(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}

		return maior;
	}

	private int menorDoArray(Integer[] array, int leftIndex, int rightIndex) {
		int menor = array[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] < menor) {
				menor = array[i];
			}
		}

		return menor;
	}
}
