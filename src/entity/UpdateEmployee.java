package entity;

import java.util.Scanner;

public class UpdateEmployee {
    public static Employee updateEmployee(Employee e) {
        do {
            System.out.println(" 1.Name 2.Surname 3.Email 4.Phone 5.Address 6.DeptId 0.Exit");
            System.out.print("Enter update/select: ");
            Scanner sc = new Scanner(System.in);
            int select = sc.nextInt();

            if (select == 6) {
                System.out.print("deptId: ");
                e.setDeptId(sc.nextInt());
            }
            if (select == 5) {
                System.out.print("address: ");
                e.setAddress(sc.next());
            }
            if (select == 4) {
                System.out.print("phone: ");
                e.setPhone(sc.next());
            }
            if (select == 3) {
                System.out.print("email: ");
                e.setEmail(sc.next());
            }
            if (select == 2) {
                System.out.print("surname: ");
                e.setSurname(sc.next());
            }
            if (select == 1) {
                System.out.print("name: ");
                e.setName(sc.next());
            }
            if (select == 0) {
                return e;
//                System.exit(0);
            }
        } while (true);

    }
}
