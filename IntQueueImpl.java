import java.io.PrintStream;
import java.util.NoSuchElementException;

public class IntQueueImpl implements IntQueue{
	
	public Node head = null;
	public Node tail = null;
	
	@Override
	public boolean isEmpty() {
		if(this.head == null)
			return true;
		return false;
	}

	@Override
	public void put(int item) {
		Node new_node = new Node(item);
		if(isEmpty()) {
			this.head = new_node;
			this.tail = new_node;
			this.tail.next = null;
		}
		else {
			new_node.next = null;
			this.tail.next = new_node;
			this.tail = new_node;
		}
	}

	@Override
	public int get() throws NoSuchElementException {
		try {
			Node tmp;
			tmp = this.head;
			this.head = this.head.next;
			return tmp.number;
		}
		catch(NoSuchElementException exception){
			System.out.println("There is no element in the queue");
			return 0;
		}
	}

	@Override
	public int peek() throws NoSuchElementException {
		try {
			return this.head.number;
		}
		catch(NoSuchElementException exception){
			System.out.println("There is no element in the queue");
			return 0;
		}
	}

	@Override
	public void printQueue(PrintStream stream) {
		printHelper(head,stream);
	}
	
	public void printHelper(Node v, PrintStream stream) {
		Node tmp = this.head;
		while(tmp!=null) {
			stream.println(tmp.number);
			tmp = tmp.next;
		}
	}
	
	@Override
	public int size() {
		if(isEmpty())
			return 0;
		int size = 0;
		Node tmp = this.head;
		while(tmp!=this.tail) {
			tmp = tmp.next;
			size ++;
		}
		return size;
	}
	
	public void change_head(int num) {
		this.head.number = num;
	}
}
