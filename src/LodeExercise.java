
public class LodeExercise {

	public static void main(String[] args) {
		DepartmentDao dao = new DepartmentDao();
		Department department =dao.load(1);
		
		System.out.println("dep_id="+ department.getDepId());
		System.out.println("dep_name="+department.getDepName());
		
		

	}

}
