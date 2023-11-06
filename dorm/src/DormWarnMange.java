import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DormWarnMange {

    // 管理界面
    public  void GL(String fileGender) throws IOException {
        while (true) {
            System.out.println("**********便捷宿舍管理系统宿舍警示页面**********");
            System.out.println("\t\t1.增加宿舍警示信息");
            System.out.println("\t\t2.删除宿舍警示信息");
            System.out.println("\t\t3.查询宿舍警示信息");
            System.out.println("\t\t4.修改宿舍警示信息");
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
        ArrayList<Dormwarn> array = new ArrayList<Dormwarn>();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        System.out.print("警示号：");
        String id = sc.nextLine();
        glReader(fileGender, array);
        for (int i = 0; i < array.size(); i++) {
            Dormwarn s = array.get(i);
            if (s.getId().equals(id)) {
                System.out.println("警示号存在！！！");
                System.out.print("请输入没有重复的警示号：");
                id = sc.nextLine();

                break;
            }
        }
       
        System.out.print("警示内容(逗号之类的符号，只能用中文)：");
        String content = sc.nextLine();

        Dormwarn s = new Dormwarn();
        s.setId(id);
        s.setContent(content);
        array.add(s);

        glWriter(fileGender, array);
        System.out.println("添加成功！");

    }

    // 删
    public  void remove(String fileGender) throws IOException {
        ArrayList<Dormwarn> array = new ArrayList<Dormwarn>();
        Scanner sc = new Scanner(System.in);
        glReader(fileGender, array);
        while (true) {
            boolean flag = false;
            System.out.print("删除警示号：");
            String id = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                Dormwarn s = array.get(i);
                if (s.getId().equals(id)) {
                    System.out.println("警示号存在！");
                    array.remove(i);
                    System.out.println("删除成功！");
                    flag = true;
                    break;
                } else if ((i == array.size() - 1) && (!s.getId().equals(id))) {
                    System.out.println("警示号不存在！！！");

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
        ArrayList<Dormwarn> array = new ArrayList<Dormwarn>();
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
    public  void qbfine(String fileGender, ArrayList<Dormwarn> array) throws IOException {
        glReader(fileGender, array);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("【警示ID】                【警示内容】");
        if (array.size() != 0) {
            for (int i = 0; i < array.size(); i++) {
                Dormwarn s = array.get(i);
                System.out.println(s.getId() + "    " + s.getContent() + "\t    ");
            }
        } else {
            System.out.println("无信息！！！");
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    // 关键字查询
    public  void gjfine(String fileGender, ArrayList<Dormwarn> array) throws IOException {
        glReader(fileGender, array);
        Scanner sc = new Scanner(System.in);
        System.out.println("关键字：");
        String gj = sc.nextLine();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("【警示ID】                【警示内容】");
        if (array.size() != 0) {
            for (int i = 0; i < array.size(); i++) {
                Dormwarn s = array.get(i);
                if (s.getId().equals(gj) || s.getContent().equals(gj) ) {
                    System.out.println(s.getId() + "    " + s.getContent() );
                } else if (i == array.size() - 1 && !s.getId().equals(gj) || !s.getContent().equals(gj)) {
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
        ArrayList<Dormwarn> array = new ArrayList<Dormwarn>();
        Scanner sc = new Scanner(System.in);
        glReader(fileGender, array);
        while (true) {
            boolean flag = false;
            System.out.println("修改警示号：");
            String id = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                Dormwarn s = array.get(i);
                if (s.getId().equals(id)) {
                    System.out.print("新警示内容(逗号之类的符号，只能用中文)：");
                    String content = sc.nextLine();

                    s.setId(id);
                    s.setContent(content);


                    array.set(i, s);
                    System.out.println("修改成功！");

                    flag = true;
                    break;
                } else if ((i == array.size() - 1) && (!s.getId().equals(id))) {
                    System.out.println("警示号不存在！！！");

                }

            }
            if (flag) {
                break;
            }

        }
        glWriter(fileGender, array);

    }

    // 管理界面-读
    public  void glReader(String fileGender, ArrayList<Dormwarn> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileGender));
        String line;
        while ((line = br.readLine()) != null) {
            String[] date = line.split(",");
            Dormwarn s = new Dormwarn();
            s.setId(date[0]);
            s.setContent(date[1]);

            array.add(s);

        }
        br.close();
    }

    // 管理界面-写
    public  void glWriter(String fileGender, ArrayList<Dormwarn> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileGender));
        for (int i = 0; i < array.size(); i++) {
            Dormwarn s = array.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(s.getId()).append(",").append(s.getContent());

            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}