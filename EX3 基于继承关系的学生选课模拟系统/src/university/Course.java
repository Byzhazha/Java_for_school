package university;

public class Course {
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
        return "课程名称：" + name + " 上课地点：" + location + " 时间：" + time;
    }
}
