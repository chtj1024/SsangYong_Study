package day0820;

/**
 * 행하나에 열(요소, element, 방)로만 구성된 배열.
 */
public class UseArray {
	
	public UseArray () {
		int[] arr = null;
		int arr2[] = null;
		
		// 2.생성) 배열명 = new 데이터형[방의개수];
		// heap에 동일데이터형으로 배열의 방이 생성되고 그 주소를 저장
		arr = new int[4];
		arr2 = new int[5];
		
		int[] arr3 = new int[6];
		
		System.out.println(arr + " / 방의 수 : " + arr.length);
		System.out.println(arr2 + " / 방의 수 : " + arr2.length);
		System.out.println(arr3 + " / 방의 수 : " + arr3.length);
		
		System.out.println(arr[0] + " / " + arr[1] + " / " + arr[3]);
		
		// 3. 값 할당) 배열명[방의번호] = 값;
		arr[0] = 2025;
		arr[1] = 8;
		arr[2] = 20;
		arr[3] = 14;
		// 4. 값 사용)
		System.out.println(arr[0] + " / " + arr[1] + " / " + arr[2] 
				+ " / " + arr[3]);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		// arr[0] ~ arr[3] 누적합 구하기
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
		
		int score[] = new int[5];
		score[0] = 90;
		score[1] = 86;
		score[2] = 99;
		score[3] = 78;
		score[4] = 66;
		
		System.out.println("번호 \t 점수");
		System.out.println("-------------------");
		
		int total = 0;
		for (int i = 0; i < score.length; i++) {
			System.out.printf("%d\t%d\n", i+1, score[i]);
			total += score[i];
		}
		System.out.println("------------------");
		System.out.printf("총점[%d], 평균[%.2f]", total, ((double)total / score.length));
		
		System.out.println("---------배열의 초기화----------");
//		int[] temp = {10, 20, 30, 40, 50, 60, 70, 80};
		int[] temp = new int[]{10, 20, 30, 40, 50, 60, 70, 80};
		System.out.println(temp.length);
		
//		for (int i = 0; i < temp.length; i++) {
//			System.out.println(temp[i]);
//		}
		// temp배열의 방의 값을 마지막방부터 처음방까지 출력
		for(int i = temp.length - 1; i >= 0; i--) {
			System.out.println(temp[i]);
		}
		
		String[] subject = new String[5];
		subject[0] = "Java SE";
		subject[1] = "Oracle DBMS";
		subject[2] = "JDBC";
		subject[2] = "HTML";
		subject[4] = "CSS";
		
		String[] subject2 = {"Java SE", "Oracle DBMS", "JDBC", "HTML", "CSS"};
		for(int i = 0; i < subject.length; i++) {
//			System.out.printf("[%-12s][%-12s]", subject[i], subject2[i]);
			// 모든 과목을 출력하는데 짝수번째 방의 과목은 소문자로 출력
			if (i % 2 == 0) {
				System.out.println(subject[i].toLowerCase());
			}
		}
		
		
		System.out.println("개선된 for문 사용");
		for(int element : score) {
			System.out.print(element + " ");
		}
		System.out.println();
		
		for (String element : subject2) {
			System.out.print(element + " ");
		}
		System.out.println();
		
		
		String csvData = "원숭이,닭,개,돼지,쥐,소,호랑이,토끼,용,뱀,말,양";
		String[] zodiac = csvData.split(",");
		for(String e : zodiac) {
			System.out.print(e + " ");
		}
		System.out.println();
		
		String data = "Java~.Orcle~.JDBC~.HTML~.JavaScript";
//		String[] temp2 = data.split("~");
//		String[] temp2 = data.split("[.]"); // .은 RegEx의 문자열 class로 만들어야 구분
		String[] temp2 = data.split("J");
		for(String element : temp2) {
			System.out.println(element);
		}
	}
	
	
	public static void main(String[] args) {
		// 1. 선언) 데이터형[] 배열명 = null;
		UseArray ua = new UseArray();
	}
}
