package serivice;

import serivice.impl.CourseManagerServiceImpl;
import serivice.impl.StudentManagerServiceImpl;
import serivice.impl.TClassManagerServiceImpl;
import serivice.impl.TeacherManagerServiceImpl;

public interface ManagerService {
    static StudentManagerService studentManager = new StudentManagerServiceImpl();
    static TeacherManagerService teacherManager = new TeacherManagerServiceImpl();
    static CourseManagerService courseManager = new CourseManagerServiceImpl();
    static TClassManagerService tClassManager = new TClassManagerServiceImpl();

    void run();
}
