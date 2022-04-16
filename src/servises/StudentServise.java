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

    public void createSchema(){

        String sqlCommand = "CREATE TABLE IF NOT EXISTS student (" +
                "Id INT PRIMARY KEY AUTO_INCREMENT," +
                "Fio VARCHAR(45)," +
                "Sex INT," +
                "IdGroup INT)";

        iDbExecutor.executeUpdate(sqlCommand);
        iDbExecutor.close();
    }

    public void fillSchema(){
        String queryStudent = ("INSERT INTO student(Fio, Sex, IdGroup) VALUES " +
                "('Пушкин Александр Сергеевич', 0, 1)," +
                "('Есенин Сергей Александрович', 0, 1)," +
                "('Маяковский Владимир Владимирович', 0, 1)," +
                "('Бунин Иван Алексеевич', 0, 2)," +
                "('Гиппиус Зинаида Николаевна', 1, 2)," +
                "('Тютчев Федор Иванович', 0, 2)," +
                "('Ахмадулина Белла Ахатовна', 1, 2)," +
                "('Гоголь Николай Васильевич', 0, 2)," +
                "('Асадов Эдуард Аркадьевич', 0, 3)," +
                "('Толстой Алексей Константинович', 0, 3)," +
                "('Ахматова Анна Андреевна', 1, 3)," +
                "('Цветаева Марина Ивановна', 1, 3)," +
                "('Грибоедов Александр Сергеевич', 0, 3)," +
                "('Лермонтов Михаил Юрьевич', 0, 3)," +
                "('Тургенев Иван Сергеевич', 0, 3)");

        iDbExecutor.executeUpdate(queryStudent);
        iDbExecutor.close();
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
