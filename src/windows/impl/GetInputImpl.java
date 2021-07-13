/*
 * @Author: xv_rong
 * @Date: 2021-07-10 21:37:29
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-13 14:37:34
 * @Description: 
 * @FilePath: \TCMS\src\windows\impl\GetInputImpl.java
 */
package windows.impl;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import Tool.Education;
import entity.Course.Course;
import entity.Person.Student;
import entity.Person.Teacher;
import entity.TClass.TClass;
import windows.GetInput;

public class GetInputImpl implements GetInput {
    static final PrintStream jout = System.out;
    static Scanner input = null;
    static final PrintImpl PT = new PrintImpl();

    /**
     * @descreption chech input
     * @param str
     * @return true if contain of str is a number
     */
    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        if (str.substring(0, 1).equals("-")) {
            return pattern.matcher(str.substring(1)).matches();
        }
        return pattern.matcher(str).matches();
    }

    @Override
    public Education getInputEducation() {
        int chos = -1;
        while (true) {
            input = new Scanner(System.in);
            jout.print("请输入学历(0:PRIMARY, 1:JUNIOR, 2:HIGH): ");
            String str = input.next();
            if (isNumeric(str) == false) {
                jout.println(String.format("输入'%s'不是数字, 请重新输入", str));
                continue;
            }
            chos = Integer.parseInt(str);
            if (chos < 0 || chos > 2) {
                jout.println("没有该选项, 请重新输入");
                continue;
            }
            break;
        }

        switch (chos) {
            case 0:
                return Education.PRIMARY;
            case 1:
                return Education.JUNIOR;
            case 2:
                return Education.HIGH;
            default:
                return Education.HIGH; // 不会执行,为了去除报错
        }
    }

    @Override
    public int getInputCourse(ArrayList<Course> courseList) {
        PT.printCourseBasicInfomation(courseList);
        int chos = -1;
        while (true) {
            input = new Scanner(System.in);
            jout.print("请输入选择课程的序号: ");
            String str = input.next();
            if (isNumeric(str) == false) {
                jout.println(String.format("输入'%s'不是数字, 请重新输入", str));
                continue;
            }
            chos = Integer.parseInt(str);
            if (chos < 0 || chos > courseList.size()) {
                jout.println("没有该选项, 请重新输入");
                continue;
            }
            break;
        }
        return courseList.get(chos).getCourseId();
    }

    @Override
    public int getInputClass(ArrayList<TClass> tClassList) {
        PT.printTClassBasicInfomation(tClassList);
        int chos = -1;
        while (true) {
            input = new Scanner(System.in);
            jout.print("请输入选择班级的序号: ");
            String str = input.next();
            if (isNumeric(str) == false) {
                jout.println(String.format("输入'%s'不是数字, 请重新输入", str));
                continue;
            }
            chos = Integer.parseInt(str);
            if (chos < 0 || chos > tClassList.size()) {
                jout.println("没有该选项, 请重新输入");
                continue;
            }
            break;
        }
        return tClassList.get(chos).getClassID();
    }

    @Override
    public int getInputStudent(ArrayList<Student> studentList) {
        PT.printStudentBasicInfomation(studentList);
        int chos = -1;
        while (true) {
            input = new Scanner(System.in);
            jout.print("请输入选择学生的序号: ");
            String str = input.next();
            if (isNumeric(str) == false) {
                jout.println(String.format("输入'%s'不是数字, 请重新输入", str));
                continue;
            }
            chos = Integer.parseInt(str);
            if (chos < 0 || chos > studentList.size()) {
                jout.println("没有该选项, 请重新输入");
                continue;
            }
            break;
        }
        return studentList.get(chos).getStudentID();
    }

    @Override
    public int getInputTeacher(ArrayList<Teacher> teacherList) {
        PT.printTeacherBasicInfomation(teacherList);
        int chos = -1;
        while (true) {
            input = new Scanner(System.in);
            jout.print("请输入选择老师的序号: ");
            String str = input.next();
            if (isNumeric(str) == false) {
                jout.println(String.format("输入'%s'不是数字, 请重新输入", str));
                continue;
            }
            chos = Integer.parseInt(str);
            if (chos < 0 || chos > teacherList.size()) {
                jout.println("没有该选项, 请重新输入");
                continue;
            }
            break;
        }
        return teacherList.get(chos).getTeacherID();
    }

    @Override
    public String getInputName() {
        String str = null;
        while (true) {
            input = new Scanner(System.in);
            jout.print("请输入姓名: ");
            str = input.next();
            if (str.length() > 12) {
                jout.println("名称过长,请重新输入!");
                continue;
            }
            break;
        }
        return str;
    }

    @Override
    public String getInputBirthday() {
        String birthday = null;
        while (true) {
            input = new Scanner(System.in);
            try {
                jout.print("请输入出生日期(格式为yyy-MM-dd, 如2021-07-19): ");
                birthday = input.next();
                String[] date = birthday.split("-");
                if (date.length != 3) {
                    throw new Exception("格式错误,请重新弄输入!");
                }
                if ((isNumeric(date[0]) && isNumeric(date[1]) && isNumeric(date[2])) == false) {
                    throw new Exception("日期必须由数字组成");
                }

                SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
                sd.setLenient(false);
                sd.parse(birthday);
                break;
            } catch (ParseException e) {
                jout.println("输入日期不合法!");
            } catch (Exception e) {
                jout.println(e.getMessage());
            }
        }

        return birthday;
    }

    @Override
    public String getInputSex() {
        String str = null;
        while (true) {
            input = new Scanner(System.in);
            jout.print("请输入性别(男/女): ");
            str = input.next();
            if (str.equals("男") || str.equals("女")) {
                break;
            }
            jout.println("不能选择性别: " + str + ", 请重新输入");
        }
        return str;
    }

    @Override
    public int getInputId() {
        int id = -1;
        while (true) {
            input = new Scanner(System.in);
            jout.print("请输入ID");
            String str = input.next();
            if (isNumeric(str) == false) {
                jout.println(String.format("输入'%s'不是数字, 请重新输入", str));
                continue;
            }
            id = Integer.parseInt(str);
            if (id < 0 || id > 2) {
                jout.println("没有该选项, 请重新输入");
                continue;
            }
            break;
        }
        return id;
    }

    @Override
    public int getInputYear() {
        int year = -1;
        while (true) {
            input = new Scanner(System.in);
            jout.print("请输入年份: ");
            String str = input.next();
            if (isNumeric(str) == false) {
                jout.println(String.format("输入'%s'不是数字, 请重新输入", str));
                continue;
            }
            year = Integer.parseInt(str);
            if (year < 0) {
                jout.println("年份不合法, 请重新输入");
                continue;
            }
            break;
        }
        return year;
    }

    @Override
    public int getInputSalary() {
        int salary = -1;
        while (true) {
            input = new Scanner(System.in);
            jout.print("请输入金额: ");
            String str = input.next();
            if (isNumeric(str) == false) {
                jout.println(String.format("输入'%s'不是数字, 请重新输入", str));
                continue;
            }
            salary = Integer.parseInt(str);
            if (salary < 0) {
                jout.println("金额不能为负数, 请重新输入");
                continue;
            }
            break;
        }
        return salary;
    }

    @Override
    public String getInputPassword() {
        String password = null;
        while (true) {
            input = new Scanner(System.in);
            try {
                jout.print("请输入密码: ");
                password = input.next();
                if (password.length() < 6) {
                    throw new Exception("密码长度必须大于5!");
                } else if (password.length() > 12) {
                    throw new Exception("密码长度必须小于13!");
                }
                String regex1 = ".*[a-zA-z].*";
                boolean result1 = password.matches(regex1); // 包含字母
                String regex2 = ".*[0-9].*";
                boolean result2 = password.matches(regex2); // 包含数字
                String regex3 = ".*[~!@#$%^&*()-_=+\\|[{}]:'\",<.>/?].*";
                boolean result3 = password.matches(regex3); // 包含下划线
                if (result1 && result2 && result3)
                    break;
                else {
                    throw new Exception("密码必须同时包含字母,数字和特殊字符(~!@#$%^&*()-_=+\\|[{}]:'\",<.>/?)");
                }

            } catch (Exception e) {
                jout.println("密码不符合要求, " + e.getMessage());
            }
        }
        return password;

    }

    @Override
    public boolean getInputYN() {
        Boolean chos = false;
        while (true) {
            input = new Scanner(System.in);
            jout.print("是否确认?(Y/N)");
            String str = input.next();
            if (str.toUpperCase().equals("Y") || str.equals("YES")) {
                chos = true;
                break;
            } else if (str.toUpperCase().equals("N") || str.equals("NO")) {
                chos = false;
                break;
            } else {
                jout.print("非法选项, ");
            }
        }
        return chos;
    }

    @Override
    public int getInputClassMaxNum() {
        int maxNum = -1;
        while (true) {
            input = new Scanner(System.in);
            try {
                String str = input.next();
                if (isNumeric(str) == false) {
                    throw new Exception(String.format("输入'%s'不是数字", str));
                }
                maxNum = Integer.parseInt(str);
                if (maxNum < 0) {
                    maxNum = -1;
                    throw new Exception("maxNum必须大于0");
                }
                break;
            } catch (Exception e) {
                jout.println("输入不合法!" + e.getMessage());
            }
        }
        return maxNum;
    }

    @Override
    public int getInputFunction(int functionNum) {
        int func = -1;
        input = new Scanner(System.in);
        do {
            jout.print("请输入选择: ");
            func = input.nextInt();
            if (func < 0 || func > functionNum) {
                System.out.print("输入错误!");
            }
        } while (func < 0 || func > functionNum);
        return func;
    }

    public static void main(String[] args) {
        // GetInputImpl Test = new GetInputImpl();
        // Education edu = Test.getInputEducation();
        // jout.println("输入成功: " + edu);

        // ArrayList<Course> courseList = new ArrayList<Course>();
        // courseList.add(Debug.createCourse(Education.HIGH, "人工智能基础"));
        // courseList.add(Debug.createCourse(Education.HIGH, "毛泽东思想与中国特色社会主义理论体系概论"));
        // int courseId = Test.getInputCourse(courseList);
        // jout.println("输入成功, 课程ID: " + courseId);

        // ArrayList<TClass> tClassList = new ArrayList<TClass>();
        // tClassList.add(Debug.createTClass(2021, Education.JUNIOR, 996, 101));
        // tClassList.add(Debug.createTClass(1998, Education.PRIMARY, 007, 97));
        // int courseId = Test.getInputClass(tClassList);
        // jout.println("输入成功, 课程ID: " + courseId);

        // ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        // teacherList.add(Debug.createTeacher(001, "奥菲利亚", "女", "2045-11-17", 23,
        // 180000.5));
        // teacherList.add(Debug.createTeacher(002, "navy", "女", "2008-06-01", 34,
        // 84521.0));
        // int teacherId = Test.getInputTeacher(teacherList);
        // jout.println("输入成功, 老师ID: " + teacherId);

        // String name = Test.getInputName();
        // jout.println("输入成功, 姓名: " + name);

        // String sex = Test.getInputSex();
        // jout.println("输入成功, 性别: " + sex);

        // int year = Test.getInputYear();
        // jout.println("输入成功，年份: "+ year);

        // String password = Test.getInputPassword();
        // jout.println("输入成功, 性别: " + password);

        // String birthday = Test.getInputBirthday();
        // jout.println("输入的日期为: " + birthday);
    }

    @Override
    public void getInputEnter() {
        input = new Scanner(System.in);
        input.nextLine();
    }
}
