package day0821;

/**
 * 삼차원배열 : 면, 행, 열로 구성된 배열
 */
public class UseArray3 {
	
	public UseArray3() {
		// 기본형 형식) 데이터형[][][] 배열명 = new 데이터형[][][] {{{값,},{,}},{{,},{,}}};
		int[][][] arr3 ={ 	{{1,2,3},{4,5,6}},
							{{7,8,9},{10,11,12}}
						};
		System.out.printf("%d면 %d행 %d열\n", 
		arr3.length, arr3[0].length, arr3[0][0].length);
		
		for(int i = 0; i < arr3.length; i++) {
			System.out.println(i + "면 시작");
			for(int j = 0; j < arr3[0].length; j++) {
				System.out.println(j + "행 시작");
				for (int k = 0; k < arr3[0][0].length; k++) {
					System.out.printf("arr[%d][%d][%d]=%d\t", i, j, k,
							arr3[i][j][k]);
				}
				System.out.println("\n" + j + "행 끝");
			}
			System.out.println(i + "면 끝");
		}
		
		for(int[][] arr2 : arr3) {
			for(int[] arr : arr2) {
				for(int ele : arr) {
					System.out.printf("%d\t", ele);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		UseArray3 ua3 = new UseArray3();
		
	}
}
