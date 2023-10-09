public class Main {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher(1, "章老师", "男", "高等数学");
        Teacher teacher2 = new Teacher(2, "郭老师", "女", "中国近代史纲要");
        Teacher teacher3 = new Teacher(3, "张世博老师", "男", "Java");
        Teacher teacher4 = new Teacher(4, "李佳阳老师", "女", "大学物理");

        Student student1 = new Student(101, "学生1", "女");
        Student student2 = new Student(102, "学生2", "男");

        Course mathCourse = new Course(1001, "高等数学", "教201", "周一 10:00 AM", "章老师");
        Course historyCourse = new Course(1002, "中国近代史纲要", "教206", "周二 8:00 AM", "郭老师");
        Course javaCourse = new Course(1003, "Java", "教305", "周三 3:30 PM", "张世博老师");
        Course physicsCourse = new Course(1004, "大学物理", "教101", "周四 1:30 PM", "李佳阳老师");

        // 简化的教师开设课程方法
        openCourse(teacher1, mathCourse);
        openCourse(teacher2, historyCourse);
        openCourse(teacher3, javaCourse);
        openCourse(teacher4, physicsCourse);

        // 学生选课
        student1.selectCourse(mathCourse.getCourseName());
        student2.selectCourse(historyCourse.getCourseName());

        System.out.println(student1.getName() + " 选择了 " + student1.getSelectedCourse() + " 课程。");
        System.out.println(student2.getName() + " 选择了 " + student2.getSelectedCourse() + " 课程。");

        // 打印学生课表信息
        printStudentCourseInfo(student1, javaCourse);
        printStudentCourseInfo(student2, historyCourse);
    }

    // 简化的教师开设课程方法
    public static void openCourse(Teacher teacher, Course course) {
        System.out.println(teacher.getName() + " 开设了 " + course.getCourseName() + " 课程。");
    }

    // 简化的学生课表信息打印方法
    public static void printStudentCourseInfo(Student student, Course course) {
        System.out.println(student.getName() + " 的课表信息：");
        System.out.println("课程名称: " + course.getCourseName());
        System.out.println("上课地点: " + course.getLocation());
        System.out.println("时间: " + course.getTime());
        System.out.println("授课教师: " + course.getTeacherName()+"\n");
    }
}
