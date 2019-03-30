package Offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ReConstructBinaryTree {
	public static void main(String[] args) {
		int []pre = {1,2,4,7,3,5,6,8};
		int []in = {4,7,2,1,5,3,8,6};
		TreeNode tn = reConstructBinaryTree(pre,in);
		System.out.print("前序遍历结果:");
		printPreorder1(tn);
		System.out.print("\n中序遍历结果:");
		printInorder(tn);
		System.out.print("\n后序遍历结果:");
		printPostorder(tn);
		System.out.print("\n层次遍历结果:");
		printLevel(tn);
		System.out.println();
		System.out.println("头结点为:"+tn.val);
	}
	//重建二叉树
	public static TreeNode reConstructBinaryTree(int pre[],int in[]) {
		int lenp = pre.length;
		int leni = in.length;
		if(pre==null||in==null||lenp!=leni||lenp<1||leni<1) {
			return null;
		}
		return reConstructBinaryTree(pre,0,lenp-1,in,0,leni-1);
	}
	public static TreeNode reConstructBinaryTree(int Preorder[],int ps,int pe,int Inorder[],int is,int ie) {
		if(ps>pe)
			return null;
		int root = Preorder[ps];
		int index = is;
		while(index<=ie&&Inorder[index]!=root) {
			index++;
		}
		//输入不合法
		if(index>ie) {
			throw new RuntimeException("invalid input"+index);
		}
		TreeNode tn = new TreeNode();
		tn.val = root;
		tn.leftNode = reConstructBinaryTree(Preorder,ps+1,ps-is+index,Inorder,is,index-1);
		tn.rightNode = reConstructBinaryTree(Preorder,ps+index-is+1,pe,Inorder,index+1,ie);
		return tn;
	}
//	递归遍历二叉树
	public static void printPreorder(TreeNode node) {
		if(node!=null) {
			System.out.print(node.val+" ");
			printPreorder(node.leftNode);
			printPreorder(node.rightNode);
		}
	}
//	非递归先序遍历
	public static void printPreorder1(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(!stack.isEmpty()||node!=null) {
			while(node!=null) {
				System.out.print(node.val+" ");
				stack.push(node);
				node = node.leftNode;
			}
			if(!stack.isEmpty()) {
				node = stack.pop();
				node = node.rightNode;
			}
		}
	}
	public static void printInorder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(!stack.isEmpty()||node!=null) {
			while(node!=null) {
				stack.push(node);
				node = node.leftNode;
			}
			if(!stack.isEmpty()) {
				node = stack.pop();
				System.out.print(node.val+" ");
				node = node.rightNode;
			}
		}
	}
//	非递归后序遍历
	public static void printPostorder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = node;
		while(node!=null) {
			while(node.leftNode!=null) {
				stack.push(node);
				node = node.leftNode;
			}
			while(node!=null&&(node.rightNode==null||node.rightNode==p)) {
				System.out.print(node.val+" ");
				p=node;
				if(!stack.isEmpty()) {
					node = stack.pop();
				}
				else{return;}
				
			}
//			处理右子树
			stack.push(node);
			node = node.rightNode;
		}
	}
	
//	非递归层次遍历
	public static void printLevel(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(node);
		while(!queue.isEmpty()) {
			TreeNode res = queue.poll();
			if(res!=null) {
				System.out.print(res.val+" ");
			}
			if(res.leftNode!=null) {
				queue.offer(res.leftNode);
			}
			if(res.rightNode!=null) {
				queue.offer(res.rightNode);
			}
		}
	}
	
	
}

