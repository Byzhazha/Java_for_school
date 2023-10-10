class Course {
    private int id;
    private String name;
    private String location;
    private String time;

    public Course(int id, String name, String location, String time) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.time = time;
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

    @Override
    public String toString() {
        return "课程名称：" + name + " 上课地点：" + location + " 时间：" + time;
    }
}