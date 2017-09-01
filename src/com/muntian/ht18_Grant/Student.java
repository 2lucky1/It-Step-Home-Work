package com.muntian.ht18_Grant;

public class Student {
    private String lastName;
    private String name;
    private String patronymic;
    private int numberOfGroup;
    private int[] marks;
    private int numberOfMarks;

    public Student(String lastName, String name, String patronymic, int numberOfGroup, int[] marks) {
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.numberOfGroup = numberOfGroup;
        this.marks = marks.clone();
        this.numberOfMarks = marks.length;
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
        this.marks = marks;
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

    public int getNumberOfMarks() {
        return numberOfMarks;
    }

    public void setNumberOfMarks(int numberOfMarks) {
        this.numberOfMarks = numberOfMarks;
    }
}
