
public class UpdateExercise {

	public static void main(String[] args) {
		DepartmentDao dao = new DepartmentDao();
		Department department =dao.load(1);
		
		System.out.println("----変更前----");
		System.out.println("dep_id="+department.getDepId());
		System.out.println("dep_name="+department.getDepName());
		
		department.setDepName("営業管理");
		dao.update(department);
		
		department=dao.load(1);
		System.out.println("----変更後----");
		System.out.println("dep_id="+department.getDepId());
		System.out.println("dep_name="+department.getDepName());
		
		
		
		
		

	}

}
