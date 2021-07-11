/*
 * @Author: xv_rong
 * @Date: 2021-07-10 21:37:29
 * @LastEditors: LinXuan
 * @LastEditTime: 2021-07-11 20:41:49
 * @Description: 
 * @FilePath: \TCMS\src\windows\impl\GetInputImpl.java
 */
package windows.impl;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import Tool.Debug;
import Tool.Education;
import entity.Course.Course;
import entity.TClass.TClass;
import windows.GetInput;

public class GetInputImpl implements GetInput {
    static final PrintStream jout = System.out;
    static final Scanner input = new Scanner(System.in);
    static final PrintImpl PT = new PrintImpl();

    /**
     * @descreption chech input
     * @param str
     * @return true if contain of str is a number
     */
    private static boolean isNumeric(String str){ 
        Pattern pattern = Pattern.compile("[0-9]*");
        if(str.substring(0, 1).equals("-")) {
            return pattern.matcher(str.substring(1)).matches();
        }
        return pattern.matcher(str).matches();    
     }

    @Override
    public Education getInputEducation() {
        int chos = -1;
        while(true)
        {
            jout.print("请输入学历(0:PRIMARY, 1:JUNIOR, 2:HIGH): ");
            String str = input.next();
            if(isNumeric(str) == false) {
                jout.println(String.format("输入'%s'不是数字, 请重新输入", str));
                continue;
            }
            chos = Integer.parseInt(str);
            if(chos<0 || chos>2) {
                jout.println("没有该选项, 请重新输入");
                continue;
            }
            break;
        }

        switch(chos)
        {
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
        while(true)
        {
            jout.print("请输入选择课程的序号: ");
            String str = input.next();
            if(isNumeric(str) == false) {
                jout.println(String.format("输入'%s'不是数字, 请重新输入", str));
                continue;
            }
            chos = Integer.parseInt(str);
            if(chos<0 || chos > courseList.size()) {
                jout.println("没有该选项, 请重新输入");
                continue;
            }
            break;
        }
        return courseList.get(chos).getCourseId();
    }

    @Override
    public int getInputClass(ArrayList<TClass> classList) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getInputTeacher() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getInputName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getInputBirthday() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getInputSex() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getInputId() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getInputYear() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getInputSalary() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getInputPassword() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getInputCourseName(Education education) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean getInputYN() {
        // TODO Auto-generated method stub
        return false;
    }
    public static void main(String[] args) {
        GetInputImpl Test = new GetInputImpl();
        // Education edu = Test.getInputEducation();
        // jout.println("输入成功: " + edu);

        ArrayList<Course> courseList = new ArrayList<Course>();
        courseList.add(Debug.createCourse(Education.HIGH, "人工智能基础"));
        courseList.add(Debug.createCourse(Education.HIGH, "毛泽东思想与中国特色社会主义理论体系概论"));
        int courseId = Test.getInputCourse(courseList);
        jout.println("输入成功, 课程ID: " + courseId);

        
    }
}
