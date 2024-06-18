import com.sap.gateway.ip.core.customdev.util.Message
import java.util.HashMap;
//import com.sap.it.api.ITApiFactory //CPI
//import com.sap.it.api.mapping.ValueMappingApi //CPI
import ValueMappingApi //IntelliJ

def Message processData(Message message) {

    def valueMapApi = new ValueMappingApi('value_mapping.xml') //IntelliJ
    //def valueMapApi = ITApiFactory.getApi(com.sap.it.api.mapping.ValueMappingApi.class, null) //CPI

    println "You can print and see the result in the console!"

    //Body
    def body = message.getBody();
    def root = new XmlParser().parseText(body)

    inputNumber = 'uno'
    //ValueMapping
    def number = inputNumber ? valueMapApi.getMappedValue(
            "SourceAgency", "SourceIdentifier",
            inputNumber as String,
            "DestinationAgency", "DestinationIdentifier"
    ) : ""

    println (root)
    message.setBody(root.text() + " is modified with value mapped code: " + number );
    //Properties
    value = message.getProperty("oldProperty");
    message.setProperty("oldProperty", value + "modified");
    message.setProperty("newProperty", "newProperty");
    return message;
}
