package day0821;

/**
 * 이차원 배열 : 행과 열로 구성된 배열
 */



public class UseArray2{
	
	public void useArray2() {
		int[][] arr2 = null;
		int arr3[][] = null;
		
		arr2 = new int[3][4];
		arr3 = new int[5][6];
		
		System.out.println(arr2);
		System.out.println(arr3);
		
		System.out.println(arr2[0]);
		System.out.println(arr2[0][0] + " / " + arr2[2][3]);
		System.out.printf("arr2 배열의 행 %d개, 열 %d개\n", arr2.length, arr2[0].length);
		System.out.printf("arr2 배열의 행 %d개, 열 %d개\n", arr3.length, arr3[0].length);
		
		arr2[0][0] = 2025;
		arr2[0][1] = 8;
		System.out.println(arr2[0][0] + " / " + arr2[0][1]);
		
		for (int i = 0; i < arr2.length; i++) {
			for(int j = 0; j < arr2[0].length; j++) {
				System.out.printf("arr2[%d][%d]=%-6d\t", i, j, arr2[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------");
		for (int[] element : arr2) {
			for (int element2 : element) {
				System.out.print(element2 + " ");				
			}
			System.out.println();
		}
		System.out.println("----------매개변수로 행 전달---------");
//		for(int i = 0; i < arr2.length; i++) {
//			rowProcess(arr2[i]);
//			System.out.println();
//		}
		for(int[] arr : arr2) {
			rowProcess(arr);
			System.out.println();
		}
	}
	
	public void rowProcess(int[] arr) {
//		arr[0] = 300;
//		arr[1] = 200;
		
		for (int ele : arr) {
			System.out.printf("%d\t", ele);
		}
	}
	
	public void useArray3() {
//		int[][] arr2 = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		int[][] arr2 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		System.out.printf("%d행 %d열\n", arr2.length, arr2[0].length);
		
		for (int[] arr : arr2) {
			for(int ele : arr) {
				System.out.printf("%d\t", ele);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		UseArray2 ua2 = new UseArray2();
		ua2.useArray2();
		System.out.println("----------기본형 형식의 사용----------");
		ua2.useArray3();
	}

}
