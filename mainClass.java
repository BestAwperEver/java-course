import java.util.Vector;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class mainClass {
	static { searchResQueue = new LinkedList<SearchResult>(); }
	public static void main1(String[] args) {
		if (args.length != 1) {
			System.exit(1);
		}
		final int[] cost = {440, 125, 15}, count = {60, 10};
		int n = Integer.parseInt(args[0]);
		int[] sum = {0,0,0}, counts = {0,0,0};
		counts[0] = n / count[0];
		n %= count[0];
		counts[1] = n / count[1];
		n %= count[1];
		counts[2] = n;
		if (counts[1] + counts[2] == 0) {
			System.out.println(count[0] * cost[0]);
			
			System.out.println("\nPress enter to continue...");
	        new java.util.Scanner(System.in).nextLine();
			
			System.exit(0);
		} else {
			sum[0] = (counts[0] + 1) * cost[0];
		}
		sum[1] = counts[0] * cost[0] + (counts[2] == 0 ? counts[1] * cost[1] : 
			(counts[1] + 1) * cost[1]);
		sum[2] = counts[0] * cost[0] + counts[1] * cost[1] + counts[2] * cost[2];
        
		if (sum[2] < sum[1] && sum[2] < sum[0]) {
			System.out.printf("For %d: %d%nFor %d: %d%nFor %d: %d", count[0], counts[0], count[1], counts[1], 1, counts[2]);
		} else if (sum[1] < sum[0]) {
			System.out.printf("For %d: %d%nFor %d: %d%nFor %d: %d", count[0], counts[0], count[1], counts[1] + (counts[2] == 0 ? 0 : 1), 1, 0);
		} else {
			System.out.printf("For %d: %d%nFor %d: %d%nFor %d: %d", count[0], counts[0] + 1, count[1], 0, 1, 0);
		}
		
		System.out.println("\nPress enter to continue...");
		java.util.Scanner s = new java.util.Scanner(System.in);
		s.nextLine();
		s.close();
		
        System.exit(0);		
	}
	public static void quadec() {
		int N = 5;
		Vector<QuadEc> v = new Vector<QuadEc>(N);
		Random rand = new Random();
		float min = Float.POSITIVE_INFINITY, max = Float.NEGATIVE_INFINITY;
		for (int i = 0; i < N; ++i) {
			v.add(new QuadEc(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
			Vector<Float> r = v.lastElement().roots();
			if (r != null) {
				for (int j = 0; j < 2; ++j) {
					if (r.get(j) < min) {
						min = r.get(j);
					} else if (r.get(j) > max) {
						max = r.get(j);
					}
				}
			}
		}
		System.out.printf("min = %f, max = %f", min, max);
	}
	public static void students() {
		int N = 20;
		StudentList sl = new StudentList(N);
		Random rand = new Random();
		for (int i = 0; i < N; ++i) {
			Calendar d = Calendar.getInstance();
			d.set(1980 + rand.nextInt(20), rand.nextInt(12) + 1, rand.nextInt(28) + 1);
			int group = 100*rand.nextInt(4) + 100 + rand.nextInt(3);
			int course = group / 100;
			String fac = rand.nextBoolean() ? "mm" : "pm";
			sl.add(i, new Student(i, "ln", "fn", "mn", d, "sadf", "321", fac, course, group));
		}
		StudentList mm = sl.getByFaculty("mm");
		StudentList pm = sl.getByFaculty("pm");
		for (int i = 1; i <= 4; ++i) {
			System.out.println("\nMm " + i + " course:");
			System.out.println(mm.getByCourse(i));
			System.out.println("\nPm " + i + " course:");
			System.out.println(pm.getByCourse(i));
		}
		Calendar b = Calendar.getInstance();
		int year = 1985;
		b.set(year, 1, 1);
		System.out.println("\nBurned after " + year + ":");
		System.out.println(sl.getByBirthAfter(b));
		System.out.println("\nGroup " + sl.firstElement().getGroup() + ":");
		System.out.println(sl.getByGroup(sl.firstElement().getGroup()));
	}
	static Set union(Set s1, Set s2) {
		Set s = new HashSet(s1);
		for (Object o : s2) {
			s.add(o);
		}
		return s;
	}
	static Set intersect(Set s1, Set s2) {
		Set s = new HashSet(s2);
		for (Object o : s2) {
			if (!s1.contains(o)) {
				s.remove(o);
			}
		}
		return s;
	}
	public static void sets() {
		Set s1 = Stream.of(1,2,3,4).collect(Collectors.toCollection(HashSet::new));
		Set s2 = Stream.of(5,2,3,4).collect(Collectors.toCollection(HashSet::new));
		System.out.println(union(s1, s2));
		System.out.println(intersect(s1, s2));
	}
	public static void search(String[] args) {
		if (args.length < 2) return;
		String searchString = args[0];
		String fileName = "c:\\Users\\admin\\workspace\\Test\\src\\";
		for (int i = 1; i < args.length; ++i) {
			String path = fileName + args[i];
			(new Thread(){public void run(){
				try {
					searchInFile(path, searchString);
				} catch (IOException e) {
					e.printStackTrace();
					return;
				}}}).start();			
		}
		(new Thread(){public void run(){resultInConsole();}}).start();
	}
	public static Queue<SearchResult> searchResQueue;
	public static int numberOfThreads = 0;
	public synchronized static void addToQueue(SearchResult sr) {
		searchResQueue.add(sr);
	}
	public static void searchInFile(String file, String s) throws IOException {
		++numberOfThreads;
        BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return;
		}
		String line;
		while ((line = br.readLine()) != null) {
			int i = -1; 
			while ((i = line.indexOf(s, i + 1)) != -1) {
				addToQueue(new SearchResult(file, i));
			}
		}
		br.close();
		--numberOfThreads;
	}
	public static void resultInConsole() {
		while (numberOfThreads > 0 || searchResQueue.isEmpty() == false) {
			if (searchResQueue.isEmpty() == false) {
				System.out.println(searchResQueue.poll());
			}
		}
	}
	public static void main(String[] args) {
		//main1();
		//quadec();
		//students();
		//sets();
		//(new Thread(){public void run() {sets();}}).start();
		//(new Thread(new SwingExample())).start();
		search(args);
	}
}
