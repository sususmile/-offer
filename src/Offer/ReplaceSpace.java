package Offer;

public class ReplaceSpace {
	public static void main(String[] args) {
		String str = "We are happy";
//		str = str.replaceAll(" ", "%20");
//		System.out.println(str);
		str = replace(str);
		System.out.println(str);
	}
	public static String replace(String str) {
		StringBuffer bf = new StringBuffer(str);
		for(int i=0;i<bf.length();i++) {
			if(bf.charAt(i)==' ') {
				bf.deleteCharAt(i);
				bf.insert(i, "%20");
			}
		}
		str = bf.toString();
		return str;
	}

}
