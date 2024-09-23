package vo;

public class CourseVO {
	
	private String subjectStartTime;
	private String subjectEndTime;
	private int courseMaxPeople;
	private String studentId;
	private String courseId;
	private String subjectId;
	private String subjectName;
	private String subjectSemester;
	private int subjectCredit;
	private String subjectTime;
	private String subjectDay;
	private String professorId;
	private String subjectRoom;
	private int subjectMax;
	private String courseStatus;
	private int courseGrade;
	private int registerPeople;

	public int getRegisterPeople() {
		return registerPeople;
	}

	public void setRegisterPeople(int registerPeople) {
		this.registerPeople = registerPeople;
	}

	public int getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(int courseGrade) {
		this.courseGrade = courseGrade;
	}

	public String getSubjectStartTime() {
		return subjectStartTime;
	}

	public void setSubjectStartTime(String subjectFirstTime) {
		this.subjectStartTime = subjectFirstTime;
	}

	public String getSubjectEndTime() {
		return subjectEndTime;
	}

	public void setSubjectEndTime(String subjectLastTime) {
		this.subjectEndTime = subjectLastTime;
	}

	public int getCourseMaxPeople() {
		return courseMaxPeople;
	}

	public void setCourseMaxPeople(int courseMaxPeople) {
		this.courseMaxPeople = courseMaxPeople;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	private int maxCount;

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectSemester() {
		return subjectSemester;
	}

	public void setSubjectSemester(String subjectSemester) {
		this.subjectSemester = subjectSemester;
	}

	public int getSubjectCredit() {
		return subjectCredit;
	}

	public void setSubjectCredit(int subjectCredit) {
		this.subjectCredit = subjectCredit;
	}

	public String getSubjectTime() {
		return subjectTime;
	}

	public void setSubjectTime(String subjectTime) {
		this.subjectTime = subjectTime;
	}

	public String getSubjectDay() {
		return subjectDay;
	}

	public void setSubjectDay(String subjectDay) {
		this.subjectDay = subjectDay;
	}

	public String getProfessorId() {
		return professorId;
	}

	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	public String getSubjectRoom() {
		return subjectRoom;
	}

	public void setSubjectRoom(String subjectRoom) {
		this.subjectRoom = subjectRoom;
	}

	public int getSubjectMax() {
		return subjectMax;
	}

	public void setSubjectMax(int subjectMax) {
		this.subjectMax = subjectMax;
	}

}
