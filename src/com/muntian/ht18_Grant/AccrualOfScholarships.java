package com.muntian.ht18_Grant;

public class AccrualOfScholarships {
    private static final int FIRE = 1;
    private static final int NORMAL = 2;
    private static final int GOOD = 3;
    private static final int GOOD_EXCELLENT = 4;
    private static final int EXCELLENT = 5;

    public static void main(String[] args) {
        Student nick = new Student("Muntian", "Nikolai", "Nikolayevich", 212, new int[]{5, 5, 4, 3});
        Student denis = new Student("Shatsky", "Denis", "Ihorevich", 211, new int[]{4, 4, 4, 4});
        Student vladislav = new Student("Komarevsky", "Vladislav", "Alexandrovich", 212, new int[]{4, 4, 3, 3});
        Student alexandr = new Student("Caran", "Alexandr", "Petrovich", 212, new int[]{4, 3, 3, 3});
        Student vadim = new Student("Kirienko", "Vadim", "Sergeyevich", 211, new int[]{4, 3, 4});
        Student anna = new Student("Kaglyal", "Anna", "Vladimirovna", 211, new int[]{5, 5, 5, 5, 5});
        Student ecaterina = new Student("Chistova", "Ecaterina", "Anatolievna", 211, new int[]{5, 5, 5, 5});
        Student maxim = new Student("Nikitenko", "Maxim", "Sergeevich", 212, new int[]{1, 1, 1, 1});

        Student[] listOfStudents = new Student[]{nick, denis, vladislav, alexandr, vadim, anna, ecaterina, maxim};

        printStudents(sortByLastName(formationOfListOfFellows(listOfStudents)));

    }

    private static Student[] formationOfListOfFellows(Student[] listOfStudents) {
        int countOfFellows = 0;
        for (int i = 0; i < listOfStudents.length; i++) {
            determineOfAcademicPerformance(listOfStudents[i]);
            if (listOfStudents[i].getAcademicPerformance() > 2) {
                countOfFellows++;
            }
        }
        Student[] listOfFellows = new Student[countOfFellows];

        for (int i = 0; i < listOfStudents.length; i++) {
            int j = 0;
            switch (listOfStudents[i].getAcademicPerformance()) {
                case GOOD:
                    listOfFellows[j] = listOfStudents[i];
                    j++;
                    break;
                case GOOD_EXCELLENT:
                    listOfFellows[j] = listOfStudents[i];
                    j++;
                    break;
                case EXCELLENT:
                    listOfFellows[j] = listOfStudents[i];
                    j++;
            }
        }
        return listOfFellows;
    }

    public static void determineOfAcademicPerformance(Student student) {
        int countOf3 = 0;
        int numberOfMarks = student.getMarks().length;
        int sumOfMarks = 0;
        for (int i = 0; i < numberOfMarks; i++) {
            if (student.getMarks()[i] < 3) {
                student.setAcademicPerformance(FIRE);
                return;
            }
            sumOfMarks = sumOfMarks + student.getMarks()[i];
            if (student.getMarks()[i] == 3) {
                countOf3++;
            }
        }

        if (countOf3 > 2) {
            student.setAcademicPerformance(NORMAL);
        } else if (student.getAverageMark() == 5) {
            student.setAcademicPerformance(EXCELLENT);
        } else if (student.getAverageMark() < 5 && countOf3 == 0) {
            student.setAcademicPerformance(GOOD_EXCELLENT);
        } else if (student.getAverageMark() == 4 && countOf3 == 0) {
            student.setAcademicPerformance(GOOD);
        }
    }

    private static Student[] sortByLastName(Student[] listOfFellows) {
        Student[] sortList = listOfFellows.clone();
        for (int i = 0; i < listOfFellows.length; i++) {
            for (int j = 1; j < (listOfFellows.length - i); j++) {
                if (compareStudentsByLastName(listOfFellows[j - 1], listOfFellows[j])) {
                    Student temp = listOfFellows[j - 1];
                    listOfFellows[j - 1] = listOfFellows[j];
                    listOfFellows[j] = temp;
                }
            }
        }
        return sortList;
    }

    private static boolean compareStudentsByLastName(Student student1, Student student2) {
        return student1.getLastName().compareTo(student2.getLastName()) > 0;
    }

    private static void printStudents(Student[] listOfStudents) {
        System.out.println("Last name\t\t\tFirst name\t\tAn increase to a scholarship");
        System.out.println("---------------------------");
        for (int i = 0; i < listOfStudents.length; ++i) {
            switch (listOfStudents[i].getAcademicPerformance()) {
                case 5:
                    System.out.printf("%s\t\t%s\t\t%d%n",
                            listOfStudents[i].getLastName(),
                            listOfStudents[i].getName(),
                            "100%");
                    break;
                case 4:
                    System.out.printf("%s\t\t%s\t\t%d%n",
                            listOfStudents[i].getLastName(),
                            listOfStudents[i].getName(),
                            "50%");
                    break;
                case 3:
                    System.out.printf("%s\t\t%s\t\t%d%n",
                            listOfStudents[i].getLastName(),
                            listOfStudents[i].getName(),
                            "25%");
                case 2:
                    System.out.printf("%s\t\t%s\t\t%d%n",
                            listOfStudents[i].getLastName(),
                            listOfStudents[i].getName(),
                            "0%");
            }
        }
    }
}

