package src.backend;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class EmployeeTable_ManagerTable {
    private static String userName;
    private static Connection connection;
    private PreparedStatement pStatement;


    public void createConnection() {
        try {
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3307/GuiDataBaseA2", "root", "abelasnake@2abelasnake@2");

            Statement statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void closeConnection() {
        try {
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean searchManager(String userName, String password) {
        try {
            pStatement = connection.prepareStatement("SELECT user_name, password FROM Manager WHERE user_name = ? AND password = ?");
            pStatement.setString(1, userName);
            pStatement.setString(2, password);
            ResultSet resultSet = pStatement.executeQuery();

            if(!resultSet.next()) {
                return false;
            }
            else {
                EmployeeTable_ManagerTable.userName = userName;
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean searchManagerUserName(String userName) {
        try {
            pStatement = connection.prepareStatement("SELECT user_name FROM Manager WHERE user_name = ?");
            pStatement.setString(1, userName);
            ResultSet resultSet = pStatement.executeQuery();

            if(!resultSet.next()) {
                return false;
            }
            else {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
    public int getCurrentManagerId() {
        int i = -1;

        if(!Objects.equals(EmployeeTable_ManagerTable.userName, "")) {
            try {
                pStatement = connection.prepareStatement("select mid from Manager where user_name = ?");
                pStatement.setString(1, EmployeeTable_ManagerTable.userName);
                ResultSet resultSet = pStatement.executeQuery();

                if(resultSet.next()) {
                    i = resultSet.getInt("mid");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return i;
    }
    public void setUserName(String userName) {
        EmployeeTable_ManagerTable.userName = userName;
    }
    public void createManager(String userName, char[] password) {
        String passwordStr = "";

        for(int i = 0; i < password.length; i++) {
            passwordStr += String.valueOf(password[i]);
        }

        try {
            pStatement = connection.prepareStatement("insert into manager values (default, ?, ?)");
            pStatement.setString(1, userName);
            pStatement.setString(2, passwordStr);
            pStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createEmployee(
            String first_name, String last_name, String sex, String skill,
            String skill_type, String school, String school_address, int skill_level, int mid) {

        int uniqueId = getOnlyUniqueId() + 1;
        try {
            pStatement = connection.prepareStatement("insert into employee values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pStatement.setString(1, first_name);
            pStatement.setString(2, last_name);
            pStatement.setString(3, sex);
            pStatement.setString(4, skill);
            pStatement.setString(5, skill_type);
            pStatement.setString(6, school);
            pStatement.setString(7, school_address);
            pStatement.setInt(8, skill_level);
            pStatement.setInt(9, mid);
            pStatement.setInt(10, uniqueId);
            pStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getOnlyUniqueId() { // returns the last unique id of the employee
        int eid = 0;

        try {
            pStatement = connection.prepareStatement("select eid from Employee order by eid DESC Limit 1");
            ResultSet resultSet = pStatement.executeQuery();

            if(resultSet.next()) {
                eid = resultSet.getInt("eid");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return (eid + 1000);
    }
    public boolean canDeleteManager(String eid, String firstName, String lastName, boolean m, boolean f, boolean onlyId) {
        boolean midEqual = false;
        boolean fNameEqu = false;
        boolean lNameEqu = false;
        boolean genderValid = false;

        try { // mid
            pStatement = connection.prepareStatement("select mid from Employee where unique_id = ?");
            pStatement.setString(1, eid);
            ResultSet resultSet = pStatement.executeQuery();

            if(resultSet.next()) {
                String x = resultSet.getString("mid");
                String y = String.valueOf(getCurrentManagerId());
                midEqual = Objects.equals(x, y);

                if(onlyId && midEqual) {
                    return true;
                }
                else if(onlyId && !midEqual) {
                    return false;
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        try { // first name
            pStatement = connection.prepareStatement("select first_name from Employee where unique_id = ?");
            pStatement.setString(1, eid);
            ResultSet resultSet = pStatement.executeQuery();

            if(resultSet.next()) {
                String x = resultSet.getString("first_name");
                fNameEqu = Objects.equals(x, firstName);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


        try { // last name
            pStatement = connection.prepareStatement("select last_name from Employee where unique_id = ?");
            pStatement.setString(1, eid);
            ResultSet resultSet = pStatement.executeQuery();

            if (resultSet.next()) {
                String x = resultSet.getString("last_name");
                lNameEqu = Objects.equals(x, lastName);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        try { // gender
            pStatement = connection.prepareStatement("select sex from Employee where unique_id = ?");
            pStatement.setString(1, eid);
            ResultSet resultSet = pStatement.executeQuery();

            String gender;
            if(m) {
                gender = "Male";
            }
            else if(f) {
                gender = "Female";
            }
            else {
                gender = "none";
            }
            if (resultSet.next()) {
                String x = resultSet.getString("sex");
                genderValid = Objects.equals(x, gender);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        if(genderValid && fNameEqu && lNameEqu && midEqual) {
            return true;
        }
        else {
            return false;
        }
    }
    public void deleteEmployee(int eid) {
        try {
            pStatement = connection.prepareStatement("delete from employee where unique_id = ?");
            pStatement.setInt(1, eid);
            pStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String[] writeArray() {
        String[] arrayAllEmp = new String[0];

        try { // get all id and first name and last name
            pStatement = connection.prepareStatement("select unique_id, first_name, last_name from Employee");
            ResultSet resultSet = pStatement.executeQuery();

            ArrayList<String> myList = new ArrayList<>();
            while(resultSet.next()) {
                int unique_id = resultSet.getInt("unique_id");
                String casted_unique_id = String.valueOf(unique_id);
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");

                String listAdded = "id: " + casted_unique_id + " Name: " + first_name + " " + last_name;

                myList.add(listAdded);
            }
            String[] array = new String[myList.size()];
            int i = 0;
            for(String each : myList) {
                array[i] = each;
                ++i;
            }

            arrayAllEmp = array;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return arrayAllEmp;
    }
    public String[] getAllInfoEmp(int unique_id) {
        String[] allInfo = new String[8];
        try {
            pStatement = connection.prepareStatement("select first_name, last_name, sex, skill_level, " +
                    "skill_type, school, skill, school_address from Employee where unique_id = ?");
            pStatement.setInt(1, unique_id);
            ResultSet resultSet = pStatement.executeQuery();

            if(resultSet.next()) {
                allInfo[0] = resultSet.getString("first_name");
                allInfo[1] = resultSet.getString("last_name");
                allInfo[2] = resultSet.getString("sex");
                allInfo[3] = String.valueOf(resultSet.getInt("skill_level"));
                allInfo[4] = resultSet.getString("skill_type");
                allInfo[5] = resultSet.getString("school");
                allInfo[6] = resultSet.getString("skill");
                allInfo[7] = resultSet.getString("school_address");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return allInfo;
    }
    public void updateEmployee(String[] modify, int unique_id) {
        for(int i = 0; i < 8; i++) {
            System.out.println(modify[i] + "   ");
        }
        try {
            pStatement = connection.prepareStatement("UPDATE Employee SET first_name = ?, last_name = ?, sex = ?, " +
                    "skill_level = ?, skill_type = ?, school = ?, skill = ?, school_address = ? WHERE unique_id = ?");
            pStatement.setString(1, modify[0]);
            pStatement.setString(2, modify[1]);
            pStatement.setString(3, modify[2]);
            pStatement.setString(4, modify[3]);
            pStatement.setString(5, modify[4]);
            pStatement.setString(6, modify[5]);
            pStatement.setString(7, modify[6]);
            pStatement.setString(8, modify[7]);
            pStatement.setInt(9, unique_id);
            pStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}