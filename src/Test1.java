import com.service.Datesource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void testProperties() {
        ApplicationContext applicationContext = null;
        //applicationContext = new ClassPathXmlApplicationContext("beans1.xml");
        applicationContext  = new AnnotationConfigApplicationContext("com.config");
        Datesource datasource = applicationContext.getBean("datesource", Datesource.class);
        System.out.println(datasource.toString());
    }
}
