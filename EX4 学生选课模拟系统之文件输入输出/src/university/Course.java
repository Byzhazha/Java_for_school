package university;

import java.io.Serializable;

public class Course implements Serializable {
    private int id;
    private String name;
    private String location;
    private String time;
    private Teacher teacher;

    public Course(int id, String name, String location, String time, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.time = time;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return "课程：" + name + " 上课地点：" + location + " 上课时间：" + time + " 授课老师：" + teacher.getName();
    }
}
