public class DormEval {
    String dongnum;//栋号
    String gender;//男、女宿舍
    String dormnum;//宿舍号
    String score;//评分
    String grade;//等级


    public DormEval() {
    }

    public DormEval(String dongnum, String gender, String dormnum, String score, String grade) {
        this.dongnum = dongnum;
        this.gender = gender;
        this.dormnum = dormnum;
        this.score = score;
        this.grade = grade;
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

    public String getDormnum() {
        return dormnum;
    }

    public void setDormnum(String dormnum) {
        this.dormnum = dormnum;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
