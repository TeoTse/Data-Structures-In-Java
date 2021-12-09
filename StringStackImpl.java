import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl implements StringStack {
	
	public Node head;
	public Node tail;
	
	public StringStackImpl() {
		this.head = null;
		this.tail = null;
	}
	
	@Override
	public boolean isEmpty() {
		if(this.head == null)
			return true;
		return false;
	}
	@Override
	public void push(String item) {
		Node new_node = new Node(item);
		if(isEmpty()) {
			this.head = new_node;
			this.tail = new_node;
			this.tail.next = null;
		}
		else {
			Node tmp;
			tmp = this.head;
			new_node.next = tmp;
			this.head = new_node;
		}
	}
	@Override
	public String pop() throws NoSuchElementException {
		try {
			String word = this.head.word;
			if(this.head == this.tail) {
				this.head = null;
				this.tail = null;
			}
			else		
				this.head = this.head.next;
			return word;
		}
		catch(NoSuchElementException exception){
			System.out.println("There is no element in the queue");
			return null;
		}
	}
	@Override
	public String peek() throws NoSuchElementException {
		try {
			return this.head.word;
		}
		catch(NoSuchElementException exception){
			System.out.println("There is no element in the queue");
			return null;
		}
	}
	@Override
	public void printStack(PrintStream stream) {
		Node tmp = this.head;
		while(tmp!=null) {
			stream.println(tmp.word);
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
	
}
