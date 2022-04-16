import dbo.Student;
import servises.Common;
import servises.CuratorServise;
import servises.GroupServise;
import servises.StudentServise;
import tables.StudentTable;
import java.util.List;

public class Main {
    public static void main(String... args) {
/*        List<Student> students = new StudentTable("mysql").list();
       for(Student student: students) {
            System.out.println(student.getFio());
        }*/
        StudentServise studentServise = new StudentServise("mysql");
        GroupServise groupServise = new GroupServise("mysql");
        CuratorServise curatorServise = new CuratorServise("mysql");
/*      curatorServise.createSchema();
        curatorServise.fillSchema();
        studentServise.createSchema();
        studentServise.fillSchema();
        groupServise.createSchema();
        groupServise.fillSchema();*/
        System.out.println("Вывести на экран информацию о всех студентах включая название группы и имя куратора:");
        studentServise.printAllStudentsGroupCurator();
        System.out.println("");
        System.out.println("Вывод количества студентов:");
        studentServise.printCountAllStudents();
        System.out.println("");
        Common common = new Common("mysql");
        common.printCountAllRecords("student");
        System.out.println("Вывод всех студенток:");
        studentServise.printAllFemaleStudents();
        System.out.println("");
        System.out.println("Вывод списка групп с их кураторами:");
        groupServise.printGroupAndCurator();
        studentServise.updateCurator(3,3);
        System.out.println("");
        System.out.println("Вывод списка групп с их кураторами после апдейта:");
        groupServise.printGroupAndCurator();
        System.out.println("");
        System.out.println("Используя вложенные запросы вывести на экран студентов из определенной группы (поиск по имени группы):");
        groupServise.findStudentGroup("'Первая группа'");
    }
}
