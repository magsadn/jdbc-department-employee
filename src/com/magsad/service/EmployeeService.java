package com.magsad.service;

import com.magsad.model.Employee;
import com.magsad.util.employee.NewEmployee;
import com.magsad.util.employee.UpdateEmployee;
import com.magsad.repository.DepartmentRepository;
import com.magsad.repository.EmployeeRepository;

import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    private static EmployeeRepository employeeRepository = new EmployeeRepository();
    private static DepartmentRepository departmentRepository = new DepartmentRepository();

    public void getEmployee(){
        do {
            System.out.println("\n1.New 2.FindAll 3.FindById 4.Delete 5.Update 0.Exit");
            System.out.print("Enter com.magsad.Main/Employee select: ");
            int select = new Scanner(System.in).nextInt();
            if (select == 5){
                update();
            }if (select == 4){
                delete();
            }if (select == 3){
                findById();
            }if (select ==2 ){
                findAll();
            }if (select == 1){
                save();
            }if (select == 0){
                break;
//                System.exit(0);
            }
        }while (true);
    }

    private static void findAll(){
        List<Employee> employeeList = employeeRepository.findAll();
        employeeList.stream().forEach(e -> System.out.print(getPrint(e)));
    }

    private static void findById(){
        System.out.print("Enter employee id: ");
        int id = new Scanner(System.in).nextInt();
        Employee e = employeeRepository.findById(id);
        System.out.println(getPrint(e));
    }

    private static void save (){
        Employee e = NewEmployee.getNewEmployee();
        System.out.print("deptId: ");
        e.setDepartment(departmentRepository.findById(new Scanner(System.in).nextInt()));
        System.out.println(employeeRepository.save(e));
    }

    private static void update() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee id: ");
        int id = sc.nextInt();
        Employee e = employeeRepository.findById(id);
        System.out.println(getPrint(e));
        UpdateEmployee.updateEmployee(e);

        System.out.println(employeeRepository.update(e));
    }

    private static void delete(){
        System.out.print("Enter employee id: ");
        int id = new Scanner(System.in).nextInt();
        Employee e = employeeRepository.findById(id);
        employeeRepository.delete(e);
    }

    private static String getPrint(Employee e){
        return String.format("%4d | %10s | %15s | %25s | %20s | %20s | %5d\n",
                e.getId(),
                e.getName(),
                e.getSurname(),
                e.getEmail(),
                e.getPhone(),
                e.getAddress(),
                e.getDepartment().getId()
        );
    }
}
