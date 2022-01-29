package com.rbc.mqspringservice;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class empRecord {

    @Data
    @NoArgsConstructor
    public static class Emp{
        private String firstName;
        private String surName;
        private char gender;
        private LocalDate dob;
        private String empId;
        private char jobType;
        private boolean shiftNeeded;
        private char empLevel;
    }

    public static boolean boolMapper(char value){
        return (value == 'Y') ? true:false;
    }

    public static LocalDate dateMapper(String value){
        final String dateString = String.format("%s-%s-%s",value.substring(0,4),value.substring(4,6),value.substring(6));
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);
    }

    public Emp empMapper(String input){
        final Emp emp = new Emp();
        emp.setFirstName(input.substring(0,19).trim());       //x(20)
        emp.setSurName(input.substring(19,39).trim());        //x(10)
        emp.setGender(input.charAt(40));                      //x(1)
        emp.setDob(dateMapper(input.substring(41,49)));       //x(8) yyyymmdd
        emp.setEmpId(input.substring(49,61));                 //x(12)
        emp.setJobType(input.charAt(61));                     //x(1)
        emp.setShiftNeeded(boolMapper(input.charAt(62)));     //x(1)
        emp.setEmpLevel(input.charAt(63));                    //x(1)

        System.out.println("First Name    : " + emp.getFirstName());
        System.out.println("Sur Name      : " + emp.getSurName());
        System.out.println("Gender        : " + emp.getGender());
        System.out.println("Date of Birth : " + emp.getDob());
        System.out.println("Emp ID        : " + emp.getEmpId());
        System.out.println("Job Type      : " + emp.getJobType());
        System.out.println("Work in Shift : " + input.charAt(62));
        System.out.println("Emp Level     : " + emp.getEmpLevel());
        return emp;
//Ramesh Babu       Chandrasekaran      M20010101 E0000000001PY6
    }
}
