# SAP CPI Groovy IntelliJ Project Template

## Description

This project is a template for creating Groovy scripts for SAP CPI (Cloud Platform Integration) locally. The `value_mapping.xml` file is obtained by downloading the artifact of the value mapping from SAP Integration Suite.

## How To

1. **Install IntelliJ Community Edition**  
   Download and install [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/).

2. **Copy IntelliJSAPGroovyLibrary Directory**  
   Copy the directory `IntelliJSAPGroovyLibrary` to `C:\Program Files\JetBrains`.

3. **Open the Project in IntelliJ**  
   - Launch IntelliJ.
   - Navigate to `File > Open`.
   - Select the `TemplateCPIGroovy` project directory.

4. **Run** 
   A Run configuration called `Main` should be already present to execute `RunMain.groovy` file

## Troubleshooting

If the project cannot find the necessary libraries:

1. Go to `File > Project Structure > Libraries`.
2. Click the `+` button to add new libraries.
3. Add all libraries present in the `IntelliJSAPGroovyLibrary` directory.

If IntelliJ can't automatically detect Java JDK:

1. Go to `File > Project Structure > Project`.
2. Next to the `SDK` label, select the dropdown and click on `Download JDK...`
3. Select version `1.8` and click `Download`
---

Thank you for following the setup instructions. If you encounter any issues, please refer to the troubleshooting section or open an issue.
