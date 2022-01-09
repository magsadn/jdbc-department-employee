import entity.Employee;

import java.sql.*;
import java.util.Scanner;


public class DBConnection {
    public static void main(String[] args) {
        Connection connection = null;

        String url  = "jdbc:postgresql://localhost:5432/repeat-lessons";
        String user = "postgres";
        String password = "";
        System.out.println("Connecting ...");
        try {
//            Ehiyac yoxdur buna:
//            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println(connection);
            System.out.println("Connected!");

            Employee emp = getNewEmployee();

            String sqlQueryInsert = "insert into employees values (?,?,?,?,?,?,?)";
            PreparedStatement psInsert = connection.prepareStatement(sqlQueryInsert);
            psInsert.setInt(1,emp.getId());
            psInsert.setString(2,emp.getName());
            psInsert.setString(3,emp.getSurname());
            psInsert.setString(4,emp.getEmail());
            psInsert.setString(5,emp.getPhone());
            psInsert.setString(6,emp.getAddress());
            psInsert.setInt(7,emp.getDeptId());

            int queryResult = psInsert.executeUpdate();
            System.out.println(queryResult);
            if (queryResult != 0){
                System.out.println("Inserted!");
            }

            String sqlQuerySelect = "select * from employees";
            PreparedStatement ps = connection.prepareStatement(sqlQuerySelect);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Employee e = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("address"),
                        resultSet.getInt("dept_id")
                );
                System.out.println(e);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        } finally {
            try {
                if (connection != null){
                    connection.close();
                    System.out.println("Connection closed!");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println(throwables.getMessage());
            }
        }
    }

    static Employee getNewEmployee(){
        Employee e = new Employee();
        Scanner sc = new Scanner(System.in);
        System.out.println("id: ");
        e.setId(sc.nextInt());
        System.out.println("name: ");
        e.setName(sc.next());
        System.out.println("surname: ");
        e.setSurname(sc.next());
        System.out.println("email: ");
        e.setEmail(sc.next());
        System.out.println("phone: ");
        e.setPhone(sc.next());
        System.out.println("address: ");
        e.setAddress(sc.next());
        System.out.println("deptId: ");
        e.setDeptId(sc.nextInt());
        return e;
    }
}
