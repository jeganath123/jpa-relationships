package io.pragra.com.japlearning2;

import io.pragra.com.japlearning2.entites.Programs;
import io.pragra.com.japlearning2.entites.Reviews;
import io.pragra.com.japlearning2.entites.Student;
import io.pragra.com.japlearning2.entites.StudentPermit;
import io.pragra.com.japlearning2.repo.StudentPermitRepo;
import io.pragra.com.japlearning2.repo.StudentRepo;
import io.pragra.com.japlearning2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Japlearning2Application {
    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(Japlearning2Application.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            StudentPermit studentPermit =
                    StudentPermit.builder()
                            .permitName("devopos student permit")
                            .build();
            Reviews review = Reviews.builder().programName("Java").programText("very Happy").build();
            Programs java_course = Programs.builder().name("Java course").duration(180L).build();
            Student student1 =
                    Student.builder().name("vino")
                            .permit(studentPermit)
                            .programs(Arrays.asList(Programs.builder().name("Java course").duration(180L).build()
                                    ,Programs.builder().name("QA course").duration(120L).build()
                                    ,Programs.builder().name("Devops course").duration(150L).build()))
                            .reviews(Arrays.asList(review,
                                    Reviews.builder().programName("Devops").programText("very Happy").build(),
                                    Reviews.builder().programName("QA").programText("very Happy").build()))
                            .build();


            studentService.createStudent(student1);

            studentService.createStudent(Student.builder().name("vino")
                    .programs(Arrays.asList(Programs.builder().name("Java 2 course ").duration(180L).build()
                            ,Programs.builder().name("QA 2 course").duration(120L).build()
                            ,Programs.builder().name("Devops 2 course").duration(150L).build()))
                    .reviews(Arrays.asList(review,
                            Reviews.builder().programName("Java").programText(" Happy").build(),
                            Reviews.builder().programName("QA").programText(" Happy").build(),
                            Reviews.builder().programName("Devops").programText(" Happy").build()))
                    .permit(StudentPermit.builder()
                            .permitName("devopos student permit not allowed")
                            .build())
                    .build());

            studentService.createStudent(Student.builder().name("lovepreet")
                    .programs(Arrays.asList(Programs.builder().name("Java 3 course").duration(180L).build()
                            ,Programs.builder().name("QA 3 course").duration(120L).build()
                            ,Programs.builder().name("Devops 3 course").duration(150L).build()))
                    .reviews(Arrays.asList(review,
                            Reviews.builder().programName("Java").programText("not Happy").build(),
                            Reviews.builder().programName("QA").programText("not Happy").build(),
                            Reviews.builder().programName("Devops").programText("not Happy").build()))
                    .permit(StudentPermit.builder()
                            .permitName("QA permit allowed")
                            .build())
                    .build());
             //studentService.deleteStudentById(1);
//             studentService.deleteStudentPermitById(2);
        };
    }


}
