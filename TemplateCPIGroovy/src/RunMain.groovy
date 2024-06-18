import com.sap.gateway.ip.core.customdev.processor.MessageImpl
import com.sap.gateway.ip.core.customdev.util.Message
import org.apache.camel.CamelContext
import org.apache.camel.Exchange
import org.apache.camel.impl.DefaultCamelContext
import org.apache.camel.impl.DefaultExchange

// Load Groovy Script
GroovyShell shell = new GroovyShell()
def script = shell.parse(new File("ProcessData.groovy"))

// Initialize message with body, header and property
Message msg
Exchange exchange

CamelContext context = new DefaultCamelContext()
exchange = new DefaultExchange(context)
msg = new MessageImpl(exchange)

def inFile = new File("IN-Body.xml")


msg.setBody(inFile.text)
msg.setProperty("oldProperty", "TestProperty")

script.processData(msg)


new File("OUT-Body.xml").write(msg.getBody())
