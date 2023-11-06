import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DormIo {
    public static void main(String[] args) throws IOException {
        String fileGender = "dorminfo.txt";
        String fileGender1 = "userinfo.txt";
        System.out.print("请选择登录角色(1是管理员，2是普通用户)：");
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        // 登录
        DL(fileGender1);
        if (type.equals("1")){
            // 管理员界面
            GL(fileGender);
        }else {
            // 普通用户界面
            PL(fileGender);
        }


    }

    // 登录界面
    public static void DL(String fileGender1) throws IOException {

        while (true) {
            boolean flag = false;
            System.out.println("**********便捷宿舍管理系统**********");
            System.out.println("\t\t1.登录");
            System.out.println("\t\t2.注册");
            System.out.print("选择：");
            Scanner sc = new Scanner(System.in);
            String choose = sc.nextLine();
            switch (choose) {
                case "1":
                    denglu(fileGender1);
                    flag = true;
                    break;
                case "2":
                    zhuce(fileGender1);
                    break;
                default:
                    System.out.println("错误!!!");
                    break;
            }
            if (flag) {
                break;
            }
        }
    }

    // 用户注册
    public static void zhuce(String fileGender1) throws IOException {
        ArrayList<UserInfo> array = new ArrayList<UserInfo>();
        Scanner sc = new Scanner(System.in);
        dlReader(fileGender1, array);
        while (true) {
            boolean flag = false;
            System.out.print("注册账号：");
            String account = sc.nextLine();
            // 判断是否已经注册过！！！！

            for (int i = 0; i < array.size(); i++) {
                UserInfo u1 = array.get(i);
                if (u1.getAccount().equals(account)) {
                    System.out.println("该用户已注册！！！");
                    flag = true;
                    break;

                }

            }
            if (flag) {
                zhuce(fileGender1);// 不要放for循环里前否则会多次循环！！！！！！！
                break;
            }
            ///
            System.out.print("注册密码：");
            String password = sc.nextLine();
            System.out.print("确认密码：");
            String password1 = sc.nextLine();

            if (password.equals(password1)) {
                UserInfo u = new UserInfo();
                u.setAccount(account);
                u.setPassword(password1);

                array.add(u);

                dlWriter(fileGender1, array);

                System.out.println("注册成功！");
                break;

            } else {
                System.out.println("密码不一致请重新注册！！！");
            }
        }
    }

    // 用户登录
    public static void denglu(String fileGender1) throws IOException {
        ArrayList<UserInfo> array = new ArrayList<UserInfo>();
        Scanner sc = new Scanner(System.in);
        dlReader(fileGender1, array);

        while (true) {
            boolean flag = false;
            System.out.print("登录账号：");
            String account = sc.nextLine();
            System.out.print("登录密码：");
            String password = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                UserInfo u = array.get(i);
                if (u.getAccount().equals(account) && u.getPassword().equals(password)) {
                    System.out.println("登录成功！");
                    flag = true;
                    break;
                }

            }
            if (!flag) {
                System.out.println("账号或密码错误！！！");
            }
            if (flag) {
                break;
            }
        }

    }

    // 登录界面-读
    public static void dlReader(String fileGender1, ArrayList<UserInfo> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileGender1));

        String line;
        while ((line = br.readLine()) != null) {
            String[] readDate = line.split("\t");
            UserInfo u = new UserInfo();
            u.setAccount(readDate[0]);
            u.setPassword(readDate[1]);

            array.add(u);
        }
        br.close();
    }

    // 登录界面-写
    public static void dlWriter(String fileGender1, ArrayList<UserInfo> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileGender1));
        for (int i = 0; i < array.size(); i++) {
            UserInfo u = array.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(u.getAccount()).append("\t").append(u.getPassword());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();

        }

        bw.close();

    }


    // 管理界面
    public static void GL(String fileGender) throws IOException {
        while (true) {
            System.out.println("**********便捷宿舍管理系统**********");
            System.out.println("\t\t1.增加宿舍信息");
            System.out.println("\t\t2.删除宿舍信息");
            System.out.println("\t\t3.查询宿舍信息");
            System.out.println("\t\t4.修改宿舍信息");
            System.out.println("\t\t5.学生信息管理");
            System.out.println("\t\t6.学生宿舍安排管理");
            System.out.println("\t\t7.学生宿舍评比管理");
            System.out.println("\t\t8.学生宿舍警示管理");
            System.out.println("\t\t0.退出");
            System.out.print("选择：");
            Scanner sc = new Scanner(System.in);
            String choose = sc.nextLine();
            switch (choose) {
                case "1":
                    add(fileGender);
                    break;
                case "2":
                    remove(fileGender);
                    break;
                case "3":
                    fine(fileGender);
                    break;
                case "4":
                    update(fileGender);
                    break;
                case "5":
                    String fileStudent = "student.txt";
                    StudentDemo studentDemo = new StudentDemo();
                    studentDemo.GL(fileStudent);
                    break;
                case "6":
                    String filedormarrange = "dormarrangement.txt";
                    Dormarrange dormarrange = new Dormarrange();
                    dormarrange.GL(filedormarrange);
                    break;
                case "7":
                    String filedormeval = "dormeval.txt";
                    DormEvalMange dormEval = new DormEvalMange();
                    dormEval.GL(filedormeval);
                    break;
                case "8":
                    String filedormwarn = "dormwarn.txt";
                    DormWarnMange dormWarnMange = new DormWarnMange();
                    dormWarnMange.GL(filedormwarn);
                    break;
                case "0":
                    System.out.println("退出成功！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("错误！！！");
                    break;
            }
        }

    }

    // 普通用户界面
    public static void PL(String fileGender) throws IOException {
        while (true) {
            System.out.println("**********便捷宿舍管理系统**********");
            System.out.println("\t\t1.查询宿舍信息");
            System.out.println("\t\t2.修改宿舍信息");
            System.out.println("\t\t3.退出");
            System.out.print("选择：");
            Scanner sc = new Scanner(System.in);
            String choose = sc.nextLine();
            switch (choose) {
                case "1":
                    fine(fileGender);
                    break;
                case "2":
                    update(fileGender);
                    break;
                case "3":
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
    public static void add(String fileGender) throws IOException {
        ArrayList<Dorm> array = new ArrayList<Dorm>();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        System.out.print("宿舍楼栋名：");
        String dongnum = sc.nextLine();
        glReader(fileGender, array);
        for (int i = 0; i < array.size(); i++) {
            Dorm s = array.get(i);
            if (s.getDongnum().equals(dongnum)) {
                System.out.println("宿舍楼已经存在，请重新输入其他宿舍楼名！！！");
                dongnum = sc.nextLine();
                break;
            }
        }
        System.out.print("男女宿舍：");
        String gender = sc.nextLine();
        System.out.print("宿舍楼层数：");
        String level = sc.nextLine();
        System.out.print("楼层间数：");
        String roomsnum = sc.nextLine();
        System.out.print("床位数：");
        String bednum = sc.nextLine();

        Dorm s = new Dorm();
        s.setDongnum(dongnum);
        s.setGender(gender);
        s.setLevel(level);
        s.setRoomsnum(roomsnum);
        s.setBednum(bednum);
        array.add(s);

        glWriter(fileGender, array);
        System.out.println("添加成功！");

    }

    // 删
    public static void remove(String fileGender) throws IOException {
        ArrayList<Dorm> array = new ArrayList<Dorm>();
        Scanner sc = new Scanner(System.in);
        glReader(fileGender, array);
        while (true) {
            boolean flag = false;
            System.out.print("删除宿舍楼栋名：");
            String dongnum = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                Dorm s = array.get(i);
                if (s.getDongnum().equals(dongnum)) {
                    System.out.println("宿舍楼栋号存在！");
                    array.remove(i);
                    System.out.println("删除成功！");
                    flag = true;
                    break;
                } else if ((i == array.size() - 1) && (!s.getDongnum().equals(dongnum))) {
                    System.out.println("宿舍楼栋名不存在！！！");

                }

            }
            if (flag) {
                break;
            }
        }
        glWriter(fileGender, array);
    }

    // 查
    public static void fine(String fileGender) throws IOException {
        ArrayList<Dorm> array = new ArrayList<Dorm>();
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t1.全部查询");
        System.out.println("\t\t2.关键字查询");
        System.out.print("选择：");
        String choose = sc.nextLine();
        switch (choose) {
            case "1":
                qbfine(fileGender, array);
                break;
            case "2":
                gjfine(fileGender, array);
                break;
            default:
                System.out.println("错误！！！");
                break;
        }
    }

    // 全部查询
    public static void qbfine(String fileGender, ArrayList<Dorm> array) throws IOException {
        glReader(fileGender, array);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("【宿舍楼栋名】                【男女宿舍】                【楼层数】                【楼层间数】                【床位数】");
        if (array.size() != 0) {
            for (int i = 0; i < array.size(); i++) {
                Dorm s = array.get(i);
                System.out.println(s.getDongnum() + "    " + s.getGender() + "\t    " + s.getLevel() + "\t  " + s.getRoomsnum()
                        + "\t" + s.getBednum());
            }
        } else {
            System.out.println("无信息！！！");
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    // 关键字查询
    public static void gjfine(String fileGender, ArrayList<Dorm> array) throws IOException {
        glReader(fileGender, array);
        Scanner sc = new Scanner(System.in);
        System.out.println("关键字：");
        String gj = sc.nextLine();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("【宿舍楼栋名】                【男女宿舍】                【楼层数】                【楼层间数】                【床位数】");
        if (array.size() != 0) {
            for (int i = 0; i < array.size(); i++) {
                Dorm s = array.get(i);
                if (s.getDongnum().equals(gj) || s.getGender().equals(gj) || s.getLevel().equals(gj) || s.getRoomsnum().equals(gj)
                        || s.getBednum().equals(gj)) {
                    System.out.println(s.getDongnum() + "    " + s.getGender() + "\t    " + s.getLevel() + "\t  "
                            + s.getRoomsnum() + "\t" + s.getBednum());
                } else if (i == array.size() - 1 && !s.getDongnum().equals(gj) || !s.getGender().equals(gj)
                        || !s.getLevel().equals(gj) || !s.getRoomsnum().equals(gj) || !s.getBednum().equals(gj)) {
                    System.out.println("\t\t\t\t无信息！！！");
                }
            }
        } else {
            System.out.println("\t\t\t\t无信息！！！");
        }

        System.out.println("-------------------------------------------------------------------------");
    }

    // 改
    public static void update(String fileGender) throws IOException {
        ArrayList<Dorm> array = new ArrayList<Dorm>();
        Scanner sc = new Scanner(System.in);
        glReader(fileGender, array);
        while (true) {
            boolean flag = false;
            System.out.println("修改宿舍楼栋名：");
            String dongnum = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                Dorm s = array.get(i);
                if (s.getDongnum().equals(dongnum)) {
                    System.out.print("新男女宿舍：");
                    String gender = sc.nextLine();
                    System.out.print("新楼层数：");
                    String level = sc.nextLine();
                    System.out.print("新楼层间数：");
                    String roomsnum = sc.nextLine();
                    System.out.print("新床位数：");
                    String bednum = sc.nextLine();

                    s.setDongnum(dongnum);
                    s.setGender(gender);
                    s.setLevel(level);
                    s.setRoomsnum(roomsnum);
                    s.setBednum(bednum);

                    array.set(i, s);
                    System.out.println("修改成功！");

                    flag = true;
                    break;
                } else if ((i == array.size() - 1) && (!s.getDongnum().equals(dongnum))) {
                    System.out.println("宿舍楼栋名不存在！！！");

                }

            }
            if (flag) {
                break;
            }

        }
        glWriter(fileGender, array);

    }

    // 管理界面-读
    public static void glReader(String fileGender, ArrayList<Dorm> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileGender));
        String line;
        while ((line = br.readLine()) != null) {
            String[] date = line.split(",");
            Dorm s = new Dorm();
            s.setDongnum(date[0]);
            s.setGender(date[1]);
            s.setLevel(date[2]);
            s.setRoomsnum(date[3]);
            s.setBednum(date[4]);

            array.add(s);

        }
        br.close();
    }

    // 管理界面-写
    public static void glWriter(String fileGender, ArrayList<Dorm> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileGender));
        for (int i = 0; i < array.size(); i++) {
            Dorm s = array.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(s.getDongnum()).append(",").append(s.getGender()).append(",").append(s.getLevel()).append(",")
                    .append(s.getRoomsnum()).append(",").append(s.getBednum());

            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}