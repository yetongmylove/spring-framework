package org.springframework.hshp;

/**
 * @ClassName Student
 * @Description TODO
 * @Author HX0011049
 * @Date 2019/11/25 11:37
 */
public class Student {

	private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
}
