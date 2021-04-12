package heap;

public class Heap<E> {

	E[] array;
	int lastPosition;

	@SuppressWarnings("unchecked")
	public Heap(int size) {
		array = (E[]) new Object[size];
		lastPosition = -1;
	}

	public void add(E data) {

		array[++lastPosition] = data;
		trickleUp(lastPosition);

	}

	@SuppressWarnings("unchecked")
	private void trickleUp(int position) {
		if (position == 0) {
			return;
		}

		int parent = (position - 1) / 2;
	

		if (((Comparable<E>) array[position]).compareTo(array[parent]) > 0) {
			swap(parent, position);
            trickleUp(parent);
		}

	}

	private void swap(int a, int b) {
		E data = array[a];
		array[a] = array[b];
		array[b] = data;
		
	}
	
	public E remove() {
		E data = array[0];
		swap(0, lastPosition--);
		trickleDown(0);
		return data;
	}

	@SuppressWarnings("unchecked")
	private void trickleDown(int parent) {
	
		int left = 2 * parent + 1;
		int right = 2 * parent + 2;
		
		if (left == lastPosition && ((Comparable<E>) array[left]).compareTo(array[parent]) > 0) {
			swap(left, parent);
			return;
		}
		
		if (right == lastPosition && ((Comparable<E>) array[right]).compareTo(array[parent]) > 0) {
			swap(right, parent);
			return;
		}
		
		
		if (left > lastPosition || right > lastPosition) {
			return;
		}
		
		if (((Comparable<E>)array[left]).compareTo(array[parent]) > 0 && ((Comparable<E>) array[left]).compareTo(array[right]) > 0) {
			swap(left, parent);
			trickleDown(left);
		} 
		
		 if (((Comparable<E>)array[right]).compareTo(array[parent]) > 0 ) {
			swap(right, parent);
			trickleDown(right);
		}
		
	}
	
	public void print() {
		for(E data : array) {
			System.out.println(data);
		}
	}

}
