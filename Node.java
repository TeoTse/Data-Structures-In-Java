
public class Node {
	
	public int number;
	public String word;
	public Node next;
	
	public Node(int numb) {
		this.number = numb;
		this.next = null;
		this.word = null;
	}
	
	public Node(String w) {
		this.number = 0;
		this.next = null;
		this.word = w;
	}
	
}
