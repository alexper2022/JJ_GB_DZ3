package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Service.loadStudentsFromFile;
import static org.example.Service.saveStudentsToFile;

/*
    1. Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
    Обеспечьте поддержку сериализации для этого класса.
    Создайте объект класса Student и инициализируйте его данными.
    Сериализуйте этот объект в файл.
    Десериализуйте объект обратно в программу из файла.
    Выведите все поля объекта, включая GPA, и ответьте на вопрос,
    почему значение GPA не было сохранено/восстановлено.

    2. * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
 */
public class App {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student("Ivanov I.I.", 20, 85);
        Student student2 = new Student("Petrov P.P.", 21, 80);
        Student student3 = new Student("Sidorov S.S.", 19, 95);
        Student student4 = new Student("Vasiliev V.V.", 19, 100);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        System.out.println("\nДо сериализации:");
        students.stream().forEach(System.out::println);

        saveStudentsToFile("outFile.bin", students);
        saveStudentsToFile("outFile.json", students);
        saveStudentsToFile("outFile.xml", students);

        List<Student> studentsBin = loadStudentsFromFile("outFile.bin");
        System.out.println("\nПосле десериализации из .bin :");
        studentsBin.stream().forEach(System.out::println);
//
        List<Student> studentsJSON = loadStudentsFromFile("outFile.json");
        System.out.println("\nПосле десериализации из .json :");
        studentsJSON.stream().forEach(System.out::println);

        List<Student> studentsXML = loadStudentsFromFile("outFile.xml");
        System.out.println("\nПосле десериализации из .xml :");
        studentsXML.stream().forEach(System.out::println);

    }
}
