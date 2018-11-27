package com.jack.mvc.asyncs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author yangyueming
 */
@RestController
@Slf4j
public class AsyncFutureController {
    public void test() throws Exception {
        Future<String> futureResult = new AsyncTask().run();
        String result = futureResult.get(5, TimeUnit.SECONDS);
        log.info(result);
    }
}
