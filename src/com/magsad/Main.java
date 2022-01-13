package com.magsad;

import com.magsad.repository.DepartmentRepository;
import com.magsad.service.DepartmentService;
import com.magsad.service.EmployeeService;

import java.util.Scanner;

public class Main {
    private static final EmployeeService employeeService = new EmployeeService();
    private static final DepartmentService departmentService = new DepartmentService();
    private static DepartmentRepository departmentRepository = new DepartmentRepository();

    public static void main(String[] args) {

        do {
           System.out.println("\n1.Department 2.Employee 0.Exit");
           System.out.print("Enter com.magsad.Main/select: ");
           int select = new Scanner(System.in).nextInt();
           if (select == 2){
               System.out.println("\n--Employee Section--");
               employeeService.getEmployee();
           }if (select == 1){
               //Department
               System.out.println("\n--Department section--");
               departmentService.getDepartment();
           }if (select == 0){
               break;
           }else {
                System.out.println("\n:::.!!!Invalid select!!!.:::");
            }

        } while (true);
    }








}
