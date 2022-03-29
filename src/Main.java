import dbo.Student;
import servises.GroupServise;
import servises.SchemaServise;
import servises.StudentServise;
import tables.StudentTable;

import java.util.List;

public class Main {

    public static void main(String... args) {

     /*   List<Student> students = new StudentTable("mysql").list();

       for(Student student: students) {
            System.out.println(student.getFio());
        }*/

/*
        SchemaServise schemaServise = new SchemaServise("mysql");
        schemaServise.createSchema();
        schemaServise.fillSchema();
*/







        StudentServise studentServise = new StudentServise("mysql");
        System.out.println("Вывести на экран информацию о всех студентах включая название группы и имя куратора:");
        studentServise.printAllStudentsGroupCurator();
        System.out.println("");

        System.out.println("Вывод количества студентов:");
        studentServise.printCountAllStudents();
        System.out.println("");

        System.out.println("Вывод всех студенток:");
        studentServise.printAllFemaleStudents();
        System.out.println("");

        System.out.println("Вывод списка групп с их кураторами:");
        GroupServise groupServise = new GroupServise("mysql");
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
