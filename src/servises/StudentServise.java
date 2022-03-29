package servises;

import db.IDbExecutor;
import db.MySqlDbExecutor;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class StudentServise {

    private IDbExecutor iDbExecutor;

    public StudentServise(String dbType) {
            switch (dbType.toLowerCase(Locale.ROOT)) {
                case "mysql": {
                    iDbExecutor = new MySqlDbExecutor();
                    break;
                }
            }
    }

    public void printAllStudentsGroupCurator(){
        ResultSet resultSet = iDbExecutor.execute("select s.fio, sg.name, c.fio  from students.student s left join students.group1 sg on s.idGroup = sg.id left join students.curator c on sg.idCurator = c.id");
        try {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("s.fio") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.print(resultSet.getString("c.fio"));
                System.out.println("");
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            iDbExecutor.close();
        }
    }

    public void printCountAllStudents(){
        ResultSet resultSet = iDbExecutor.execute("select count(s.fio) from students.student s");
        try {
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("count(s.fio)"));
                System.out.println("");
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            iDbExecutor.close();
        }

    }


    public void printAllFemaleStudents(){
        ResultSet resultSet = iDbExecutor.execute("select id, fio, sex, idGroup from student s where s.sex = 1");
        try {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("id") + " ");
                System.out.print(resultSet.getString("fio") + " ");
                System.out.print(resultSet.getString("sex") + " ");
                System.out.print(resultSet.getString("idGroup"));
                System.out.println("");
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            iDbExecutor.close();
        }

    }

    public void updateCurator(int idGroup, int newCuratorId){
        String query = String.format("update students.group1 set idCurator = %d where id = %d", newCuratorId, idGroup);

        iDbExecutor.executeUpdate(query);
        iDbExecutor.close();
    }
}
