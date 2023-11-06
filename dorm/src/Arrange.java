public class Arrange {
    String name;//姓名
    String studentnum;//学号
    String dongnum;//楼栋号
    String gender;//男女宿舍
    String floornum;//宿舍编号
    String bednum;//床位编号

    public Arrange(String name, String studentnum, String dongnum, String gender, String floornum, String bednum) {
        this.name = name;
        this.studentnum = studentnum;
        this.dongnum = dongnum;
        this.gender = gender;
        this.floornum = floornum;
        this.bednum = bednum;
    }

    public Arrange() {

    }

    @Override
    public String toString() {
        return "Arrange{" +
                "name='" + name + '\'' +
                ", studentnum='" + studentnum + '\'' +
                ", dongnum='" + dongnum + '\'' +
                ", gender='" + gender + '\'' +
                ", floornum='" + floornum + '\'' +
                ", bednum='" + bednum + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentnum() {
        return studentnum;
    }

    public void setStudentnum(String studentnum) {
        this.studentnum = studentnum;
    }

    public String getDongnum() {
        return dongnum;
    }

    public void setDongnum(String dongnum) {
        this.dongnum = dongnum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFloornum() {
        return floornum;
    }

    public void setFloornum(String floornum) {
        this.floornum = floornum;
    }

    public String getBednum() {
        return bednum;
    }

    public void setBednum(String bednum) {
        this.bednum = bednum;
    }
}
