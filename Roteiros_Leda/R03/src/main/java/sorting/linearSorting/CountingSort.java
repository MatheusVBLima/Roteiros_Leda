package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if ((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length))
			return;
		
		if(leftIndex >= rightIndex)
			return;
		
		int [] arrayFrequencia = new int[maiorDoArray(array, leftIndex, rightIndex)];
		
		for (int i = leftIndex; i <= rightIndex; i++) 
			arrayFrequencia[array[i]] += 1;
		
		for (int i = 1; i < arrayFrequencia.length; i++) 
			arrayFrequencia[i] += arrayFrequencia[i - 1];
		
		Integer[] arrayAux = Arrays.copyOf(array, array.length);
		
		for (int i = rightIndex; i >= leftIndex; i--) {
			array[leftIndex + arrayFrequencia[arrayAux[i]] - 1] = arrayAux[i];
			arrayFrequencia[arrayAux[i] ] -= 1;
		}
		
		
	}
	
	private int maiorDoArray(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			if(array[i] > maior) {
				maior = array[i];
			}
		}
		
		return maior + 1;
	}

}
