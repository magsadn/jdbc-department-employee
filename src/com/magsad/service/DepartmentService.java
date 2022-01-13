package com.magsad.service;

import com.magsad.model.Department;
import com.magsad.util.department.NewDepartment;
import com.magsad.util.department.UpdateDepartment;
import com.magsad.repository.DepartmentRepository;

import java.util.List;
import java.util.Scanner;

public class DepartmentService {
    private static DepartmentRepository departmentRepository = new DepartmentRepository();
        public void getDepartment() {
        do {
            System.out.println("\n1.New 2.FindAll 3.FindById 4.Delete 5.Update 0.Exit");
            System.out.print("Enter com.magsad.Main/Department select: ");
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
        List<Department> departmentList = departmentRepository.findAll();
        departmentList.stream().forEach(e -> System.out.print(getPrint(e)));
    }

    private static void findById(){
        System.out.print("Enter employee id: ");
        int id = new Scanner(System.in).nextInt();
        Department d = departmentRepository.findById(id);
        System.out.println(getPrint(d));
    }

    private static void save (){
        Department d = NewDepartment.getNewDepartment();
        System.out.println(departmentRepository.save(d));
    }

    private static void update() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter department id: ");
        int id = sc.nextInt();
        Department d = departmentRepository.findById(id);
        System.out.println(getPrint(d));
        UpdateDepartment.updateDepartment(d);
        System.out.println(departmentRepository.update(d));
    }

    private static void delete(){
        System.out.print("Enter employee id: ");
        int id = new Scanner(System.in).nextInt();
        Department d = departmentRepository.findById(id);
        departmentRepository.delete(d);
    }

    private static String getPrint(Department d){
        return String.format("%4d | %10s | %20s\n",
                d.getId(),
                d.getName(),
                d.getPhone()
        );
    }

}
