package Common.HandleFunction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public abstract class AbstractTest {

    protected final Log log;
    protected AbstractTest(){
        log = LogFactory.getLog(getClass());
    }

}
