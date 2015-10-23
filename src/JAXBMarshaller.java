import java.io.File;
//import java.io.FileReader;
//import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
//import javax.xml.bind.Unmarshaller;

import pojos.HealthProfile;
import pojos.Person;
import pojos.PeopleStore;

//this program converts java objects into xml
public class JAXBMarshaller {  	
	public static PeopleStore people = new PeopleStore();

	public static void initializeDB() {
		Person p = new Person();
		Person st = new Person(new Long(1), "Shumet", "Tadesse", "1987-09-15");
		HealthProfile hp = new HealthProfile(68.0, 1.72,"2014-10-10");
		Person br = new Person(new Long(2), "Birtukan", "Getahun", "1991-02-16", hp);

		people.getData().add(p);
		people.getData().add(st);
		people.getData().add(br);
	}	

	public static void main(String[] args) throws Exception {
		
		initializeDB();
		
		JAXBContext jc = JAXBContext.newInstance(PeopleStore.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        m.marshal(people,new File("people.xml")); // marshalling into a file called people.xml
        m.marshal(people, System.out);			  // marshalling into the system default output
    }
}
