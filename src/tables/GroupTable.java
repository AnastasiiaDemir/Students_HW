package tables;

import dbo.Group;
import dbo.Student;

import java.util.List;

public class GroupTable extends TableAbs<Group>{
    public GroupTable(String dbType) {
        super(dbType);
    }

    @Override
    public List<Group> list() {
        return null;
    }

    @Override
    public void create() {

    }
}
