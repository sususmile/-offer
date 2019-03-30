package Offer;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseLinklist {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();	
		ListNode ln4 = new ListNode(56,null);	
		ListNode ln3 = new ListNode(45,ln4);	
		ListNode ln2 = new ListNode(24,ln3);
		ListNode ln1 = new ListNode(1,ln2);
		list1 = printfromTailtoHead(ln1);
		System.out.println(list1);
	}
	
	public static ArrayList<Integer> printfromTailtoHead(ListNode listNode){
		Stack<Integer> stack = new Stack<Integer>();
		while(listNode!=null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	}

}
