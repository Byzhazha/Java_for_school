public class Dorm {
    String dongnum;//栋号
    String gender;//男、女宿舍
    String level;//楼层
    String roomsnum;//间数
    String bednum;//床位数

    public Dorm(String dongnum, String gender, String level, String roomsnum, String bednum) {
        this.dongnum = dongnum;
        this.gender = gender;
        this.level = level;
        this.roomsnum = roomsnum;
        this.bednum = bednum;
    }

    public Dorm() {

    }

    @Override
    public String toString() {
        return "Dorm{" +
                "dongnum='" + dongnum + '\'' +
                ", gender='" + gender + '\'' +
                ", level='" + level + '\'' +
                ", roomsnum='" + roomsnum + '\'' +
                ", bednum='" + bednum + '\'' +
                '}';
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRoomsnum() {
        return roomsnum;
    }

    public void setRoomsnum(String roomsnum) {
        this.roomsnum = roomsnum;
    }

    public String getBednum() {
        return bednum;
    }

    public void setBednum(String bednum) {
        this.bednum = bednum;
    }
}
