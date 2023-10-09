public class Course {
    private int id;
    private String courseName;
    private String location;
    private String time;
    private String teacherName;

    public Course(int id, String courseName, String location, String time, String teacherName) {
        this.id = id;
        this.courseName = courseName;
        this.location = location;
        this.time = time;
        this.teacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }

    public String getTeacherName() {
        return teacherName;
    }

    // 其他 getter 和 setter 方法

    @Override
    public String toString() {
        return "Course [id=" + id + ", courseName=" + courseName + ", location=" + location + ", time=" + time + ", teacherName=" + teacherName + "]";
    }
}
