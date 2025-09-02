import java.io.*;
import java.util.*;


class Person {
	String name;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		Person p = new Person("Noah", 25);
		System.out.println(p);
	}
}
