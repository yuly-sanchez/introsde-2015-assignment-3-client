
package introsde.document.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per readMeasureTypesResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="readMeasureTypesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://soap.document.introsde/}measureTypes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readMeasureTypesResponse", propOrder = {
    "measureTypes"
})
public class ReadMeasureTypesResponse {

    @XmlElement(namespace = "http://soap.document.introsde/")
    protected MeasureTypesWrapper measureTypes;

    /**
     * Recupera il valore della proprietà measureTypes.
     * 
     * @return
     *     possible object is
     *     {@link MeasureTypesWrapper }
     *     
     */
    public MeasureTypesWrapper getMeasureTypes() {
        return measureTypes;
    }

    /**
     * Imposta il valore della proprietà measureTypes.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureTypesWrapper }
     *     
     */
    public void setMeasureTypes(MeasureTypesWrapper value) {
        this.measureTypes = value;
    }

}
