package com.magsad.util.employee;

import com.magsad.model.Employee;

import java.util.Scanner;

public class NewEmployee {
    public static Employee getNewEmployee(){
        Employee e = new Employee();
        Scanner sc = new Scanner(System.in);
        System.out.print("id: ");
        e.setId(sc.nextInt());
        System.out.print("name: ");
        e.setName(sc.next());
        System.out.print("surname: ");
        e.setSurname(sc.next());
        System.out.print("email: ");
        e.setEmail(sc.next());
        System.out.print("phone: ");
        e.setPhone(sc.next());
        System.out.print("address: ");
        e.setAddress(sc.next());
//        System.out.print("deptId: ");
//        e.setDeptId(sc.nextInt());
        return e;
    }
}
