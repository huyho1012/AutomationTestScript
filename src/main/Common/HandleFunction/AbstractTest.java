package Common.HandleFunction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Random;

public abstract class AbstractTest {

    protected final Log log;
    protected AbstractTest(){
        log = LogFactory.getLog(getClass());
    }

    protected String randomVirtualEmail(){
        String email;
        String userName = "huyho";
        String domainEmail = "@mailinator.com";
        Random random = new Random();
        return  email = "huyho"+ random.nextInt(2000) + domainEmail;
    }
}
