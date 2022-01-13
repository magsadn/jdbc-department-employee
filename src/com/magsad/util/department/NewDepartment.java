package com.magsad.util.department;
import com.magsad.model.Department;

import java.util.Scanner;

public class NewDepartment {
    public static Department getNewDepartment(){
        Department d = new Department();
        Scanner sc = new Scanner(System.in);
        System.out.print("id: ");
        d.setId(sc.nextInt());
        System.out.print("name: ");
        d.setName(sc.next());
        System.out.print("phone: ");
        d.setPhone(sc.next());
        return d;
    }
}
