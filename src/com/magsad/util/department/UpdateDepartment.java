package com.magsad.util.department;
import com.magsad.model.Department;

import java.util.Scanner;

public class UpdateDepartment {
    public static Department updateDepartment(Department dep) {
        do {
            System.out.println(" 1.Name 2.Surname 3.Email 4.Phone 5.Address 6.DeptId 0.Exit");
            System.out.print("Enter update/select: ");
            Scanner sc = new Scanner(System.in);
            int select = sc.nextInt();

            if (select == 3) {
                System.out.print("deptId: ");
//                e.setDeptId(sc.nextInt());
            }

            if (select == 2) {
                System.out.print("phone: ");
                dep.setPhone(sc.next());
            }
            
            if (select == 1) {
                System.out.print("name: ");
                dep.setName(sc.next());
            }
            if (select == 0) {
                return dep;
//                System.exit(0);
            }
        } while (true);

    }
}
