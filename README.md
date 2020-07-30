Running a Single Test
    mvn -Dtest=TestCircle test
    
    
mvn clean test -DsuiteXmlFile=testng.xml ********************************
    ==> this will run all the xml file mentioned in pom.xml
        <suiteXmlFiles>
           <suiteXmlFile>runner.xml</suiteXmlFile>
           <suiteXmlFile>runner_with_data_provider.xml</suiteXmlFile>
        </suiteXmlFiles>

Running a Single Test:
mvn clean test -DsuiteXmlFile=runner.xml    (example)

In order to run specific xml file: *mvn clean verify -P Parameterized -Drunner=smoketest.xml*
