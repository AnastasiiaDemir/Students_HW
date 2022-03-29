package dbo;

public class Student  {

    public final static String tableName = "Student";

    public String getFio() {
        return fio;
    }

    public String getSex() {
        return sex;
    }

    public int getId() {
        return id;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public Student(int id, int idGroup, String fio, String sex){


        this.id=id;
        this.fio=fio;
        this.idGroup =idGroup;
        this.sex=sex;

    }
    private String fio;
    private String sex;
    private int id;
    private int idGroup;
}
