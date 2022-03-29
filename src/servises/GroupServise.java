package servises;

import db.IDbExecutor;
import db.MySqlDbExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class GroupServise {

    private IDbExecutor iDbExecutor;

    public GroupServise(String dbType) {
        switch (dbType.toLowerCase(Locale.ROOT)) {
            case "mysql": {
                iDbExecutor = new MySqlDbExecutor();
                break;
            }
        }
    }

    public void printGroupAndCurator(){

        ResultSet resultSet = iDbExecutor.execute("select distinct sg.name, c.fio from students.group1 sg left join students.curator c on sg.idCurator = c.id");
        try {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("name") + " ");
                System.out.print(resultSet.getString("fio"));
                System.out.println("");
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            iDbExecutor.close();
        }

    }

    public void findStudentGroup(String nameGroup){

        String query = String.format("select s.fio from students.student s where s.idGroup in(select id from students.group1 sg where sg.name = %s)", nameGroup);

        ResultSet resultSet = iDbExecutor.execute(query);
        try {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("fio"));
                System.out.println("");
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            iDbExecutor.close();
        }

    }

}
