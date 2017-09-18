package com.muntian.ht18_Grant;

public class AccrualOfScholarships {
    private static final int BAD = 1;
    private static final int NORMAL = 2;
    private static final int GOOD = 3;
    private static final int GOOD_EXCELLENT = 4;
    private static final int EXCELLENT = 5;

    public static void main(String[] args) {
        Student nick = new Student("Muntian", "Nikolai", "Nikolayevich", 212, new int[]{5, 5, 4, 4});
        Student denis = new Student("Shatsky", "Denis", "Ihorevich", 211, new int[]{4, 4, 4, 4});
        Student vladislav = new Student("Komarevsky", "Vladislav", "Alexandrovich", 212, new int[]{4, 4, 3, 3});
        Student alexandr = new Student("Caran", "Alexandr", "Petrovich", 212, new int[]{4, 3, 3, 3});
        Student vadim = new Student("Kienko", "Vadim", "Sergeyevich", 211, new int[]{5, 3, 4});
        Student anna = new Student("Kaglyal", "Anna", "Vladimirovna", 211, new int[]{5, 5, 4, 3, 3});
        Student ecaterina = new Student("Chis", "Cate", "Anatolievna", 211, new int[]{5, 5, 5, 5});
        Student maxim = new Student("Nikitenko", "Maxim", "Sergeevich", 212, new int[]{1, 1, 1, 1});

        Student[] listOfStudents = new Student[]{nick, denis, vladislav, alexandr, vadim, anna, ecaterina, maxim};

        printStudents(sortByLastName(formationOfListOfFellows(listOfStudents)));

    }

    private static Student[] formationOfListOfFellows(Student[] listOfStudents) {
        int countOfFellows = 0;
        for (int i = 0; i < listOfStudents.length; i++) {
            if (listOfStudents[i].getAcademicPerformance() > BAD) {
                countOfFellows++;
            }
        }

        Student[] listOfFellows = new Student[countOfFellows];

        int j = 0;
        for (int i = 0; i < listOfStudents.length; i++) {
            switch (listOfStudents[i].getAcademicPerformance()) {
                case NORMAL:
                    listOfFellows[j++] = listOfStudents[i];
                    break;
                case GOOD:
                    listOfFellows[j++] = listOfStudents[i];
                    break;
                case GOOD_EXCELLENT:
                    listOfFellows[j++] = listOfStudents[i];
                    break;
                case EXCELLENT:
                    listOfFellows[j++] = listOfStudents[i];
                    break;
            }
        }
        return listOfFellows;
    }

    private static Student[] sortByLastName(Student[] listOfFellows) {
        Student[] sortList = listOfFellows.clone();
        for (int i = 0; i < sortList.length; i++) {
            for (int j = 1; j < (sortList.length - i); j++) {
                if (compareStudentsByLastName(sortList[j - 1], sortList[j])) {
                    Student temp = sortList[j - 1];
                    sortList[j - 1] = sortList[j];
                    sortList[j] = temp;
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
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < listOfStudents.length; ++i) {
            switch (listOfStudents[i].getAcademicPerformance()) {
                case EXCELLENT:
                    System.out.printf("%s\t\t\t\t\t\t%s\t\t\t%s%n",
                            listOfStudents[i].getLastName(),
                            listOfStudents[i].getName(),
                            "100%");
                    break;
                case GOOD_EXCELLENT:
                    System.out.printf("%s\t\t\t\t\t\t%s\t\t\t%s%n",
                            listOfStudents[i].getLastName(),
                            listOfStudents[i].getName(),
                            "50%");
                    break;
                case GOOD:
                    System.out.printf("%s\t\t\t\t\t\t%s\t\t\t%s%n",
                            listOfStudents[i].getLastName(),
                            listOfStudents[i].getName(),
                            "25%");
                    break;
                case NORMAL:
                    System.out.printf("%s\t\t\t\t\t\t%s\t\t\t%s%n",
                            listOfStudents[i].getLastName(),
                            listOfStudents[i].getName(),
                            "0%");
                    break;
            }
        }
    }
}

