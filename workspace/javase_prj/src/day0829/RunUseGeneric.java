package day0829;

import java.util.Iterator;

import day0821.StudentScoreDTO;

public class RunUseGeneric {
	
	public RunUseGeneric() {
		UseGeneric<String> ug = new UseGeneric<String>();
		ug.set("안녕하세요");
		System.out.println(ug.get());
		
		UseGeneric<Integer> ug2 = new UseGeneric<Integer>();
		ug2.set(2025);
		ug2.set(Integer.valueOf(2025));
		int i = ug2.get();
		System.out.println(ug2.get());
		
		UseGeneric<StudentScoreDTO> ug3 = new UseGeneric<StudentScoreDTO>();
		ug3.set(new StudentScoreDTO(1, "루피", 50, 52, 54));
		ug3.set(new StudentScoreDTO(2, "쵸파", 90, 98, 96));
		
		StudentScoreDTO ssDTO = ug3.get();
		System.out.println(ssDTO.getNum() + ", " + ssDTO.getName());
		
		
	}
	
	public static void main(String[] args) {
		new RunUseGeneric();
	}
}
