import university.Course;
import university.Student;
import university.Teacher;

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
//        student1.dropCourse();     //退课方法，已屏蔽
        student1.printCourseDetails();
        student2.printCourseDetails();

    }
}