public class Teacher {
    private int id;
    private String name;
    private String gender;
    private String course;

    public Teacher(int id, String name, String gender, String course) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    // 其他 getter 和 setter 方法

    @Override
    public String toString() {
        return "Teacher [id=" + id + ", name=" + name + ", gender=" + gender + ", course=" + course + "]";
    }
}
