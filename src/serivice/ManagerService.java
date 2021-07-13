/*
 * @Author: xv_rong
 * @Date: 2021-07-12 21:44:28
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-13 14:41:14
 * @Description: 
 * @FilePath: \TCMS\src\serivice\ManagerService.java
 */
package serivice;

import SQL.Query;
import SQL.Update;
import SQL.Impl.QueryImpl;
import SQL.Impl.UpdateImpl;
import serivice.impl.CourseManagerServiceImpl;
import serivice.impl.StudentManagerServiceImpl;
import serivice.impl.TClassManagerServiceImpl;
import serivice.impl.TeacherManagerServiceImpl;
import windows.GetInput;
import windows.Print;
import windows.impl.GetInputImpl;
import windows.impl.PrintImpl;

public interface ManagerService {
    GetInput get = new GetInputImpl();
    Query qy = new QueryImpl();
    Print pt = new PrintImpl();
    Update up = new UpdateImpl();
    static StudentManagerService studentManager = new StudentManagerServiceImpl();
    static TeacherManagerService teacherManager = new TeacherManagerServiceImpl();
    static CourseManagerService courseManager = new CourseManagerServiceImpl();
    static TClassManagerService tClassManager = new TClassManagerServiceImpl();

    void run();
}
