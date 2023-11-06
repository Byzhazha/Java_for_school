import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DormEvalMange {

    // 管理界面
    public  void GL(String fileGender) throws IOException {
        while (true) {
            System.out.println("**********便捷宿舍管理系统宿舍评比页面**********");
            System.out.println("\t\t1.增加宿舍评比信息");
            System.out.println("\t\t2.删除宿舍评比信息");
            System.out.println("\t\t3.查询宿舍评比信息");
            System.out.println("\t\t4.修改宿舍评比信息");
            System.out.println("\t\t5.返回宿舍管理");
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
                    String fileGendertxt = "dorminfo.txt";
                    DormMange dormMange = new DormMange();
                    dormMange.GL(fileGendertxt);
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
    
    // 增
    public  void add(String fileGender) throws IOException {
        ArrayList<DormEval> array = new ArrayList<DormEval>();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        System.out.print("宿舍号：");
        String dormnum = sc.nextLine();
        glReader(fileGender, array);
        for (int i = 0; i < array.size(); i++) {
            DormEval s = array.get(i);
            if (s.getDormnum().equals(dormnum)) {
                System.out.println("宿舍号存在！！！");
                System.out.print("请输入没有重复的宿舍号：");
                dormnum = sc.nextLine();
                break;
            }
        }

        System.out.print("宿舍楼号：");
        String dongnum = sc.nextLine();
        System.out.print("男女宿舍：");
        String gender = sc.nextLine();
        
        System.out.print("评分：");
        String score = sc.nextLine();
        System.out.print("等级：");
        String grade = sc.nextLine();

        DormEval s = new DormEval();
        s.setDongnum(dongnum);
        s.setGender(gender);
        s.setDormnum(dormnum);
        s.setScore(score);
        s.setGrade(grade);
        array.add(s);

        glWriter(fileGender, array);
        System.out.println("添加成功！");

    }

    // 删
    public  void remove(String fileGender) throws IOException {
        ArrayList<DormEval> array = new ArrayList<DormEval>();
        Scanner sc = new Scanner(System.in);
        glReader(fileGender, array);
        while (true) {
            boolean flag = false;
            System.out.print("删除宿舍号：");
            String dormnum = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                DormEval s = array.get(i);
                if (s.getDormnum().equals(dormnum)) {
                    System.out.println("宿舍号存在！");
                    array.remove(i);
                    System.out.println("删除成功！");
                    flag = true;
                    break;
                } else if ((i == array.size() - 1) && (!s.getDormnum().equals(dormnum))) {
                    System.out.println("宿舍号不存在！！！");

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
        ArrayList<DormEval> array = new ArrayList<DormEval>();
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
    public  void qbfine(String fileGender, ArrayList<DormEval> array) throws IOException {
        glReader(fileGender, array);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("【宿舍楼号】                【男女宿舍】                【宿舍号】                【评分】                【等级】");
        if (array.size() != 0) {
            for (int i = 0; i < array.size(); i++) {
                DormEval s = array.get(i);
                System.out.println(s.getDongnum() + "    " + s.getGender() + "\t    " + s.getDormnum() + "\t  " + s.getScore()
                        + "\t" + s.getGrade());
            }
        } else {
            System.out.println("无信息！！！");
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    // 关键字查询
    public  void gjfine(String fileGender, ArrayList<DormEval> array) throws IOException {
        glReader(fileGender, array);
        Scanner sc = new Scanner(System.in);
        System.out.println("关键字：");
        String gj = sc.nextLine();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("【宿舍楼号】                【男女宿舍】                【宿舍号】                【评分】                【等级】");
        if (array.size() != 0) {
            for (int i = 0; i < array.size(); i++) {
                DormEval s = array.get(i);
                if (s.getDongnum().equals(gj) || s.getGender().equals(gj) || s.getDormnum().equals(gj) || s.getScore().equals(gj)
                        || s.getGrade().equals(gj)) {
                    System.out.println(s.getDongnum() + "    " + s.getGender() + "\t    " + s.getDormnum() + "\t  "
                            + s.getScore() + "\t" + s.getGrade());
                } else if (i == array.size() - 1 && !s.getDongnum().equals(gj) || !s.getGender().equals(gj)
                        || !s.getDormnum().equals(gj) || !s.getScore().equals(gj) || !s.getGrade().equals(gj)) {
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
        ArrayList<DormEval> array = new ArrayList<DormEval>();
        Scanner sc = new Scanner(System.in);
        glReader(fileGender, array);
        while (true) {
            boolean flag = false;
            System.out.println("修改宿舍号：");
            String dormnum = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                DormEval s = array.get(i);
                if (s.getDormnum().equals(dormnum)) {
                    System.out.print("新宿舍楼栋名：");
                    String dongnum = sc.nextLine();
                    System.out.print("新男女宿舍：");
                    String gender = sc.nextLine();
                    System.out.print("新评分：");
                    String score = sc.nextLine();
                    System.out.print("新等级：");
                    String grade = sc.nextLine();

                    s.setDongnum(dongnum);
                    s.setGender(gender);
                    s.setDormnum(dormnum);
                    s.setScore(score);
                    s.setGrade(grade);

                    array.set(i, s);
                    System.out.println("修改成功！");

                    flag = true;
                    break;
                } else if ((i == array.size() - 1) && (!s.getDormnum().equals(dormnum))) {
                    System.out.println("宿舍楼号不存在！！！");

                }

            }
            if (flag) {
                break;
            }

        }
        glWriter(fileGender, array);

    }

    // 管理界面-读
    public  void glReader(String fileGender, ArrayList<DormEval> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileGender));
        String line;
        while ((line = br.readLine()) != null) {
            String[] date = line.split(",");
            DormEval s = new DormEval();
            s.setDongnum(date[0]);
            s.setGender(date[1]);
            s.setDormnum(date[2]);
            s.setScore(date[3]);
            s.setGrade(date[4]);

            array.add(s);

        }
        br.close();
    }

    // 管理界面-写
    public  void glWriter(String fileGender, ArrayList<DormEval> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileGender));
        for (int i = 0; i < array.size(); i++) {
            DormEval s = array.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(s.getDongnum()).append(",").append(s.getGender()).append(",").append(s.getDormnum()).append(",")
                    .append(s.getScore()).append(",").append(s.getGrade());

            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}