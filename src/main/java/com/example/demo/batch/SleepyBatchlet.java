package com.example.demo.batch;


import org.springframework.stereotype.Component;

import javax.batch.api.AbstractBatchlet;

@Component
public class SleepyBatchlet extends AbstractBatchlet {


//@Inject
//@BatchProperty(name = "sleep.time.seconds")
//String sleepTimeSecondsProperty;
private int sleepTime_s = 3;

//@Inject
//private JschFileUtil jschFileUtil;

@Override
public String process() throws Exception {

        System.out.println("Test");
        return "exitStatus";
        }

/**
 * Called if the batchlet is stopped by the container.
 */
@Override
public void stop() throws Exception {
    System.out.println("stop");

}

}
