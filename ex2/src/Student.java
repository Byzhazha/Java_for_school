public class Student {
    private int id;
    private String name;
    private String gender;
    private String selectedCourse;

    public Student(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSelectedCourse() {
        return selectedCourse;
    }

    public void selectCourse(String courseName) {
        this.selectedCourse = courseName;
    }

    public void dropCourse() {
        this.selectedCourse = null;
    }

    // 其他 getter 和 setter 方法

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", selectedCourse=" + selectedCourse + "]";
    }
}
