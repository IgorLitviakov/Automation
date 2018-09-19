import utils.ConfigProperties;


//user=webinar5
//password=webinar5
//url=http://jira.hillel.it:8080/login.jsp
//chromedriver=/home/armin/Downloads/geckodriver-v0.21.0-linux64/geckodriver


public class OutputPropertyFile {
    public static void output_property_file(){
        System.out.println(ConfigProperties.getTestProperty("user") + "\n");
        System.out.println(ConfigProperties.getTestProperty("password") + "\n");
        System.out.println(ConfigProperties.getTestProperty("url") + "\n");
        System.out.println(ConfigProperties.getTestProperty("chromedriver") + "\n");
    }
}
