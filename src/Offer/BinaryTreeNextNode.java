package Offer;

public class BinaryTreeNextNode {
	public static void main(String[] args) {		
		TreeNode tree1 = new TreeNode(1,null);	
		TreeNode tree2 = new TreeNode(2,tree1);
		TreeNode tree3 = new TreeNode(3,tree1);
		TreeNode tree6 = new TreeNode(6,tree3);
		TreeNode tree5 = new TreeNode(5,tree3);
		TreeNode tree4 = new TreeNode(4,tree2);	
		TreeNode tree8 = new TreeNode(8,tree6);
		TreeNode tree7 = new TreeNode(7,tree4);
		tree1.leftNode=tree2;
		tree1.rightNode=tree3;
		tree2.leftNode = tree4;
		tree4.rightNode = tree7;
		tree3.leftNode=tree5;
		tree3.rightNode = tree6;
		tree6.leftNode = tree8;
		TreeNode res = GetNext(tree7);
		if(res!=null)
			System.out.println(res.val);
		else {
			System.out.println("该节点没有下一个结点");
		}
	}
	/**  
	* @Title: GetNext  
	* @Description: 得到中序遍历当前结点的的下一个结点
	* @param @param node
	* @param @return      
	* @return int     
	* @throws  
	*/ 
	public static TreeNode GetNext(TreeNode node) {
		if(node==null)
			return null;
		TreeNode pNext = null;
		if(node.rightNode!=null) {
			TreeNode rightNode = node.rightNode;
			while(rightNode.leftNode!=null) {
				rightNode = rightNode.leftNode;
			}
			pNext = rightNode;
		}
		else {
			TreeNode parentNode =node.next;
			TreeNode currentNode =node;
			while(parentNode!=null&&parentNode.rightNode == currentNode) {
				currentNode = parentNode;
				parentNode = parentNode.next;
			}
			pNext = parentNode;
		}
		return pNext;
	}

}
