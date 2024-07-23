package generic_004_wildcard;

import java.util.Arrays;  //ctrl + shift + o

public class WildCardExample {
//										    <?> 전체의, 모든 메소드, 클래스 선언 할때는 타입변수를 꼭 넣어야한다. 
//	 											자료형위치에는 타입변수를 넣을 수 없기때문에, 대체로 나온 것
	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
	}
		public static void registerCourseStudents(Course<? extends Student> course) {
			System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
	}
		public static void registerCourseWorker(Course<? super Worker> course) {
			System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
	}
		
	public static void main(String[] args) {
		Course<Person> personCourse = new Course<Person>("일반인과정", 5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));
		registerCourse(personCourse);
		
		Course<Worker> workerCourse = new Course<Worker>("직장인과정", 5);
		workerCourse.add(new Worker("직장인"));
		registerCourse(workerCourse);
		
		Course<Student> studentCourse = new Course<Student>("학생과정", 5);
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("고등학생"));
		registerCourse(studentCourse);
		
		Course<HighStudent> highStudentCourse = new Course<HighStudent>("고등학생과정", 5);
		highStudentCourse.add(new HighStudent("고등학생"));
		registerCourse(highStudentCourse);
		System.out.println();

		//registerCourseStudents(personCourse);
		//registerCourseStudents(workerCourse);
		registerCourseStudents(studentCourse);
		registerCourseStudents(highStudentCourse);
		System.out.println();
		
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
		//registerCourseStudent(studentCourse);
		//registerCourseStudent(highStudentCourse);
	}

}
