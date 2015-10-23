//import java.io.File;
import java.io.FileReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
//import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

//import pojos.HealthProfile;
import pojos.Person;
import pojos.PeopleStore;
//import org.eclipse.persistence.jaxb.JAXBContextProperties; 

//i tried this for converting java objects to json

public class JSONJava {  	
	public static PeopleStore people = new PeopleStore();

	public static void main(String[] args) throws Exception {
		
		
		JAXBContext jc = JAXBContext.newInstance(PeopleStore.class);
        System.out.println();
        System.out.println("Output from our JSON File: ");
        Unmarshaller um = jc.createUnmarshaller();
        //um.setProperty("eclipselink.media-type", "application/json");
        PeopleStore people = (PeopleStore) um.unmarshal(new FileReader("people.json"));
        List<Person> list = people.getData();
        for (Person person : list) {
          System.out.println("Person: " + person.getFirstname()+" "+ person.getLastname()+ " born "
              + person.getBirthdate()+" and Health Profile:"+person.getHProfile());
        }

    }
}
