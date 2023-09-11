package com.spring.annotation.SpringAnnotation;

import com.spring.annotation.SpringAnnotation.entity.Student;
import com.spring.annotation.SpringAnnotation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringAnnotationApplication implements CommandLineRunner {

	private StudentRepository studentRepository;

	@Autowired
	private ApplicationContext applicationContext;

	public SpringAnnotationApplication(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;

		// Below code will run as well but we use @Postconstruct
		// It means studentRepository spring bean has been created before the SpringAnnotationApplication class bean. when meeans
		// the beans on which the bean are dependant are created first
/*		System.out.println("Data insertion process started");
		studentRepository.saveAll(Stream.of(
						new Student(101, "Basant", 14, "Science"),
						new Student(102, "Santosh", 48, "Arts"),
						new Student(103, "Rajesh", 16, "Commerce"),
						new Student(104, "Sam", 12, "Arts"))
				.collect(Collectors.toList()));

		System.out.println("Data insertion process successful");*/
	}

	@PostConstruct
	public void initStudents() {


		studentRepository.saveAll(Stream.of(
						new Student(101, "Basant", 14, "Science"),
						new Student(102, "Santosh", 48, "Arts"),
						new Student(103, "Rajesh", 16, "Commerce"),
						new Student(104, "Sam", 12, "Arts"))
				.collect(Collectors.toList()));
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringAnnotationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		String[] beans = applicationContext.getBeanDefinitionNames();
//		for (String bean : beans) {
//			System.out.println(bean);
//		}
	}
}
