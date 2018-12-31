package sjsu.Singh.cs146.project1;


/**
 * This class creates a circular linked list and then checks the famous Josephus problem on the linked list created.
 * The motive is to eliminate every k+1th element from a circular linked list of n elements and return the final element left.
 * @author Moe
 * @version 1.0
 */
public class CircularLinkedList {
	Node head; 
	int size;
	
	/**
	 * This method adds a node in the circular linked list with the data given in parameter.
	 * @param data the data to be added to be node getting added
	 */
	public void insert(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if (head == null) {
			head = node;
			node.next = head;
		}
		else {
			Node n = head;
			while (n.next != head) {
				n = n.next;
			}
			n.next = node;
			node.next = head;
		}
		size++;
	}
	
	/**
	 * This method prints the circular linked list on the console.
	 */
	public void show() {
		Node node = head;
		
		while (node.next != head) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
	}
	
	/**
	 * This method deleted a particular node from the circular linked list.
	 * @param n the node to be deleted.
	 */
	public void delete(Node n) {
		Node node = n;
		
		while (node.next != n) {
			 node = node.next;
		}
		node.next = node.next.next;
		size--;
	}
	
	/**
	 * This method creates a circular linked list with n nodes with data starting from 1 to n i.e. inserts n nodes.
	 * @param n the int upto which the circular linked list is being created.
	 */
	public void createCircularLinkedList(int n) {
		for (int i=1; i<n+1; i++) {
			insert(i);
		}
	}
	
	/**
	 * This method computes the Josephus problem i.e. keeps deleteing every k+1th element in a circular linked list of n elements until we have only one node left. It then returns the data of thenode left.
	 * @param n the int upto which the circular linked list is being created or the number of 'prisoners'.
	 * @param k the count upto when counted on the linked list eliminates or deletes the node right after it.
	 * @return the final survivor of the Josephus game!
	 */
	public int isSurvivor(int n, int k) {
		
		CircularLinkedList prisoners = new CircularLinkedList();
		prisoners.createCircularLinkedList(n);
		
		Node node = prisoners.head;
		Node nextNode = prisoners.head; // the node pointer that gets changed after node gets deleted
		
		for (int i = 1; i < n; i++) {
			node = nextNode;
			for (int j = 0; j < k; j++) {
				node = node.next;
			}
			if (getData(node) == getData(prisoners.head) ) {
				prisoners.head = node.next;
			}
			nextNode = node.next;
			prisoners.delete(node);
		}
		int survivor = prisoners.head.data; // the survivor of the game
		System.out.println(survivor);
		return survivor;
		
	}
	
	/**
	 * This method returns the data of a node
	 * @param n the node
	 * @return data of the node
	 */
	public int getData(Node n) {
		return n.data;
	}
	
	/**
	 * Checks if the linked list is empty,
	 * @return true if it is indeed empty otherwise false.
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * This main method is used for testing and computing the Josephus game.
	 * @param args
	 */
	public static void main(String[] args) {
		CircularLinkedList csll = new CircularLinkedList();
		csll.isSurvivor(6, 2);
	}
}
