package introsde.document.client;

import introsde.document.soap.*;
import introsde.document.soap.Person.CurrentHealth;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;
import java.util.UUID;

import javax.xml.namespace.QName;
import javax.xml.ws.Holder;
import javax.xml.ws.Service;

public class TestClient {


	public static void main(String[] args) throws Exception {
		// My server local
		// final String MY_LOCAL_SERVER = "http://127.0.1.1:6902";

		// My server that should be deployed on Heroku
		String MY_HEROKU_SERVER = "https://agile-shelf-1769.herokuapp.com";
		String BASE_URL = "/soap/people";
		String endpointUrl = MY_HEROKU_SERVER + BASE_URL;
		
		System.out.println("Starting People Service...");
		System.out.println("Published on " + endpointUrl + "?wsdl"
				+ "\n[kill the process to exit]");

		// 1st argument service URI, refer to wsdl document above
		URL url = new URL(endpointUrl + "?wsdl");

		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://soap.document.introsde/",
				"PeopleService");

		String mediaType = "text/xml";
		
		Service service = Service.create(url, qname);

		FileOutputStream fos = new FileOutputStream(new File("output.txt"),true);
		service.setHandlerResolver(new JaxWsHandlerResolver(fos));
		People people = service.getPort(People.class);

		try {
			templateRequest(1, "POST", mediaType);
			PeopleWrapper peopleList = people.readPersonList(); //people.readPersonList().getPerson();
			Long first_personId = peopleList.getPerson().get(0).getPersonId();
			Long last_personId = peopleList.getPerson().get(peopleList.getPerson().size()-1).getPersonId();
			System.out.println("First personId: " + first_personId);
			System.out.println("Last personId: " + last_personId);
			
			
			templateRequest(2, "POST", mediaType);
			Person targetRequest2 = people.readPerson(first_personId);  
			String measureType = "weight"; //targetRequest2.getCurrentHealth().getMeasure().get(0).getMeasureType();
			
			//templateRequest(3, "PUT", mediaType);
			//Person personToUpdate = targetRequest2;
	        //personToUpdate.setFirstname("Chuck");
			//personToUpdate.setLastname("Norris");
			//people.updatePerson(personToUpdate);
	       	
			//templateRequest(4, "POST", mediaType);
			//Person personToCreate = new Person();
			//personToCreate.setBirthdate("1978-04-23");
			//personToCreate.setFirstname("Andrea");
			//personToCreate.setLastname("Llanos");
			//Long personToCreateId = people.createPerson(personToCreate);
			//System.out.println("Person id: " + personToCreateId);
			
			templateRequest(5, "DELETE", mediaType);
			people.deletePerson(last_personId);
			
			templateRequest(6, "POST", mediaType);
			HealthHistoryWrapper personHistoryList = people.readPersonHistory(first_personId, measureType);
			String measure_Type = personHistoryList.getMeasure().get(0).getMeasureType();
			Long mid = personHistoryList.getMeasure().get(0).getMid();
			System.out.println("Measure type: " + measure_Type);
			System.out.println("Mid: " + mid);
			
			templateRequest(7, "POST", mediaType);
			MeasureTypesWrapper measureTypesList = people.readMeasureTypes();
			
			templateRequest(8, "POST", mediaType);
			people.readPersonMeasure(first_personId, measure_Type, mid);
			
			//templateRequest(9, "POST", mediaType);
			//Measure measureToCreate = new Measure();
			//measureToCreate.setMeasureType("weight");
			//measureToCreate.setMeasureValue("45.7");
			//measureToCreate.setMeasureValueType("Double");
			//people.savePersonMeasure(first_personId, measureToCreate);
			
			templateRequest(10, "PUT", mediaType);
			Measure measureToUpdate = new Measure(); //personHistoryList.getMeasure().get(0);
			measureToUpdate.setMeasureValue("45");
			Holder<Long> idMeasure = new Holder<Long>(mid);
			people.updatePersonMeasure(first_personId, measureToUpdate, idMeasure);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @param numberRequest
	 * @param method
	 * @param mediaType
	 */
	public static void templateRequest(int numberRequest, String method,
			String mediaType) {
		mediaType = mediaType.toUpperCase();
		System.out
				.println("======================================================================================================");
		System.out.println("Method #" + numberRequest + ": " + method + " "
				+ "Accept: " + mediaType + " " + "Content-Type: " + mediaType);
		System.out.println();
	}

}
