package introsde.document.client;

import introsde.document.soap.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.Service;

public class PeopleClient {

	private URL url;
	private QName qname;
	private People people;

	SOAPConnectionFactory soapConnectionFactory;
	SOAPConnection soapConnection;

	SOAPMessage soapMessage = null;
	SOAPBody soapBody = null;

	final String ENVELOPE_NAMESPACE = "http://schemas.xmlsoap.org/soap/envelope/";
	final String ENVELOPE_NAMESPACE_TAG = "soap";
	final String ENCODING_NAMESPACE = "http://www.w3.org/2001/12/soap-encoding";

	final String BODY_NAMESPACE = "http://soap.document.introsde/";
	final String BODY_NAMESPACE_TAG = "m";

	String mediaType = "text/xml";

	Long first_personId;
	Long last_personId;
	String measure_type;
	Long measureId;

	public PeopleClient(String endpointUrl) throws Exception {
		// My server local
		// final String MY_LOCAL_SERVER = "http://127.0.1.1:6902";

		// My server that should be deployed on Heroku
		//String MY_HEROKU_SERVER = "https://agile-shelf-1769.herokuapp.com";
		//String BASE_URL = "/soap/people";
		//String endpointUrl = MY_HEROKU_SERVER + BASE_URL + "?wsdl";

		System.out.println("Starting People Service...");
		System.out.println("**STEP 1**");
		System.out.println("WSDL url " + endpointUrl
				+ "\n[kill the process to exit]");

		// 1st argument service URI, refer to wsdl document above
		url = new URL(endpointUrl);

		// 2nd argument is service name, refer to wsdl document above
		qname = new QName("http://soap.document.introsde/", "PeopleService");

		Service service = Service.create(url, qname);

		FileOutputStream fos = new FileOutputStream(new File("output.txt"),
				true);
		service.setHandlerResolver(new JaxWsHandlerResolver(fos));
		people = service.getPort(People.class);

		// Create SOAP Connection
		soapConnectionFactory = SOAPConnectionFactory.newInstance();
		soapConnection = soapConnectionFactory.createConnection();
	}

	public static void main(String[] args) throws Exception {
		if (args.length < 1)
			System.out.println("Error: insert server url");
		
		else {

			try {

				PeopleClient c = new PeopleClient(args[0]);
				System.out.println("**STEP 2*");
				c.request_1();
				c.request_2();

				SOAPMessage soapResponse3 = c.soapConnection.call(
						c.request_3(), c.url);
				System.out.println("INBOUND MESSAGE\n");
				System.out.println(getSOAPMessageAsString(soapResponse3));

				SOAPMessage soapResponse4 = c.soapConnection.call(
						c.request_4(), c.url);
				System.out.println("INBOUND MESSAGE\n");
				System.out.println(getSOAPMessageAsString(soapResponse4));

				c.request_5();
				c.request_7();
				c.request_6();
				c.request_8();

				SOAPMessage soapResponse9 = c.soapConnection.call(
						c.request_9(), c.url);
				System.out.println("INBOUND MESSAGE\n");
				System.out.println(getSOAPMessageAsString(soapResponse9));

				SOAPMessage soapResponse10 = c.soapConnection.call(
						c.request_10(), c.url);
				System.out.println("INBOUND MESSAGE\n");
				System.out.println(getSOAPMessageAsString(soapResponse10));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void request_1() {
		templateRequest(1, "POST", mediaType);
		PeopleWrapper peopleList = people.readPersonList();

		first_personId = peopleList.getPerson().get(0).getPersonId();
		last_personId = peopleList.getPerson()
				.get(peopleList.getPerson().size() - 1).getPersonId();
		System.out.println("First personId: " + first_personId);
		System.out.println("Last personId: " + last_personId);
	}

	public void request_2() {
		templateRequest(2, "POST", mediaType);
		people.readPerson(first_personId);
	}

	public SOAPMessage request_3() {
		String method_3 = "updatePerson";
		String arg0 = "person";
		String arg1 = "personId";
		String arg2 = "firstname";
		String arg3 = "lastname";
		try {
			createSOAPRequest();
			SOAPElement updatePerson = soapBody.addChildElement(method_3,
					BODY_NAMESPACE_TAG);

			SOAPElement person = updatePerson.addChildElement(arg0);

			SOAPElement personId = person.addChildElement(arg1);
			personId.addTextNode(String.valueOf(last_personId));

			SOAPElement firstname = person.addChildElement(arg2);
			firstname.addTextNode("Pallo");

			SOAPElement lastname = person.addChildElement(arg3);
			lastname.addTextNode("Pinco");

			person.addChildElement(personId);
			person.addChildElement(firstname);
			person.addChildElement(lastname);

			soapMessage.saveChanges();

			/* Print the request message */
			templateRequest(3, "PUT", mediaType);
			System.out.println("OUTBOUND MESSAGE\n");
			System.out.println(getSOAPMessageAsString(soapMessage));
			System.out.println();

			return soapMessage;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		// This is the implementation of the updatePerson method with classes
		// generated
		// templateRequest(3, "PUT", mediaType);
		// Person personToUpdate = targetRequest2;
		// personToUpdate.setFirstname("Chuck");
		// personToUpdate.setLastname("Norris");
		// people.updatePerson(personToUpdate);
	}

	public SOAPMessage request_4() {

		SOAPElement createPerson = null;
		String method_4 = "createPerson";
		String arg0 = "person";
		String arg1 = "firstname";
		String arg2 = "lastname";
		String arg3 = "birthdate";

		try {
			createSOAPRequest();
			createPerson = soapBody.addChildElement(method_4,
					BODY_NAMESPACE_TAG);

			SOAPElement person = createPerson.addChildElement(arg0);

			SOAPElement firstname = person.addChildElement(arg1);
			firstname.addTextNode("Test");

			SOAPElement lastname = person.addChildElement(arg2);
			lastname.addTextNode("Prova");

			SOAPElement birthdate = person.addChildElement(arg3);
			birthdate.addTextNode("1999-02-03");

			person.addChildElement(firstname);
			person.addChildElement(lastname);
			person.addChildElement(birthdate);

			soapMessage.saveChanges();

			/* Print the request message */
			templateRequest(4, "POST", mediaType);
			System.out.println("OUTBOUND MESSAGE\n");
			System.out.println(getSOAPMessageAsString(soapMessage));
			System.out.println();

			return soapMessage;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		// templateRequest(4, "POST", mediaType);
		// Person personToCreate = new Person();
		// personToCreate.setBirthdate("1978-04-23");
		// personToCreate.setFirstname("Andrea");
		// personToCreate.setLastname("Llanos");
		// Long personToCreateId = people.createPerson(personToCreate);
		// System.out.println("Person id: " + personToCreateId);
	}

	public void request_5() {
		templateRequest(5, "DELETE", mediaType);
		people.deletePerson(last_personId);
	}

	public void request_7() {
		templateRequest(7, "POST", mediaType);
		MeasureTypesWrapper measureTypesList = people.readMeasureTypes();
		measure_type = measureTypesList.getMeasureType().get(0);
		System.out.println("Measure Type: " + measure_type);
	}

	public void request_6() {
		templateRequest(6, "POST", mediaType);
		HealthHistoryWrapper personHistoryList = people.readPersonHistory(
				first_personId, measure_type);
		measureId = personHistoryList.getMeasure().get(0).getMid();
		System.out.println("Mid: " + measureId);
	}

	public void request_8() {
		templateRequest(8, "POST", mediaType);
		people.readPersonMeasure(first_personId, measure_type, measureId);
	}

	public SOAPMessage request_9() {
		/**
		 * <m:savePersonMeasure> <personId>1</personId> <measure>
		 * <measureType>height</measureType> <measureValue>60</measureValue>
		 * <measureValueType>Double</measureValueType> </measure>
		 * </m:savePersonMeasure>
		 */

		SOAPElement savePersonMeasure = null;
		String method_9 = "savePersonMeasure";
		String arg0 = "personId";
		String arg1 = "measure";
		String arg2 = "measureType";
		String arg3 = "measureValue";
		String arg4 = "measureValueType";

		try {
			createSOAPRequest();
			savePersonMeasure = soapBody.addChildElement(method_9,
					BODY_NAMESPACE_TAG);

			SOAPElement personId = savePersonMeasure.addChildElement(arg0);
			personId.addTextNode(String.valueOf(first_personId));

			SOAPElement measure = savePersonMeasure.addChildElement(arg1);

			SOAPElement measureType = measure.addChildElement(arg2);
			measureType.addTextNode(measure_type);

			SOAPElement measureValue = measure.addChildElement(arg3);
			measureValue.addTextNode("1.75");

			SOAPElement measureValueType = measure.addChildElement(arg4);
			measureValueType.addTextNode("Double");

			soapMessage.saveChanges();

			/* Print the request message */
			templateRequest(9, "POST", mediaType);
			System.out.println("OUTBOUND MESSAGE\n");
			System.out.println(getSOAPMessageAsString(soapMessage));
			System.out.println();

			return soapMessage;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		// templateRequest(9, "POST", mediaType);
		// Measure measureToCreate = new Measure();
		// measureToCreate.setMeasureType("weight");
		// measureToCreate.setMeasureValue("45.7");
		// measureToCreate.setMeasureValueType("Double");
		// people.savePersonMeasure(first_personId, measureToCreate);

	}

	public SOAPMessage request_10() {
		/**
		 * <m:updatePersonMeasure> <personId>1</personId> <measure>
		 * <measureType>height</measureType> <measureValue>45.6</measureValue>
		 * <measureValueType>Double</measureValueType> </measure> <mid>634</mid>
		 * </m:updatePersonMeasure>
		 */

		SOAPElement updatePersonMeasure = null;
		String method_10 = "updatePersonMeasure";
		String arg0 = "personId";
		String arg1 = "measure";
		String arg2 = "measureType";
		String arg3 = "measureValue";
		String arg4 = "measureValueType";
		String arg5 = "mid";

		try {
			createSOAPRequest();
			updatePersonMeasure = soapBody.addChildElement(method_10,
					BODY_NAMESPACE_TAG);

			SOAPElement personId = updatePersonMeasure.addChildElement(arg0);
			personId.addTextNode(String.valueOf(first_personId));

			SOAPElement measure = updatePersonMeasure.addChildElement(arg1);

			SOAPElement measureType = measure.addChildElement(arg2);
			measureType.addTextNode(measure_type);

			SOAPElement measureValue = measure.addChildElement(arg3);
			measureValue.addTextNode("1.47");

			SOAPElement measureValueType = measure.addChildElement(arg4);
			measureValueType.addTextNode("Double");

			SOAPElement mid = updatePersonMeasure.addChildElement(arg5);
			mid.addTextNode(String.valueOf(measureId));

			soapMessage.saveChanges();

			/* Print the request message */
			templateRequest(10, "PUT", mediaType);
			System.out.println("OUTBOUND MESSAGE\n");
			System.out.println(getSOAPMessageAsString(soapMessage));
			System.out.println();

			return soapMessage;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

		// templateRequest(10, "PUT", mediaType);
		// Measure measureToUpdate = new Measure(); //
		// personHistoryList.getMeasure().get(0);
		// measureToUpdate.setMeasureValue("45");
		// Holder<Measure> measureH = new Holder<Measure>(measureToUpdate);
		// people.updatePersonMeasure(first_personId, measureToUpdate,mid);

	}

	public void createSOAPRequest() throws Exception {
		// Create message
		MessageFactory messageFactory = MessageFactory.newInstance();
		soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		//envelope.addNamespaceDeclaration(ENVELOPE_NAMESPACE_TAG,ENVELOPE_NAMESPACE);
		envelope.setEncodingStyle(ENCODING_NAMESPACE);

		// SOAP Body
		soapBody = envelope.getBody();
		soapBody.addNamespaceDeclaration(BODY_NAMESPACE_TAG, BODY_NAMESPACE);
	}

	public static String getSOAPMessageAsString(SOAPMessage soapMessage) {
		try {

			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();

			// Set formatting

			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount",
					"2");

			Source sc = soapMessage.getSOAPPart().getContent();

			ByteArrayOutputStream streamOut = new ByteArrayOutputStream();
			StreamResult result = new StreamResult(streamOut);
			tf.transform(sc, result);

			String strMessage = streamOut.toString();
			return strMessage;
		} catch (Exception e) {
			System.out.println("Exception in getSOAPMessageAsString "
					+ e.getMessage());
			return null;
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
