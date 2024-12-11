// Oliver Benjamin CSE 146


// custom heap without arraylists
public class MinHeap<T extends Comparable<T>> {
    private T[] heap;
    private int size;

    public MinHeap() {
        heap = (T[]) new Comparable[10]; // Initial size of 10
        size = 0;
    }

    public void add(T item) {
        if (size == heap.length) {
            resize();
        }
        heap[size] = item;
        heapifyUp(size);
        size++;
    }

    public T remove() {
        if (size == 0) return null;

        T root = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        heapifyDown(0);
        return root;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        T[] newHeap = (T[]) new Comparable[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[index].compareTo(heap[parent]) < 0) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && heap[left].compareTo(heap[smallest]) < 0) {
            smallest = left;
        }

        if (right < size && heap[right].compareTo(heap[smallest]) < 0) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
