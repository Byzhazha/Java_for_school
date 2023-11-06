import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DormMange {

    // 管理界面
    public  void GL(String fileGender) throws IOException {
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
    public  void PL(String fileGender) throws IOException {
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
    public  void add(String fileGender) throws IOException {
        ArrayList<Dorm> array = new ArrayList<Dorm>();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        System.out.print("宿舍几栋：");
        String dongnum = sc.nextLine();
        glReader(fileGender, array);
        for (int i = 0; i < array.size(); i++) {
            Dorm s = array.get(i);
            if (s.getDongnum().equals(dongnum)) {
                System.out.println("宿舍楼存在！！！");
                flag = true;
                break;
            }
        }
        if (flag) {
            add(fileGender);//递归
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
    public  void remove(String fileGender) throws IOException {
        ArrayList<Dorm> array = new ArrayList<Dorm>();
        Scanner sc = new Scanner(System.in);
        glReader(fileGender, array);
        while (true) {
            boolean flag = false;
            System.out.print("删除宿舍几栋：");
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
                    System.out.println("宿舍不存在！！！");

                }

            }
            if (flag) {
                break;
            }
        }
        glWriter(fileGender, array);
    }

    // 查
    public  void fine(String fileGender) throws IOException {
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
    public  void qbfine(String fileGender, ArrayList<Dorm> array) throws IOException {
        glReader(fileGender, array);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("【宿舍几栋】                【男女宿舍】                【宿舍楼栋名】                【楼层间数】                【床位数】");
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
    public  void gjfine(String fileGender, ArrayList<Dorm> array) throws IOException {
        glReader(fileGender, array);
        Scanner sc = new Scanner(System.in);
        System.out.println("关键字：");
        String gj = sc.nextLine();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("【宿舍几栋】                【宿舍楼栋名】                【男女宿舍】                【楼层间数】                【床位数】");
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
    public  void update(String fileGender) throws IOException {
        ArrayList<Dorm> array = new ArrayList<Dorm>();
        Scanner sc = new Scanner(System.in);
        glReader(fileGender, array);
        while (true) {
            boolean flag = false;
            System.out.println("修改宿舍几栋：");
            String dongnum = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                Dorm s = array.get(i);
                if (s.getDongnum().equals(dongnum)) {
                    System.out.print("新宿舍楼栋名：");
                    String gender = sc.nextLine();
                    System.out.print("新男女宿舍：");
                    String level = sc.nextLine();
                    System.out.print("新楼层间数：");
                    String roomsnum = sc.nextLine();
                    System.out.print("新床位数：");
                    String bednum = sc.nextLine();

                    s.setGender(gender);
                    s.setLevel(level);
                    s.setRoomsnum(roomsnum);
                    s.setBednum(bednum);

                    array.set(i, s);
                    System.out.println("修改成功！");

                    flag = true;
                    break;
                } else if ((i == array.size() - 1) && (!s.getDongnum().equals(dongnum))) {
                    System.out.println("宿舍几栋不存在！！！");

                }

            }
            if (flag) {
                break;
            }

        }
        glWriter(fileGender, array);

    }

    // 管理界面-读
    public  void glReader(String fileGender, ArrayList<Dorm> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileGender));//文件读取流
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
    public  void glWriter(String fileGender, ArrayList<Dorm> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileGender));
        for (int i = 0; i < array.size(); i++) {
            Dorm s = array.get(i);
            StringBuilder sb = new StringBuilder();//可变字符串
            sb.append(s.getDongnum()).append(",").append(s.getGender()).append(",").append(s.getLevel()).append(",")
                    .append(s.getRoomsnum()).append(",").append(s.getBednum());

            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}