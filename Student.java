import java.util.Calendar;

public class Student {
	int id;
	String lastName;
	String firstName;
	String middleName;
	Calendar birthDate;
	String adress;
	String phoneNumber;
	String faculty;
	int course;
	int group;
	public Student(int id, String lastName, String firstName, String middleName, Calendar birthDate, String adress,
			String phoneNumber, String faculty, int course, int group) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.birthDate = birthDate;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.faculty = faculty;
		this.course = course;
		this.group = group;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public Calendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public int getCourse() {
		return course;
	}
	public void setCourse(int course) {
		this.course = course;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	@Override
	public String toString() {
		return "Student [id=" + id
				+ "\nbirthYear="+ birthDate.get(Calendar.YEAR)
				+ "\nbirthMonth=" + birthDate.get(Calendar.MONTH)
				+ "\nbirthDay=" + birthDate.get(Calendar.DAY_OF_MONTH) 
				+ "\nfaculty=" + faculty + ", course=" + course + ", group=" + group + "]";
	}
}
