package day0821;

/**
 * 
 */
public class VariableArray {
	
	public static void main(String[] args) {
		int[][] arr2 = null;
		
		arr2 = new int[5][];
		
		arr2[0] = new int[5];
		arr2[1] = new int[2];
		arr2[2] = new int[] {1,2,3,4,5,6,7};
		arr2[3] = new int[] {1,2,3};
		arr2[4] = new int[1];
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.printf("arr2[%d]의 열의 수는 %d개\n", i, arr2[i].length);
		}
		
		arr2[0][0] = 2025;
		arr2[2][6] = 2025;
		
		for(int[] arr : arr2) {
			for(int ele : arr) {
				System.out.printf("%d\t", ele);
			}
			System.out.println();
		}
	}
}
