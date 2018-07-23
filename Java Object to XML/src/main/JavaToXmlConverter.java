package main;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import pojoStudent.Student;
import pojoStudent.Subject;

public class JavaToXmlConverter {

	public static void main(String[] args) {
		
		Subject eng = new Subject("English","Mr.N.Modi", 001);
		Subject math = new Subject("Maths","Mr. Sanjay",002);
		Subject sci = new Subject("Science","Mr. Ravikesh",003);
		
		List<Subject> subjects = new ArrayList();
		subjects.add(eng);
		subjects.add(math);
		subjects.add(sci);
		
		Student student = new Student("Stu",12,5,5001,1,subjects);
		
		try {
			JAXBContext context = JAXBContext.newInstance(pojoStudent.Student.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
			marshaller.marshal(student, new FileOutputStream("/Users/atulyadav/JavaProjects/Student2.xml"));
			System.out.println("Student to XML done!!!");
			
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Student stu =(Student)unmarshaller.unmarshal(new File("/Users/atulyadav/JavaProjects/Student2.xml"));
			System.out.println("Reverse of this -> Student to XML done!!!");
			System.out.println(stu);

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
