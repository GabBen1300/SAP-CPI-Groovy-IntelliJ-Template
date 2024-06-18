class ValueMappingApi {

    private vmXml

    ValueMappingApi(String filename) {
        def xmlString = new File(filename).text
        vmXml = new XmlSlurper().parseText(xmlString)
    }

    String getMappedValue(String sourceAgency, String sourceIdentifier, String sourceValue, String targetAgency, String targetIdentifier) {

        def groups = vmXml.group.findAll { group ->
            group.entry.find { entry ->
                entry.agency.text() == sourceAgency && entry.schema.text() == sourceIdentifier && entry.value.text() == sourceValue
            }
        }

        if (groups.size() > 0) {
            def targetEntry = groups[0].entry.find { entry ->
                entry.agency.text() == targetAgency && entry.schema.text() == targetIdentifier
            }

            if (targetEntry) {
                return targetEntry.value.text()
            }
        }

        return ""
    }
}