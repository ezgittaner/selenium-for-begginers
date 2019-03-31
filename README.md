# selenium-for-begginers

for auxiliary documents http://testng.org/doc/documentation-main.html

```xml
pom.xml

<dependency> for chrome <!-- https://mvnrepository.com/artifact/org.seleniumhq.webdriver/webdriver-chrome -->
<dependency> for testng <!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency> for selenium	<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->

maven compiler plugin  <!--http://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html-->
maven surfire plugin Using Suite XML Files <!--http://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html-->
```

```java
/** Static sleep */
private void sleep(long millis) {
    try {
        Thread.sleep(millis);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
```
