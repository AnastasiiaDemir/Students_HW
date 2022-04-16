package servises;
import db.IDbExecutor;
import db.MySqlDbExecutor;
import java.util.Locale;

public class CuratorServise {
    private IDbExecutor iDbExecutor;

    public CuratorServise(String dbType) {
        switch (dbType.toLowerCase(Locale.ROOT)) {
            case "mysql": {
                iDbExecutor = new MySqlDbExecutor();
                break;
            }
        }
    }

    public void createSchema(){
        String sqlCommand = "CREATE TABLE IF NOT EXISTS curator (" +
                "Id INT PRIMARY KEY AUTO_INCREMENT," +
                "Fio VARCHAR(45))";
        iDbExecutor.executeUpdate(sqlCommand);
        iDbExecutor.close();
    }

    public void fillSchema(){
        String queryCurator = ("INSERT INTO curator(Fio) VALUES " +
                "('Иванов Иван Иванович')," +
                "('Петров Петр Петрович')," +
                "('Сегреев Сергей Сергеевич')," +
                "('Федоров Федор Федорович')");
        iDbExecutor.executeUpdate(queryCurator);
        iDbExecutor.close();
    }
}


