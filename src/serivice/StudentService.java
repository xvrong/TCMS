/*
 * @Author: xv_rong
 * @Date: 2021-07-12 16:13:06
 * @LastEditors: LinXuan
 * @LastEditTime: 2021-07-12 17:21:01
 * @Description: 
 * @FilePath: \TCMS\src\serivice\StudentService.java
 */
package serivice;

public interface StudentService {
    /**
     * @description: show student's personal info
     * @param {*}
     * @return {*}
     */    
    public void showPersonalInfo();
    
    /**
     * @description: show this student's all class now
     * @param {*}
     * @return {*}
     */    
    public void showPersonalTClass();
    
    /**
     * @description: show this student's all history class
     * @param {*}
     * @return {*}
     */    
    public void showHistoryTClass();

    /**
     * @description: select new class
     * @param {*}
     * @return {*}
     */    
    public void selectCourse();

    /**
     * @description: start student service
     * @param {*}
     * @return {*}
     */    
    public void run(int studentID);
}
