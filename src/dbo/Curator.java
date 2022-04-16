package dbo;

public class Curator {
    private int id;
    private String fio;
    public final static String tableName = "Students";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Curator(int id, String fio) {
        this.id = id;
        this.fio = fio;
    }
}
