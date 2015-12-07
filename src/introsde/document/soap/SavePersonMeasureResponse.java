
package introsde.document.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per savePersonMeasureResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="savePersonMeasureResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="measure" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "savePersonMeasureResponse", propOrder = {
    "measure"
})
public class SavePersonMeasureResponse {

    protected Long measure;

    /**
     * Recupera il valore della proprietà measure.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMeasure() {
        return measure;
    }

    /**
     * Imposta il valore della proprietà measure.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMeasure(Long value) {
        this.measure = value;
    }

}
