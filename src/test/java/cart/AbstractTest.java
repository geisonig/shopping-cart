package cart;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@EnableAutoConfiguration
public abstract class AbstractTest {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	

}
