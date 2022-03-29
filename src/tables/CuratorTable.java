package tables;

import dbo.Curator;
import dbo.Student;

import java.util.List;

public class CuratorTable extends TableAbs<Curator>{
    public CuratorTable(String dbType) {
        super(dbType);
    }


    @Override
    public List<Curator> list() {
        return null;
    }

    @Override
    public void create() {

    }
}
