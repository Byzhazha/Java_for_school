class Teacher {
    private int id;
    private String name;
    private String gender;
    private Course course;

    public Teacher(int id, String name, String gender) {
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return " 授课教师：" + name + " 性别：" + gender ;
    }
}
