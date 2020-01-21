import java.util.*;
/*
 * Problem Name: QHEAP1
 * Problem Link: https://www.hackerrank.com/challenges/qheap1/problem
 * Developer Name: Rakesh Kumar
 * LinkedIn Profile: https://in.linkedin.com/in/rknitpcse-rkuohcs
 */
class MinHeap {

    /** Fixed-size array based heap representation */
    private int[] h;
    /** Number of nodes in the heap (h) */
    private int n = 0;

    /** Constructs a heap of specified size */
    public MinHeap(final int size) {
        h = new int[size];
    }

    /** Returns (without removing) the smallest (min) element from the heap. */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty!");
        }
        return h[0];
    }

    /** Removes and returns the smallest (min) element from the heap. */
    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty!");
        }

        final int min = h[0];
        h[0] = h[n - 1];
        if ((n = (n-1) ) > 0)
            siftDown(0);
        return min;
        
    }

    /** Checks if the heap is empty. */
    public boolean isEmpty() {
        return n == 0;
    }

    /** Adds a new element to the heap and sifts up/down accordingly. */
    public void add(final int value) {
        if (n == h.length) {
            throw new RuntimeException("Heap is full!");
        }
        
        h[n] = value;
        siftUp(n);
        n = n + 1;
        
    }

    /**
     * Sift up to make sure the heap property is not broken. This method is used
     * when a new element is added to the heap and we need to make sure that it
     * is at the right spot.
     */
    private void siftUp(final int index) {
        if (index > 0) {
            final int parent = (index - 1) / 2;
            if (h[parent] > h[index]) {
                swap(parent, index);
                siftUp(parent);
            }
        }
    }

    /**
     * Sift down to make sure that the heap property is not broken This method
     * is used when removing the min element, and we need to make sure that the
     * replacing element is at the right spot.
     */
    private void siftDown(int index) {

        final int leftChild = 2 * index + 1;
        final int rightChild = 2 * index + 2;

        // Check if the children are outside the h bounds.
        if (rightChild >= n && leftChild >= n)
            return;

        // Determine the smallest child out of the left and right children.
        final int smallestChild = h[rightChild] > h[leftChild] ? leftChild
                : rightChild;

        if (h[index] > h[smallestChild]) {
            swap(smallestChild, index);
            siftDown(smallestChild);
        }
    }

    /** Helper method for swapping h elements */
    private void swap(int a, int b) {
        int temp = h[a];
        h[a] = h[b];
        h[b] = temp;
    }

/** Returns the size of heap. */    
    public int size() {
        return n;
    }
    private void removeAt(int where) {
        // This should never happen, you should ensure to call it only with valid indices
        if (n == 0) throw new IllegalArgumentException("Trying to delete from empty heap");
        if (where >= n) throw new IllegalArgumentException("Informative error message");

        // Now for the working cases
        if (where == n-1) {
            // removing the final leaf, trivial
            n = n - 1;
            return;
        }
        // other nodes
        // place last leaf into place where deletion occurs
        h[where] = h[n-1];
        // take note that we have now one element less
        n = n - 1;
        // the new node here can be smaller than the previous,
        // so it might be smaller than the parent, therefore sift up
        // if that is the case
        if (where > 0 && h[where] > h[(where-1)/2]) {
            siftUp(where);
        } else if (where < n/2) {
            // Now, if where has a child, the new value could be larger
            // than that of the child, therefore sift down
            siftDown(where);
        }
    }
    public void remove(int value) {
        for(int i = 0; i < n; ++i) {
            if (h[i] == value) {
                removeAt(i);
                // assumes that only one value should be removed,
                // even if duplicates are in the heap, otherwise
                // replace the break with --i to continue removing
                break;
            }
        }
    }

}
public class QHEAP1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int MAX_SIZE = 25;
		
		Scanner scan = new Scanner(System.in);
		int queries = scan.nextInt();
		scan.nextLine();
		MinHeap minHeap = new MinHeap(MAX_SIZE);
		while(queries-- > 0)
		{
			String line = scan.nextLine();
			String[] items = line.split(" ");
			//insertion and deletion from min-heap
			if(items.length > 1)
			{
				int operation = Integer.parseInt(items[0]);
				int value = Integer.parseInt(items[1]);
				//insertion in min-heap
				if(operation == 1)
				{
					//System.out.prin
					minHeap.add(value);
				}
				//deletion in min-heap
				else if(operation == 2)
				{
					minHeap.remove(value);
				}
			}
			//find minimum from min-heap
			else
			{
				int operation = Integer.parseInt(items[0]);
				if(operation == 3)
					System.out.println(minHeap.peek());
			}
		}
		scan.close();
	}

}
