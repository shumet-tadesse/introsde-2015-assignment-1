import java.io.File;

//this file is used for converting java objects into json

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import pojos.HealthProfile;
import pojos.Person;
import pojos.PeopleStore;
public class JavaJSON {  	
	public static PeopleStore people = new PeopleStore();

	public static void initializeDB() {
		Person pallino = new Person();
		Person ket = new Person(new Long(1), "Ketemaw", "Getachew", "1984-06-21");
		HealthProfile hp = new HealthProfile(68.0, 1.72,"2014-10-09");
		Person bam = new Person(new Long(2), "Bamlaku", "Desalegn", "1985-03-20", hp);
		HealthProfile hp2=new HealthProfile(65.0,1.65,"2014-10-10");
		Person st=new Person (new Long(3),"Shumet","Tadesse","1987-09-15",hp2);

		people.getData().add(pallino);
		people.getData().add(ket);
		people.getData().add(bam);
		people.getData().add(st);
	}	

	public static void main(String[] args) throws Exception {
		
		initializeDB();
		
		// Jackson Object Mapper 
		ObjectMapper mapper = new ObjectMapper();
		
		// Adding the Jackson Module to process JAXB annotations
        JaxbAnnotationModule module = new JaxbAnnotationModule();
        
		// configure as necessary
		mapper.registerModule(module);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

        String result = mapper.writeValueAsString(people);
        System.out.println(result);
        mapper.writeValue(new File("people.json"), people);
    }
}
