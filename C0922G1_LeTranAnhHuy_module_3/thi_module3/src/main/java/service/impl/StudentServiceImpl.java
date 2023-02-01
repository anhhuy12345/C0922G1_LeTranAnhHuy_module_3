package service.impl;




import model.Student;
import service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    IStudentService studentService = new StudentServiceImpl();
    @Override
    public List<Student> findAll() {
//        return null;
        return studentService.findAll();
    }
}
