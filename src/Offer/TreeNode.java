package Offer;

public class TreeNode {
	int val;
	TreeNode leftNode=null;
	TreeNode rightNode=null; 
	TreeNode next=null;
	TreeNode(){
		
	}
	TreeNode(int val,TreeNode next){
		this.val = val;
		this.next = next;
	}
}
