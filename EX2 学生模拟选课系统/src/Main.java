public class Main {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher(1, "张老师", "男");
        Course mathCourse = new Course(1001, "高等数学", "教室205", "周一 8:00 AM");
        teacher1.setCourse(mathCourse);

        Student student1 = new Student(101, "小明", "男");
        student1.selectCourse(teacher1.getCourse());

        Student student2 = new Student(202, "小季", "男");
        Teacher teacher2 = new Teacher(2, "李老师", "女");
        Course historyCourse = new Course(2002, "中国近代史纲要", "教室205", "周二 3:30 PM");
        student2.selectCourse(historyCourse);

//        student1 .dropCourse();
        System.out.println("学生1信息：" + student1);
        System.out.println("学生2信息：" + student2);
        System.out.println("教师1信息：" + teacher1);
        System.out.println("教师2信息：" + teacher2);
        System.out.println("高等数学课程信息：" + mathCourse);
        System.out.println("中国近代史纲要课程信息：" + historyCourse);
    }
}
