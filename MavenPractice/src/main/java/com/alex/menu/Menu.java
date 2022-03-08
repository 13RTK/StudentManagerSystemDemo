package com.alex.menu;

import com.alex.entity.Student;
import com.alex.utils.StudentUtil;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Menu {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int curOption;
    private static String exitMark;
    private static String continueMark;

    @SneakyThrows
    public static void welcomePage() {
        System.out.println("Welcome to student manager system, enter the valid number: ");
        System.out.println("1: Check all student\n" +
                "2: Query student by ID\n" +
                "3: Query student by name\n" +
                "0: Exit");

        isDigit(reader.readLine());
        invokeMethodByOption();
    }

    @SneakyThrows
    public static void invokeMethodByOption() {
        switch (Menu.curOption) {
            case 1:
                List<Student> allStudent = StudentUtil.getAllStudent();
                isMatched(allStudent);
                allStudent.forEach(System.out::println);
                isContinue();
                return;

            case 2:
                System.out.println("Please enter the ID: ");
                Student studentById = StudentUtil.getStudentById(Integer.parseInt(reader.readLine()));
                isMatched(studentById);
                System.out.println(studentById);
                isContinue();
                return;

            case 3:
                System.out.println("Please enter the student name: ");
                List<Student> studentByName = StudentUtil.getStudentByName(reader.readLine());
                isMatched(studentByName);
                studentByName.forEach(System.out::println);
                isContinue();
                return;

            case 0:
                System.out.println("Are you sure to exit?(Y/N)");
                Menu.exitMark = reader.readLine();

                isExit();
                return;
            default:
        }
    }

    @SneakyThrows
    public static void isExit() {
        if (exitMark.equals("Y")) {
            System.exit(0);
        } else if (exitMark.equals("N")) {
            welcomePage();
        } else {
            System.out.println("Enter is illegal, please enter again!");
            Menu.exitMark = Menu.reader.readLine();
            isExit();
        }
    }

    @SneakyThrows
    public static void isContinue() {
        System.out.println("Are you want to continue?(Y/N)");

        Menu.continueMark = reader.readLine();

        if (Menu.continueMark.equals("Y")) {
            welcomePage();
        } else if (Menu.continueMark.equals("N")) {
            System.exit(0);
        } else {
            System.out.println("Enter is illegal, please enter again!");
            isContinue();
        }
    }

    @SneakyThrows(IOException.class)
    private static void isDigit(String input) {
        int curOption;
        try {
            curOption = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Illegal, please enter again:");
            String repeatInput = reader.readLine();
            while (repeatInput.length() != 1 || !Character.isDigit(repeatInput.charAt(0))) {
                System.out.println("Illegal, please enter again:");
                repeatInput = reader.readLine();
            }

            curOption = Integer.parseInt(repeatInput);
        }

        if (curOption <= 3 && curOption >= 0) {
            Menu.curOption = curOption;
        } else {
            System.out.println("Illegal input, please check your input and enter again: ");
            isDigit(reader.readLine());
        }
    }

    @SneakyThrows
    public static void isMatched(Object queryResult) {
        if (queryResult instanceof List) {
            List queryRes = (List) queryResult;

            if (queryRes.isEmpty()) {
                noMatch();
            }
        } else {
            if (queryResult == null) {
                noMatch();
            }
        }
    }

    private static void noMatch() throws IOException {
        String option;
        System.out.println("There's no match data, please enter again or exit: (enter/exit)");
        option = reader.readLine();

        if (option.equals("exit")) {
            System.exit(0);
        } else if (option.equals("enter")) {
            System.out.println("Enter again: ");
            invokeMethodByOption();

            System.out.println("1: Check all student\n" +
                    "2: Query student by ID\n" +
                    "3: Query student by name\n" +
                    "0: Exit");
        } else {
            System.out.println("Illegal enter, please enter again!");
            noMatch();
        }
    }
}
