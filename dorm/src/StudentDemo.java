import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDemo {

    // 管理界面
    public  void GL(String fileName) throws IOException {
        while (true) {
            System.out.println("**********便捷宿舍管理系统学生管理页面**********");
            System.out.println("\t\t1.增学生信息");
            System.out.println("\t\t2.删学生信息");
            System.out.println("\t\t3.查学生信息");
            System.out.println("\t\t4.改学生信息");
            System.out.println("\t\t5.返回宿舍管理");
            System.out.println("\t\t6.退出程序");
            System.out.print("选择：");
            Scanner sc = new Scanner(System.in);
            String choose = sc.nextLine();
            switch (choose) {
                case "1":
                    add(fileName);
                    break;
                case "2":
                    remove(fileName);
                    break;
                case "3":
                    fine(fileName);
                    break;
                case "4":
                    update(fileName);
                    break;
                case "5":
                    String fileGender = "dorminfo.txt";
                    DormMange dormMange = new DormMange();
                    dormMange.GL(fileGender);
                    break;
                case "6":
                    System.out.println("退出成功！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("错误！！！");
                    break;
            }
        }

    }

    // 增
    public static void add(String fileName) throws IOException {
        ArrayList<Student> array = new ArrayList<Student>();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        System.out.print("学号：");
        String id = sc.nextLine();
        glReader(fileName, array);
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getId().equals(id)) {
                System.out.println("学号存在！！！");
                System.out.println("请重新输入没有重复的学号！");
                id = sc.nextLine();
                break;
                
            }
        }

        System.out.print("姓名：");
        String name = sc.nextLine();
        System.out.print("电话：");
        String phone = sc.nextLine();
        System.out.print("专业：");
        String major = sc.nextLine();
        System.out.print("地址：");
        String address = sc.nextLine();

        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setPhone(phone);
        s.setMajor(major);
        s.setAddress(address);
        array.add(s);

        glWriter(fileName, array);
        System.out.println("添加成功！");

    }

    // 删
    public static void remove(String fileName) throws IOException {
        ArrayList<Student> array = new ArrayList<Student>();
        Scanner sc = new Scanner(System.in);
        glReader(fileName, array);
        while (true) {
            boolean flag = false;
            System.out.print("删除学号：");
            String id = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                if (s.getId().equals(id)) {
                    System.out.println("学号存在！");
                    array.remove(i);
                    System.out.println("删除成功！");
                    flag = true;
                    break;
                } else if ((i == array.size() - 1) && (!s.getId().equals(id))) {
                    System.out.println("学号不存在！！！");

                }

            }
            if (flag) {
                break;
            }
        }
        glWriter(fileName, array);
    }

    // 查
    public static void fine(String fileName) throws IOException {
        ArrayList<Student> array = new ArrayList<Student>();
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t1.全部查询");
        System.out.println("\t\t2.关键字查询");
        System.out.print("选择：");
        String choose = sc.nextLine();
        switch (choose) {
            case "1":
                qbfine(fileName, array);
                break;
            case "2":
                gjfine(fileName, array);
                break;
            default:
                System.out.println("错误！！！");
                break;
        }
    }

    // 全部查询
    public static void qbfine(String fileName, ArrayList<Student> array) throws IOException {
        glReader(fileName, array);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("【学号】                【姓名】                【电话】                【专业】                【地址】");
        if (array.size() != 0) {
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                System.out.println(s.getId() + "    " + s.getName() + "\t    " + s.getPhone() + "\t  " + s.getMajor()
                        + "\t" + s.getAddress());
            }
        } else {
            System.out.println("无信息！！！");
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    // 关键字查询
    public static void gjfine(String fileName, ArrayList<Student> array) throws IOException {
        glReader(fileName, array);
        Scanner sc = new Scanner(System.in);
        System.out.println("关键字：");
        String gj = sc.nextLine();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("【学号】                【姓名】                【电话】                【专业】                【地址】");
        if (array.size() != 0) {
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                if (s.getId().equals(gj) || s.getName().equals(gj) || s.getPhone().equals(gj) || s.getMajor().equals(gj)
                        || s.getAddress().equals(gj)) {
                    System.out.println(s.getId() + "    " + s.getName() + "\t    " + s.getPhone() + "\t  "
                            + s.getMajor() + "\t" + s.getAddress());
                } else if (i == array.size() - 1 && !s.getId().equals(gj) || !s.getName().equals(gj)
                        || !s.getPhone().equals(gj) || !s.getMajor().equals(gj) || !s.getAddress().equals(gj)) {
                    System.out.println("\t\t\t\t无信息！！！");
                }
            }
        } else {
            System.out.println("\t\t\t\t无信息！！！");
        }

        System.out.println("-------------------------------------------------------------------------");
    }

    // 改
    public static void update(String fileName) throws IOException {
        ArrayList<Student> array = new ArrayList<Student>();
        Scanner sc = new Scanner(System.in);
        glReader(fileName, array);
        while (true) {
            boolean flag = false;
            System.out.println("修改学号：");
            String id = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                if (s.getId().equals(id)) {
                    System.out.print("新姓名：");
                    String name = sc.nextLine();
                    System.out.print("新电话：");
                    String phone = sc.nextLine();
                    System.out.print("新专业：");
                    String major = sc.nextLine();
                    System.out.print("新地址：");
                    String address = sc.nextLine();

                    s.setName(name);
                    s.setPhone(phone);
                    s.setMajor(major);
                    s.setAddress(address);

                    array.set(i, s);
                    System.out.println("修改成功！");

                    flag = true;
                    break;
                } else if ((i == array.size() - 1) && (!s.getId().equals(id))) {
                    System.out.println("学号不存在！！！");

                }

            }
            if (flag) {
                break;
            }

        }
        glWriter(fileName, array);

    }

    // 管理界面-读
    public static void glReader(String fileName, ArrayList<Student> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] date = line.split(",");
            Student s = new Student();
            s.setId(date[0]);
            s.setName(date[1]);
            s.setPhone(date[2]);
            s.setMajor(date[3]);
            s.setAddress(date[4]);

            array.add(s);

        }
        br.close();
    }

    // 管理界面-写
    public static void glWriter(String fileName, ArrayList<Student> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(s.getId()).append(",").append(s.getName()).append(",").append(s.getPhone()).append(",")
                    .append(s.getMajor()).append(",").append(s.getAddress());

            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}