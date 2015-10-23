//import java.io.File;
import java.io.FileReader;
import java.util.List;
import javax.xml.bind.JAXBContext;
//import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

//import pojos.HealthProfile;
import pojos.Person;
import pojos.PeopleStore;

//this file is used to convert from xml into java object

public class JAXBUnMarshaller {  	
	public static PeopleStore people = new PeopleStore();

	public static void main(String[] args) throws Exception {
		JAXBContext jc = JAXBContext.newInstance(PeopleStore.class);
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = jc.createUnmarshaller();
        PeopleStore people = (PeopleStore) um.unmarshal(new FileReader("people.xml"));
        List<Person> list = people.getData();
        for (Person person : list) {
          System.out.println("Person: " + person.getFirstname()+" "+ person.getLastname()+ " born "
              + person.getBirthdate()+" and Health Profile:"+person.getHProfile());
        }

    }
}
