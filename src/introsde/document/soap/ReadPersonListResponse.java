
package introsde.document.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per readPersonListResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="readPersonListResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://soap.document.introsde/}people" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readPersonListResponse", propOrder = {
    "people"
})
public class ReadPersonListResponse {

    @XmlElement(namespace = "http://soap.document.introsde/")
    protected PeopleWrapper people;

    /**
     * Recupera il valore della proprietà people.
     * 
     * @return
     *     possible object is
     *     {@link PeopleWrapper }
     *     
     */
    public PeopleWrapper getPeople() {
        return people;
    }

    /**
     * Imposta il valore della proprietà people.
     * 
     * @param value
     *     allowed object is
     *     {@link PeopleWrapper }
     *     
     */
    public void setPeople(PeopleWrapper value) {
        this.people = value;
    }

}
