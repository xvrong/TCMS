/*
 * @Author: xv_rong
 * @Date: 2021-07-09 21:48:17
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-11 20:49:46
 * @Description: TClassManagerServiceImpl
 * @FilePath: \TCMS\src\serivice\impl\TClassManagerServiceImpl.java
 */
package serivice.impl;

import serivice.TClassManagerService;

public class TClassManagerServiceImpl implements TClassManagerService {

    @Override
    public void showAllTClass() {
        Query qy = new QueryImpl();
        Print pt = new PrintImpl();
        ArrayList<Course> courseList = qy.queryCourse(true);
        pt.printCourseBasicInfomation(courseList);
    }

    @Override
    public void showCertainTClassStudent() {
        // TODO Auto-generated method stub

    }

    @Override
    public void showCertainTClassTeacher() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addTClass() {
        // TODO Auto-generated method stub

    }

    @Override
    public void ChangeTeacher() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteStudent() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addStudent() {
        // TODO Auto-generated method stub

    }

}
