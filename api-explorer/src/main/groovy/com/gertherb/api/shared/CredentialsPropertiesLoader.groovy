package com.gertherb.api.shared

class CredentialsPropertiesLoader {

    private final ArrayList<String> propertiesNeeded
    private final String propertiesPath

    CredentialsPropertiesLoader(String propertiesPath, ArrayList<String> propertiesNeeded) {
        this.propertiesNeeded = propertiesNeeded
        this.propertiesPath = propertiesPath
    }

    Properties load() {
        File file = getPropertiesFile()
        Properties properties = loadProperties(file)
        checkPropertiesAreValid(properties)
        return properties
    }


    private Properties loadProperties(File file) {
        Properties properties = new Properties();
        properties.load(new FileInputStream(file))
        return properties
    }

    private File getPropertiesFile() {
        File file = new File(propertiesPath);
        if (!file.exists()) {
            throw new InvalidCredentialsException("You need to put a property file containing the credentials needed for the app in ${propertiesPath}")
        }
        return file
    }

    private void checkPropertiesAreValid(Properties properties) {
        propertiesNeeded.collect {
            if (!properties.containsKey(it)) {
                throw new InvalidCredentialsException("'${it}' property is not defined in ${propertiesPath}")
            }
            if (!properties.getProperty(it)) {
                throw new InvalidCredentialsException("No value is defined for '${it}' in ${propertiesPath}")
            }
        }
    }


    void save(String property, value) {
        File file = getPropertiesFile()
        Properties properties = loadProperties(file)
        properties.put(property, value)
        properties.store(new FileWriter(file), "")
    }


}