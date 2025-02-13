package com.ranga.java8;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExample {
    public static void main(String[] args) {
        Function<StudentEntity,StudentDao> dtoMapper=(StudentEntity studentEntity)->{
            StudentDao studentDao=new StudentDao(studentEntity.getId(), studentEntity.getfName()+" "+studentEntity.getlName());
            return studentDao;
        };

        //Get Entities from DataBase
        List<StudentEntity> entities= getEntitiesFromDB();

        //Convert Entities to Daos using Mapper
        List<StudentDao> studentDtos = entities.stream().map(dtoMapper).toList();

        //Print Daos or send Daos to UI
        studentDtos.forEach(studentDto -> {
            System.out.println("studentId :"+studentDto.getStudentId());
            System.out.println("fullName :"+studentDto.getFullName());
        });

    }

    private static List<StudentEntity> getEntitiesFromDB() {
        return List.of(
                new StudentEntity(1, "Ranga", "Reddy"),
                new StudentEntity(2, "Raju", "Reddy"),
                new StudentEntity(3, "Kiran", "Reddy"),
                new StudentEntity(4, "Mohan", "Reddy"),
                new StudentEntity(5, "Raghu", "Reddy")
        );
    }
}


class StudentEntity{

    private final Integer id;
    private final String fName;
    private final String lName;

    public StudentEntity(Integer id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    public Integer getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }
}

class StudentDao{
    private final Integer studentId;
    private final String fullName;

    public StudentDao(Integer studentId, String fullName) {
        this.studentId = studentId;
        this.fullName = fullName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }
}