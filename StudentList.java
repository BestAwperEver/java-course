import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class StudentList extends Vector<Student> {

	private static final long serialVersionUID = 1L;

	public StudentList() {
		// TODO Auto-generated constructor stub
	}

	public StudentList(int initialCapacity) {
		super(initialCapacity);
		// TODO Auto-generated constructor stub
	}

	public StudentList(Collection<? extends Student> c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	public StudentList(int initialCapacity, int capacityIncrement) {
		super(initialCapacity, capacityIncrement);
		// TODO Auto-generated constructor stub
	}
	
	public StudentList getByFaculty(String f) {
		StudentList sl = new StudentList();
		for (Student s : this) {
			if (s.getFaculty() == f) {
				sl.add(s);
			}
		}
		return sl;
	}
	
	public StudentList getByCourse(int c) {
		StudentList sl = new StudentList();
//		for (Student s : this) {
//			if (s.getCourse() == c) {
//				sl.add(s);
//			}
//		}
		for (Iterator<Student> i = this.iterator(); i.hasNext(); ) {
			Student s = i.next();
			if (s.getCourse() == c) {
				sl.add(s);
			}
		}
		return sl;
	}
	
	public StudentList getByBirthAfter(Calendar date) {
		StudentList sl = new StudentList();
		for (Student s : this) {
			if (s.getBirthDate().after(date)) {
				sl.add(s);
			}
		}
		return sl;
	}
	
	public StudentList getByGroup(int c) {
		StudentList sl = new StudentList();
		for (Student s : this) {
			if (s.getGroup() == c) {
				sl.add(s);
			}
		}
		return sl;
	}
}
