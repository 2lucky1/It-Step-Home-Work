package com.muntian.ht18_Grant;

public class Student {

    private String lastName;
    private String name;
    private String patronymic;
    private int numberOfGroup;
    private int[] marks;
    private int academicPerformance = 0;
    private double averageMark;

    public Student(String lastName, String name, String patronymic, int numberOfGroup, int[] marks) {
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.numberOfGroup = numberOfGroup;
        this.marks = marks.clone();
        averageMark = determineAverageMark();
    }

    public Student() {

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public int[] getMarks() {
        return marks.clone();
    }

    public void setMarks(int[] marks) {
        this.marks = marks.clone();
    }

//    public int getNumberOfTests(int[]marks){
//        int numberOfTests = 0;
//        for (int i = 0; i<marks.length;i++){
//            if (marks[i]!=0){
//                numberOfTests++;
//            }
//        }
//        return numberOfTests;
//    }

    public int getAcademicPerformance() {
        return academicPerformance;
    }

    public void setAcademicPerformance(int academicPerformance) {
        this.academicPerformance = academicPerformance;
    }

    public double getAverageMark() {

        return averageMark;
    }

    private double determineAverageMark() {
        int sumOfMarks = 0;
        for (int i = 0; i < marks.length; i++) {
            sumOfMarks = sumOfMarks + marks[i];
        }
        return sumOfMarks / marks.length;
    }
}
