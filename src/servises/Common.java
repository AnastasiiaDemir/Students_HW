package servises;
import db.IDbExecutor;
import db.MySqlDbExecutor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class Common {

    private IDbExecutor iDbExecutor;

    public Common(String dbType) {
        switch (dbType.toLowerCase(Locale.ROOT)) {
            case "mysql": {
                iDbExecutor = new MySqlDbExecutor();
                break;
            }
        }
    }
    public void printCountAllRecords(String tableName) {
        ResultSet resultSet = iDbExecutor.execute("select count(t.id) from students." +tableName +" t");
        try {
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("count(t.id)"));
                System.out.println("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            iDbExecutor.close();
        }
    }
}