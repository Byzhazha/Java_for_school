class Student {
    private int id;
    private String name;
    private String gender;
    private Course selectedCourse;

    public Student(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void selectCourse(Course course) {
        this.selectedCourse = course;
    }

    public void dropCourse() {
        this.selectedCourse = null;
    }

    @Override
    public String toString() {
        return "姓名：" + name + " 性别：" + gender + " 所选课程：" + selectedCourse.getName();
    }
}
