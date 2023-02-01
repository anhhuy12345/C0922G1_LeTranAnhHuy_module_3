package model.service.Impl;

import model.bean.Student;
import model.repository.IStudentRepository;
import model.repository.Impl.StudentRepository;
import model.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAllUser() {
        return studentRepository.findAllUser();
    }

    @Override
    public boolean insertStudent(Student student) {
        return studentRepository.insertStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public Student selectStudent(int id) {
        return studentRepository.selectStudent(id);
    }

    @Override
    public List<Student> searchStudent(String address) {
        return studentRepository.searchStudent(address);
    }
}
