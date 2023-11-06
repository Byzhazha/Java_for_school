package university;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private Course selectedCourse;
    private boolean hasDroppedCourse = false;

    public Student(int id, String name, String gender) {
        super(id, name, gender);
        this.selectedCourse = null; // 设置 selectedCourse 初始值为 null
    }

    public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void selectCourse(Course course) {
        if (course != null) {
            this.selectedCourse = course;
            this.hasDroppedCourse = false;
        }
    }

    public void dropCourse() {
        selectedCourse = null;
        this.hasDroppedCourse = true;
    }

    @Override
    public String toString() {
        String studentInfo = "姓名：" + getName() + " 性别：" + getGender();

        if (hasDroppedCourse) {
            return studentInfo + " 所选课程：已退课";
        } else if (selectedCourse != null) {
            String courseInfo = "所选课程：" + selectedCourse.getName() + "，授课老师：" + (selectedCourse.getTeacher() != null ? selectedCourse.getTeacher().getName() : "无") + "，上课地点：" + selectedCourse.getLocation() + "，上课时间：" + selectedCourse.getTime();
            return studentInfo + " " + courseInfo;
        } else {
            return studentInfo + " 所选课程：无";
        }
    }
}
