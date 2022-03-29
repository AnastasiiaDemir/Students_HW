package tables;


import dbo.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentTable extends TableAbs<Student> {

    private Student student;

    public StudentTable(String dbType) {
        super(dbType);
    }

    @Override
    public List<Student> list() {
        ResultSet resultSet = this.dbExecutor.execute(String.format("select * from %s", Student.tableName));

        List<Student> students = new ArrayList<>();

        try {
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt(1),
                        resultSet.getInt(4),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.dbExecutor.close();
        }

        return students;
    }

    @Override
    public void create() {
    }
}