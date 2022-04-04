package io.pragra.com.japlearning2.service;

import io.pragra.com.japlearning2.entites.Student;
import io.pragra.com.japlearning2.entites.StudentPermit;
import io.pragra.com.japlearning2.repo.ProgramsRepo;
import io.pragra.com.japlearning2.repo.StudentPermitRepo;
import io.pragra.com.japlearning2.repo.StudentRepo;
import io.pragra.com.japlearning2.repo.StudentReviewsRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class StudentService {

    private StudentRepo repo;
    private StudentPermitRepo studentPermitRepo;
    private StudentReviewsRepo studentReviewsRepo;
    private ProgramsRepo programsRepo;


    //    @Transactional
//    public void runCode(){
//        StudentPermit studentPermit = StudentPermit.builder().permitName("Java student permit").build();
//        Student student1 = Student.builder().name("Jegan").permit(studentPermit).build();
//        System.out.println(studentPermitRepo.save(studentPermit));
//        System.out.println(repo.save(student1));
//
//
//    }
//    @Transactional
//    public void fetchCode(){
//        Optional<Student> byId = repo.findById(2);
//        byId.ifPresent(System.out::println);
//        log.info(" Student permit fetch from datbase --> {} ",byId.get());
//        byId.map(s->s.getPermit()).ifPresent(System.out::println);
    public Student createStudent(Student student) {

       student.getReviews().stream().forEach(studentReviewsRepo::save);
       student.getPrograms().stream().forEach(programsRepo::save);
        return repo.save(student);

    }

    public Student updateStudent(Student student) {
        return createStudent(student);
    }

    public boolean deleteStudentById(Integer id) {
        Optional<Student> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return true;
        }
        return false;

    }

    public boolean deleteStudentPermitById(Integer id) {
        Optional<StudentPermit> byId = studentPermitRepo.findById(id);
        if (byId.isPresent()) {
            studentPermitRepo.delete(byId.get());
            return true;
        }
        return false;
    }
}