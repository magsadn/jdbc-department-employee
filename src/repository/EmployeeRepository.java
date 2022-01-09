package repository;

import config.DBConnection;
import entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private DBConnection dbConnection = new DBConnection();

    public List<Employee> findAll(){
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = dbConnection.getConnection()){
            String sqlQuerySelectAll = "select * from employees order by id";
            PreparedStatement psSelectAll = connection.prepareStatement(sqlQuerySelectAll);
            ResultSet resultSet = psSelectAll.executeQuery();
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
                employeeList.add(e);
                //1:34:11
                //System.out.println(e);
            }
        }catch (SQLException throwables){
            throwables.getMessage();
        }
        return employeeList;
    }

    public Employee findById(int id) {
        Employee employee = new Employee();
        try (Connection connection = dbConnection.getConnection()) {
            String sqlQuerySelectById = "select * from employees where id = ?";
            PreparedStatement psSelectById = connection.prepareStatement(sqlQuerySelectById);
            psSelectById.setInt(1,id);
            ResultSet resultSet = psSelectById.executeQuery();
            System.out.println("resultSet" + resultSet.toString());
            if (resultSet.next()){
                return new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("address"),
                        resultSet.getInt("dept_id")
                );
            }
        } catch (SQLException throwables) {
            throwables.getMessage();
        }
        return null;
    }

    public int save(Employee emp) {
        int queryResult = 0;
        try (Connection connection = dbConnection.getConnection()) {
            String sqlQueryInsert = "insert into employees values (?,?,?,?,?,?,?)";
            PreparedStatement psInsert = connection.prepareStatement(sqlQueryInsert);
            psInsert.setInt(1, emp.getId());
            psInsert.setString(2, emp.getName());
            psInsert.setString(3, emp.getSurname());
            psInsert.setString(4, emp.getEmail());
            psInsert.setString(5, emp.getPhone());
            psInsert.setString(6, emp.getAddress());
            psInsert.setInt(7, emp.getDeptId());

            queryResult = psInsert.executeUpdate();
            System.out.println(queryResult);
            if (queryResult != 0) {
                System.out.println("Inserted!");
            }

        } catch (SQLException throwables) {
            throwables.getMessage();
        }
        return queryResult;
    }

    public int update(Employee emp) {
        int queryResult = 0;
        try (Connection connection = dbConnection.getConnection()) {
            String sqlQueryUpdate = "update employees set name=?,surname=?,email=?,phone=?,address=?,dept_id=? where id=?";
            PreparedStatement psUpdate = connection.prepareStatement(sqlQueryUpdate);
            psUpdate.setString(1, emp.getName());
            psUpdate.setString(2, emp.getSurname());
            psUpdate.setString(3, emp.getEmail());
            psUpdate.setString(4, emp.getPhone());
            psUpdate.setString(5, emp.getAddress());
            psUpdate.setInt(6, emp.getDeptId());
            psUpdate.setInt(7, emp.getId());

            queryResult = psUpdate.executeUpdate();
            System.out.println(queryResult);
            if (queryResult != 0) {
                System.out.format("Id %d employee was Updated!\n",emp.getId());
            }

        } catch (SQLException throwables) {
            throwables.getMessage();
        }
        return queryResult;
    }

    public int delete(Employee emp) {
        int queryResult = 0;
        try (Connection connection = dbConnection.getConnection()) {
            String sqlQueryDelete = "delete from employees where id=?";
            PreparedStatement psDelete = connection.prepareStatement(sqlQueryDelete);
            psDelete.setInt(1, emp.getId());//1ci ? isaresinin evezine yazilir.2ci sual isaresi yoxdur.
            queryResult = psDelete.executeUpdate();
            System.out.println(queryResult);
            if (queryResult != 0) {
                System.out.println("Deleted!");
            }
        } catch (SQLException throwables) {
            throwables.getMessage();
        }
        return queryResult;
    }
}
