public class Student {

    String id;//学号
    String name;//姓名
    String phone;//电话
    String major;//专业
    String address;//住址


    public Student() {
    }


    public Student(String id, String name, String phone, String major, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.major = major;
        this.address = address;


    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}