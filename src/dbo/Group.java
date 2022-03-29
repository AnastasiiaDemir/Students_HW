package dbo;

public class Group {

    private String name;
    private int id;
    private int idCurator;

    public final static String tableName = "Groups";
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCurator() {
        return idCurator;
    }

    public void setIdCurator(int idCurator) {
        this.idCurator = idCurator;
    }

    public Group(int id, String name, int idCurator){


        this.id=id;
        this.name=name;
        this.idCurator =idCurator;

    }
}
