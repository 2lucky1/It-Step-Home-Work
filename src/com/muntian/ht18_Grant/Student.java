package com.muntian.ht18_Grant;

public class Student {

    private static final int MARK_1 = 1;
    private static final int MARK_2 = 2;
    private static final int MARK_3 = 3;
    private static final int MARK_4 = 4;
    private static final int MARK_5 = 5;

    private String lastName;
    private String name;
    private String patronymic;
    private int numberOfGroup;
    private int[] marks;
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

    public int getAcademicPerformance() {
        int countOf3 = 0;
        int countOf4 = 0;
        int countOf5 = 0;
        int numberOfMarks = this.getMarks().length;
        for (int i = 0; i < numberOfMarks; i++) {
            switch (this.getMarks()[i]) {
                case MARK_1:
                case MARK_2:
                    return 1;
                case MARK_3:
                    countOf3++;
                    break;
                case MARK_4:
                    countOf4++;
                    break;
                case MARK_5:
                    countOf5++;
            }
        }
        if (countOf5>0&&countOf3==0&&countOf4==0){
            return 5;
        }else if (countOf5>0&&countOf4>0&&countOf3==0){
            return 4;
        }else if(countOf4>0&&countOf5==0&&countOf3==0){
            return 3;
        }else if (countOf3<=countOf5){
            return 2;
        }else if (countOf3>2){
            return 1;
        }
        return -1;
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
