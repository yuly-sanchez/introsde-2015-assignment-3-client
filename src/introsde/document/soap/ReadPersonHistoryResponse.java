
package introsde.document.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per readPersonHistoryResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="readPersonHistoryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://soap.document.introsde/}healthProfile-history" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readPersonHistoryResponse", propOrder = {
    "healthProfileHistory"
})
public class ReadPersonHistoryResponse {

    @XmlElement(name = "healthProfile-history", namespace = "http://soap.document.introsde/")
    protected HealthHistoryWrapper healthProfileHistory;

    /**
     * Recupera il valore della proprietà healthProfileHistory.
     * 
     * @return
     *     possible object is
     *     {@link HealthHistoryWrapper }
     *     
     */
    public HealthHistoryWrapper getHealthProfileHistory() {
        return healthProfileHistory;
    }

    /**
     * Imposta il valore della proprietà healthProfileHistory.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthHistoryWrapper }
     *     
     */
    public void setHealthProfileHistory(HealthHistoryWrapper value) {
        this.healthProfileHistory = value;
    }

}
