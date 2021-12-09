import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TagMatching {

	public StringStackImpl my_stack;
	
	public TagMatching() {
		this.my_stack = new StringStackImpl();
	}
	
	public static void main(String args[]) throws IOException {
		TagMatching tag_match = new TagMatching();
		File my_file=new File(args[0]);
	    String[] words = null;
	    FileReader fr = null;
		try {
			fr = new FileReader(my_file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    BufferedReader br = new BufferedReader(fr);
	    String s;
	    while((s=br.readLine())!=null)   
	    {
	    	words=s.split(" ");
	        for (String word : words) 
	        {
	        	String[] tmp_w = word.split("");
	        	if((tmp_w [0].compareTo("<") == 0) && (tmp_w[word.length()-1].compareTo(">") == 0)){
	        		if(tmp_w[1].compareTo("/") == 0)
	        		{
	        			int i = 2;
	        			String pop_word = tag_match.my_stack.peek();
	        			String [] p = pop_word.split("");
	        			while(i<word.length()-2) {
	        				if(p[i-1].compareTo(tmp_w[i])!=0) {
	        					System.out.println("There is a mismatch of tags");
	        					return;
	        				}
	        				else if(i == (word.length()-3)){
	        					tag_match.my_stack.pop();
	        				}
	        				i++;
	        			}
	        		}
	        		else
	        		{
	        			tag_match.my_stack.push(word);
	        		}
	        	}
	        }
	    }
	    if(!tag_match.my_stack.isEmpty()) {
	    	System.out.println("There is a mismatch of tags");
	    	return;
	    }
	    System.out.println("All good");
	    fr.close();
	}
}
