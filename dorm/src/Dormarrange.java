import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Dormarrange {

    // 管理界面
    public  void GL(String fileName) throws IOException {
        while (true) {
            System.out.println("**********便捷宿舍管理系统学生宿舍安排页面**********");
            System.out.println("\t\t1.增加学生宿舍安排信息");
            System.out.println("\t\t2.删除学生宿舍安排信息");
            System.out.println("\t\t3.查询学生宿舍安排信息");
            System.out.println("\t\t4.修改学生宿舍安排信息");
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
        ArrayList<Arrange> array = new ArrayList<Arrange>();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        System.out.print("姓名：");
        String name = sc.nextLine();
        glReader(fileName, array);
        for (int i = 0; i < array.size(); i++) {
            Arrange s = array.get(i);
            if (s.getName().equals(name)) {
                System.out.println("姓名存在，该同学已经安排了宿舍，请重新安排其他学生！！！");
                System.out.print("请重新输入姓名：");
                name = sc.nextLine();
                break;
            }
        }
        System.out.print("学号：");
        String studentnum = sc.nextLine();
        System.out.print("楼栋号：");
        String dongnum = sc.nextLine();
        System.out.print("男女宿舍：");
        String gender = sc.nextLine();
        System.out.print("宿舍编号：");
        String floornum = sc.nextLine();
        System.out.print("床位编号：");
        String bednum = sc.nextLine();

        Arrange s = new Arrange();
        s.setStudentnum(studentnum);
        s.setName(name);
        s.setDongnum(dongnum);
        s.setGender(gender);
        s.setFloornum(floornum);
        s.setBednum(bednum);
        array.add(s);

        glWriter(fileName, array);
        System.out.println("添加成功！");

    }

    // 删
    public static void remove(String fileName) throws IOException {
        ArrayList<Arrange> array = new ArrayList<Arrange>();
        Scanner sc = new Scanner(System.in);
        glReader(fileName, array);
        while (true) {
            boolean flag = false;
            System.out.print("删除姓名：");
            String name = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                Arrange s = array.get(i);
                if (s.getName().equals(name)) {
                    System.out.println("姓名存在！");
                    array.remove(i);
                    System.out.println("删除成功！");
                    flag = true;
                    break;
                } else if ((i == array.size() - 1) && (!s.getName().equals(name))) {
                    System.out.println("姓名不存在！！！");

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
        ArrayList<Arrange> array = new ArrayList<Arrange>();
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
    public static void qbfine(String fileName, ArrayList<Arrange> array) throws IOException {
        glReader(fileName, array);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("【姓名】                【学号】                【楼栋号】                【男女宿舍】                【宿舍编号】                【床位编号】");
        if (array.size() != 0) {
            for (int i = 0; i < array.size(); i++) {
                Arrange s = array.get(i);
                System.out.println(s.getName() + "    " + s.getStudentnum() + "\t    " + s.getDongnum() + "\t  " + s.getGender()
                        + "\t" + s.getFloornum()+ "\t" + s.getBednum());
            }
        } else {
            System.out.println("无信息！！！");
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    // 关键字查询
    public static void gjfine(String fileName, ArrayList<Arrange> array) throws IOException {
        glReader(fileName, array);
        Scanner sc = new Scanner(System.in);
        System.out.println("关键字：");
        String gj = sc.nextLine();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("【姓名】                【学号】                【楼栋号】                【男女宿舍】                【宿舍编号】                【床位编号】");
        if (array.size() != 0) {
            for (int i = 0; i < array.size(); i++) {
                Arrange s = array.get(i);
                if (s.getName().equals(gj) || s.getStudentnum().equals(gj) || s.getDongnum().equals(gj) || s.getGender().equals(gj)
                        || s.getFloornum().equals(gj)) {
                    System.out.println(s.getName() + "    " + s.getName() + "\t    " + s.getDongnum() + "\t  "
                            + s.getGender() + "\t" + s.getFloornum()+ "\t" + s.getBednum());
                } else if (i == array.size() - 1 && !s.getName().equals(gj) || !s.getName().equals(gj)
                        || !s.getDongnum().equals(gj) || !s.getGender().equals(gj) || !s.getFloornum().equals(gj) || !s.getBednum().equals(gj)) {
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
        ArrayList<Arrange> array = new ArrayList<Arrange>();
        Scanner sc = new Scanner(System.in);
        glReader(fileName, array);
        while (true) {
            boolean flag = false;
            System.out.println("修改姓名：");
            String name = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                Arrange s = array.get(i);
                if (s.getName().equals(name)) {
                    System.out.print("新姓名：");
                    String studentnum = sc.nextLine();
                    System.out.print("新楼栋号：");
                    String dongnum = sc.nextLine();
                    System.out.print("新男女宿舍：");
                    String gender = sc.nextLine();
                    System.out.print("新宿舍编号：");
                    String floornum = sc.nextLine();
                    System.out.print("新床位编号：");
                    String bednum = sc.nextLine();

                    s.setName(studentnum);
                    s.setDongnum(dongnum);
                    s.setGender(gender);
                    s.setFloornum(floornum);
                    s.setBednum(bednum);

                    array.set(i, s);
                    System.out.println("修改成功！");

                    flag = true;
                    break;
                } else if ((i == array.size() - 1) && (!s.getName().equals(name))) {
                    System.out.println("姓名不存在！！！");

                }

            }
            if (flag) {
                break;
            }

        }
        glWriter(fileName, array);

    }

    // 管理界面-读
    public static void glReader(String fileName, ArrayList<Arrange> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] date = line.split(",");
            Arrange s = new Arrange();
            s.setName(date[0]);
            s.setStudentnum(date[1]);
            s.setDongnum(date[2]);
            s.setGender(date[3]);
            s.setFloornum(date[4]);
            s.setBednum(date[5]);

            array.add(s);

        }
        br.close();
    }

    // 管理界面-写
    public static void glWriter(String fileName, ArrayList<Arrange> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < array.size(); i++) {
            Arrange s = array.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(s.getName()).append(",").append(s.getStudentnum()).append(",").append(s.getDongnum()).append(",")
                    .append(s.getGender()).append(",").append(s.getFloornum()).append(",").append(s.getBednum());

            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}