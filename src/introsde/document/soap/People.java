
package introsde.document.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "People", targetNamespace = "http://soap.document.introsde/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface People {


    /**
     * 
     * @param personId
     * @return
     *     returns introsde.document.soap.Person
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "http://soap.document.introsde/")
    @RequestWrapper(localName = "readPerson", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.ReadPerson")
    @ResponseWrapper(localName = "readPersonResponse", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.ReadPersonResponse")
    @Action(input = "http://soap.document.introsde/People/readPersonRequest", output = "http://soap.document.introsde/People/readPersonResponse")
    public Person readPerson(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId);

    /**
     * 
     * @param person
     * @return
     *     returns java.lang.Long
     */
    @WebMethod
    @WebResult(name = "personId", targetNamespace = "")
    @RequestWrapper(localName = "updatePerson", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.UpdatePerson")
    @ResponseWrapper(localName = "updatePersonResponse", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.UpdatePersonResponse")
    @Action(input = "http://soap.document.introsde/People/updatePersonRequest", output = "http://soap.document.introsde/People/updatePersonResponse")
    public Long updatePerson(
        @WebParam(name = "person", targetNamespace = "http://soap.document.introsde/")
        Person person);

    /**
     * 
     * @return
     *     returns introsde.document.soap.PeopleWrapper
     */
    @WebMethod
    @WebResult(name = "people", targetNamespace = "http://soap.document.introsde/")
    @RequestWrapper(localName = "readPersonList", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.ReadPersonList")
    @ResponseWrapper(localName = "readPersonListResponse", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.ReadPersonListResponse")
    @Action(input = "http://soap.document.introsde/People/readPersonListRequest", output = "http://soap.document.introsde/People/readPersonListResponse")
    public PeopleWrapper readPersonList();

    /**
     * 
     * @param personId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "message", targetNamespace = "")
    @RequestWrapper(localName = "deletePerson", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.DeletePerson")
    @ResponseWrapper(localName = "deletePersonResponse", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.DeletePersonResponse")
    @Action(input = "http://soap.document.introsde/People/deletePersonRequest", output = "http://soap.document.introsde/People/deletePersonResponse")
    public String deletePerson(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId);

    /**
     * 
     * @param person
     * @return
     *     returns java.lang.Long
     */
    @WebMethod
    @WebResult(name = "personId", targetNamespace = "")
    @RequestWrapper(localName = "createPerson", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.CreatePerson")
    @ResponseWrapper(localName = "createPersonResponse", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.CreatePersonResponse")
    @Action(input = "http://soap.document.introsde/People/createPersonRequest", output = "http://soap.document.introsde/People/createPersonResponse")
    public Long createPerson(
        @WebParam(name = "person", targetNamespace = "http://soap.document.introsde/")
        Person person);

    /**
     * 
     * @param personId
     * @param measureType
     * @return
     *     returns introsde.document.soap.HealthHistoryWrapper
     */
    @WebMethod
    @WebResult(name = "healthProfile-history", targetNamespace = "http://soap.document.introsde/")
    @RequestWrapper(localName = "readPersonHistory", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.ReadPersonHistory")
    @ResponseWrapper(localName = "readPersonHistoryResponse", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.ReadPersonHistoryResponse")
    @Action(input = "http://soap.document.introsde/People/readPersonHistoryRequest", output = "http://soap.document.introsde/People/readPersonHistoryResponse")
    public HealthHistoryWrapper readPersonHistory(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "measureType", targetNamespace = "")
        String measureType);

    /**
     * 
     * @return
     *     returns introsde.document.soap.MeasureTypesWrapper
     */
    @WebMethod
    @WebResult(name = "measureTypes", targetNamespace = "http://soap.document.introsde/")
    @RequestWrapper(localName = "readMeasureTypes", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.ReadMeasureTypes")
    @ResponseWrapper(localName = "readMeasureTypesResponse", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.ReadMeasureTypesResponse")
    @Action(input = "http://soap.document.introsde/People/readMeasureTypesRequest", output = "http://soap.document.introsde/People/readMeasureTypesResponse")
    public MeasureTypesWrapper readMeasureTypes();

    /**
     * 
     * @param mid
     * @param personId
     * @param measureType
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "measure", targetNamespace = "")
    @RequestWrapper(localName = "readPersonMeasure", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.ReadPersonMeasure")
    @ResponseWrapper(localName = "readPersonMeasureResponse", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.ReadPersonMeasureResponse")
    @Action(input = "http://soap.document.introsde/People/readPersonMeasureRequest", output = "http://soap.document.introsde/People/readPersonMeasureResponse")
    public String readPersonMeasure(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "measureType", targetNamespace = "")
        String measureType,
        @WebParam(name = "mid", targetNamespace = "")
        Long mid);

    /**
     * 
     * @param measure
     * @param personId
     * @return
     *     returns java.lang.Long
     */
    @WebMethod
    @WebResult(name = "mid", targetNamespace = "")
    @RequestWrapper(localName = "savePersonMeasure", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.SavePersonMeasure")
    @ResponseWrapper(localName = "savePersonMeasureResponse", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.SavePersonMeasureResponse")
    @Action(input = "http://soap.document.introsde/People/savePersonMeasureRequest", output = "http://soap.document.introsde/People/savePersonMeasureResponse")
    public Long savePersonMeasure(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "measure", targetNamespace = "http://soap.document.introsde/")
        Measure measure);

    /**
     * 
     * @param measure
     * @param mid
     * @param personId
     */
    @WebMethod
    @RequestWrapper(localName = "updatePersonMeasure", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.UpdatePersonMeasure")
    @ResponseWrapper(localName = "updatePersonMeasureResponse", targetNamespace = "http://soap.document.introsde/", className = "introsde.document.soap.UpdatePersonMeasureResponse")
    @Action(input = "http://soap.document.introsde/People/updatePersonMeasureRequest", output = "http://soap.document.introsde/People/updatePersonMeasureResponse")
    public void updatePersonMeasure(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId,
        @WebParam(name = "measure", targetNamespace = "http://soap.document.introsde/")
        Measure measure,
        @WebParam(name = "mid", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<Long> mid);

}