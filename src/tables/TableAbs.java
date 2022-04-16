package tables;
import db.IDbExecutor;
import db.MySqlDbExecutor;
import dbo.Student;
import java.util.List;
import java.util.Locale;

public abstract class TableAbs<T> implements ITable<T> {

    protected IDbExecutor dbExecutor = null;

    public TableAbs(String dbType) {
        switch (dbType.toLowerCase(Locale.ROOT)) {
            case "mysql": {
                dbExecutor = new MySqlDbExecutor();
                break;
            }
        }
    }
}