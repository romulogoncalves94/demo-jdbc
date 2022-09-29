package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE 1: department insert ===");
		Department newDepartment = new Department(null, "Ifood");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== TESTE 2: department findById ===");
		Department department = departmentDao.findById(7);
		System.out.println(department);
		
		System.out.println("\n=== TESTE 3: department update ===");
		department = departmentDao.findById(7);
		department.setName("Tonhao das Neves");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TESTE 4: department deleteById ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		System.out.println("\n=== TESTE 5: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for(Department dep : list) {
			System.out.println(dep);
		}
		
		sc.close();
	}
}
