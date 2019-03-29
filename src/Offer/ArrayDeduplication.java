package Offer;

import java.util.Arrays;

public class ArrayDeduplication{
	public static void main(String[] args) {
		int[] arr = {1,5,4,5,3,2,4};
		int[] res = new int[1];
//		System.out.println(dedup(arr));
		dedup1(arr,res);
		System.out.println(res[0]);
	}
//	方法一
	public static char dedup(int[] arr){
		String str = Arrays.toString(arr);
		for(int i=0;i<str.length();i++) {
			if(str.indexOf(str.charAt(i))!=i&&Character.isDigit(str.charAt(i))) {
				return str.charAt(i);
			}
		}
		return '0';
	}
//	长度为n的数组中所有数字都在0-n-1范围内
	public static boolean dedup1(int []arr,int[] res) {
		int len = arr.length;
		int temp;
		for(int i=0;i<len;i++) {
			if(arr[i]<0||arr[i]>len-1) {
				return false;
			}
			while(arr[i]!=i) {
				if(arr[i]!=arr[arr[i]]) {
					temp = arr[i];
					arr[i] = arr[temp];
					arr[temp] = temp;
				}
				else {
					res[0] = arr[i];
		
					return true;
				}
				
			}
		}
		return false;
	}
}
