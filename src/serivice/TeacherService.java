/*
 * @Author: LinXuan
 * @Date: 2021-07-12 16:58:57
 * @Description: 
 * @LastEditors: LinXuan
 * @LastEditTime: 2021-07-12 20:04:07
 * @FilePath: \TCMS\src\serivice\TeacherService.java
 */
package serivice;

public interface TeacherService {
    /**
     * @description: show personal information
     * @param {*}
     * @return {*}
     */    
    public void showPersonalInfo();

    /**
     * @description: show teaching class now
     * @param {*}
     * @return {*}
     */    
    public void showTeachingClass();
    
    /**
     * @description: 查询所教授的所有学生
     * @param {*}
     * @return {*}
     */    
    public void searchTeachingStudent();
    
    /**
     * @description: 展示所有交过的班级基本信息
     * @param {*}
     * @return {*}
     */    
    public void showHistoryTeachingClass();

    /**
     * @description: 查询自己某个学生的信息(只能查询自己正在教授的学生的信息)
     * @param {int} studentID
     * @return {*}
     */    
    public void searchTeachingStudentInfo();

    /**
     * @description: 教师服务的程序入口 
     * @param {*}
     * @return {*}
     */    
    public void run(int TeacherID);
    
}