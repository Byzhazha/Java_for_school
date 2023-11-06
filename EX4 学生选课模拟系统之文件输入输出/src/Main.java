import university.Course;
import university.Student;
import university.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher(1, "张老师", "男");
        Course mathCourse = new Course(1001, "高等数学", "教301", "周一 8:00 AM", teacher1);
        Student student1 = new Student(101, "小明", "男");
        student1.selectCourse(mathCourse);
        Student student2 = new Student(202, "小季", "男");
        Teacher teacher2 = new Teacher(2, "李老师", "女");
        Course historyCourse = new Course(2002, "中国近代史纲要", "教205", "周二 3:30 PM", teacher2);
        teacher2.setCourse(historyCourse);
        student2.selectCourse(historyCourse);
//        student1 .dropCourse();
        // 保存选课结果到文件
        saveCourseSelection("course_selection.txt", student1, student2);

        // 从文件中读取选课结果
        readCourseSelection("course_selection.txt");
    }

    public static void saveCourseSelection(String fileName, Student... students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // 遍历每个学生对象
            for (Student student : students) {
                Course selectedCourse = student.getSelectedCourse();
                if (selectedCourse != null) {
                    // 如果学生选择了课程，将相关信息写入文件
                    writer.println(student.getId() + "|" + student.getName() + "|" + student.getGender() + "|" +
                            selectedCourse.getId() + "|" + selectedCourse.getName() + "|" + selectedCourse.getTeacher().getName() + "|" +
                            selectedCourse.getLocation() + "|" + selectedCourse.getTime());
                } else {
                    // 如果学生没有选择课程，写入相应的占位符
                    writer.println(student.getId() + "|" + student.getName() + "|" + student.getGender() + "||");
                }
            }
            System.out.println("选课结果已保存到文件 " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readCourseSelection(String fileName) {
        List<Student> students = new ArrayList<>();
        List<Student> droppedStudents = new ArrayList<>(); // 用于存储已退课的学生

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 5) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String gender = parts[2];
                    int courseId = Integer.parseInt(parts[3]);
                    String courseName = parts[4];
                    String teacherName = parts[5];
                    String location = parts[6];
                    String time = parts[7];

                    Student student = new Student(id, name, gender);
                    Course course = new Course(courseId, courseName, location, time, new Teacher(0, teacherName, ""));
                    student.selectCourse(course);

                    students.add(student);
                } else if (parts.length == 3) {
                    // 如果有三个部分，表示学生退课，将其添加到已退课的学生列表
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String gender = parts[2];
                    Student student = new Student(id, name, gender);
                    droppedStudents.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 打印从文件中读取的学生信息
        for (Student student : students) {
            System.out.println("从文件中读取选课结果：" + student);
        }

        // 打印已退课的学生信息
        for (Student droppedStudent : droppedStudents) {
            System.out.println(droppedStudent.getName() + " 已经退课");
        }
    }

}
