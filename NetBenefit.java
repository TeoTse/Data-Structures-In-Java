import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NetBenefit {
	
	public IntQueueImpl prices;
	public IntQueueImpl stocks;
	
	public NetBenefit() {
		this.stocks = new IntQueueImpl();
		this.prices = new IntQueueImpl();
	}
	
	public static void main(String[] args)  
	{  
		int profit = 0;
		NetBenefit net_ben = new NetBenefit();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(args[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
		   String line = scanner.nextLine();
		   String arr [] = line.split(" ");
		   String stock = arr[1];
		   String price = arr[3];
		   if(arr[0].compareTo("buy") == 0) {
			   
			   net_ben.prices.put(Integer.parseInt(price));
			   net_ben.stocks.put(Integer.parseInt(stock));
		   }
		   else if(arr[0].compareTo("sell") == 0) {
			   int st = Integer.parseInt(stock);
			   int pr = Integer.parseInt(price);
			   int tmp = st;
			   Node node_tmp = net_ben.stocks.head;
			   while(tmp>0 && node_tmp != null) {
				   if(node_tmp!=null) {
					   tmp = tmp - node_tmp.number;
					   node_tmp = node_tmp.next;
				   }
			   }
			   if(tmp > 0) {
				   System.out.println("Stocks you own are less than the ones you try to sell!");
				   return;
			   }
			   while(st>0) {
				   if(st - net_ben.stocks.peek() >= 0) {
					   int tmp_st = net_ben.stocks.get();
					   int tmp_pr = net_ben.prices.get();
					   profit = profit + tmp_st*(pr-tmp_pr);
					   st = st - tmp_st;
				   }
				   else
				   {
					   profit = profit + st*(pr - net_ben.prices.peek());
					   st = 0;
					   net_ben.stocks.change_head(net_ben.stocks.peek() - st);
				   }
			   }
		   }
		}
		//Uncomment thn grammh apo katw an xreiazetai na emfanizei to profit
		//System.out.println(profit);
	}  
}  
