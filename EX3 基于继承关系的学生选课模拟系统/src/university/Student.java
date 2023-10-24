package university;

public class Student extends src.university.Person {
    private Course selectedCourse;
    private boolean hasDroppedCourse; // 新的属性

    public Student(int id, String name, String gender) {
        super(id, name, gender);
    }

    public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void selectCourse(Course course) {
        this.selectedCourse = course;
        this.hasDroppedCourse = false; // 学生选择新课程时，重置退课状态
    }

    public void dropCourse() {
        selectedCourse = null;
        this.hasDroppedCourse = true; // 学生退课时，设置退课状态为 true
    }

    public void printCourseDetails() {
        String studentName = getName();
        String courseInfo;

        if (hasDroppedCourse) {
            courseInfo = "已退课";
        } else if (selectedCourse != null) {
            courseInfo = "所选课程：" + selectedCourse.getName() + "，授课老师：" + selectedCourse.getTeacher().getName() + "，上课地点：" + selectedCourse.getLocation() + "，上课时间：" + selectedCourse.getTime();
        } else {
            courseInfo = "所选课程：无";
        }

        System.out.println(studentName + "，" + courseInfo);
    }

    @Override
    public String toString() {
        String studentInfo = "姓名：" + getName() + " 性别：" + getGender();

        if (hasDroppedCourse) {
            return studentInfo + " 所选课程：已退课";
        } else if (selectedCourse != null) {
            String courseInfo = "所选课程：" + selectedCourse.getName() + "，授课老师：" + selectedCourse.getTeacher().getName() + "，上课地点：" + selectedCourse.getLocation() + "，上课时间：" + selectedCourse.getTime();
            return studentInfo + " " + courseInfo;
        } else {
            return studentInfo + " 所选课程：无";
        }
    }
}
