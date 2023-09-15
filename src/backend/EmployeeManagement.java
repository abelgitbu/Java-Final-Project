package src.backend;

public class EmployeeManagement {
    int managerId;
    public boolean checkLogin(String userName, char[] password) {
        boolean cont = false;
        String passwordStr = "";

        for(int i = 0; i < password.length; i++) {
            passwordStr += String.valueOf(password[i]);
        }

        EmployeeTable_ManagerTable dB = new EmployeeTable_ManagerTable();
        dB.createConnection();
        cont = dB.searchManager(userName, passwordStr);
        dB.closeConnection();

        return cont;
    }
}