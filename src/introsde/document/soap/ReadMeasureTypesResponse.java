
package introsde.document.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="measureType" type="{http://soap.document.introsde/}measureTypesWrapper" minOccurs="0"/>
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
    "measureType"
})
public class ReadMeasureTypesResponse {

    protected MeasureTypesWrapper measureType;

    /**
     * Recupera il valore della proprietà measureType.
     * 
     * @return
     *     possible object is
     *     {@link MeasureTypesWrapper }
     *     
     */
    public MeasureTypesWrapper getMeasureType() {
        return measureType;
    }

    /**
     * Imposta il valore della proprietà measureType.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureTypesWrapper }
     *     
     */
    public void setMeasureType(MeasureTypesWrapper value) {
        this.measureType = value;
    }

}
