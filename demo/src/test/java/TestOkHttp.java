import com.jack.demo.DemoApplication;
import com.jack.demo.utils.OkHttpUtil;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>Description:</p>
 * <pre></pre>
 * <p>Company: jack</p>
 *
 * @author yangyueming
 * @date 2017/9/22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TestOkHttp {

    @Test
    public void mockUserService() {
        try {
            String result = OkHttpUtil.run("https://www.baidu.com/");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
