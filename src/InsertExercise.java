
public class InsertExercise {

	public static void main(String[] args) {
		DepartmentDao dao =new DepartmentDao();
		
		Department department = new Department();
		department.setDepId(10);
		department.setDepName("�Ǘ���");
		
		dao.insert(department);
		
		department=dao.load(10);
		
		System.out.println("id="+department.getDepId());
		System.out.println("name="+department.getDepName());
		
		

	}

}
