package university;

import java.io.Serializable;

public class Teacher extends Person implements Serializable {
    private Course course;

    public Teacher(int id, String name, String gender) {
        super(id, name, gender);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return super.toString() + " 所教课程：" + (course != null ? course.getName() : "无");
    }
}
