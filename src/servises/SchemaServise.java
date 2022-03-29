package servises;

import db.IDbExecutor;
import db.MySqlDbExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class SchemaServise {

    private IDbExecutor iDbExecutor;

    public SchemaServise(String dbType) {
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

        String sqlCommand2 = "CREATE TABLE IF NOT EXISTS group1 (" +
                "Id INT PRIMARY KEY AUTO_INCREMENT," +
                "Name VARCHAR(45)," +
                "IdCurator INT)";

        String sqlCommand3 = "CREATE TABLE IF NOT EXISTS curator (" +
                "Id INT PRIMARY KEY AUTO_INCREMENT," +
                "Fio VARCHAR(45))";



        iDbExecutor.executeUpdate(sqlCommand);
        iDbExecutor.executeUpdate(sqlCommand2);
        iDbExecutor.executeUpdate(sqlCommand3);

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




        String queryGroup = ("INSERT INTO group1(Name, IdCurator) VALUES " +
                "('Первая группа', 1)," +
                "('Вторая группа', 2)," +
                "('Третья группа', 3)");






        String queryCurator = ("INSERT INTO curator(Fio) VALUES " +
                "('Иванов Иван Иванович')," +
                "('Петров Петр Петрович')," +
                "('Сегреев Сергей Сергеевич')," +
                "('Федоров Федор Федорович')");

        iDbExecutor.executeUpdate(queryStudent);
        iDbExecutor.executeUpdate(queryGroup);
        iDbExecutor.executeUpdate(queryCurator);

        iDbExecutor.close();


    }


}
