package heap;

public class Tester {

	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<>(4);
		for(int i = 0; i < 4; i++) {
			heap.add(i);
		}
		for(int i = 0; i < 4; i++) {
			System.out.println(heap.remove());
		}
		

	
		
	}
	

}
