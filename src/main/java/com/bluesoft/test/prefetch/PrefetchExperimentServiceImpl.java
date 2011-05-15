package com.bluesoft.test.prefetch;

import java.util.Date;
import java.util.Random;
import javax.jws.WebService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author danap
 */
@WebService(endpointInterface = "com.bluesoft.test.prefetch.PrefetchExperimentService")
public class PrefetchExperimentServiceImpl implements PrefetchExperimentService {

  private static final org.slf4j.Logger sLogger = org.slf4j.LoggerFactory.getLogger(PrefetchExperimentServiceImpl.class);
  private Random random;

  public PrefetchExperimentServiceImpl() {
    random = new Random(new Date().getTime());
  }

  @Override
  public PrefetchExperimentResponse ping(PrefetchExperimentRequest request) {
    sLogger.debug("in ping: request = {}", request);
    PrefetchExperimentResponse response = new PrefetchExperimentResponse();
    try {
      response.setRequestReceived(new Date());
      response.setMessage(request.getMessage());
      response.setRequestSent(request.getSent());
      response.setJunkPayload(randomString(1000 + random.nextInt(10000)));
      try {
        Thread.sleep(200L + random.nextInt(800));
      } catch (InterruptedException ex) {
        // ignore it.
      }
      response.setSent(new Date());
      return response;
    } finally {
      sLogger.debug("out ping: response = {}", response);
    }
  }

  private String randomString(int length) {
    StringBuilder string = new StringBuilder(length);
    for (int c = 0; c < length; c++) {
      string.append((char)(32+random.nextInt(95)));
    }
    return string.toString();
  }


  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    final PrefetchExperimentServiceImpl self = context.getBean(PrefetchExperimentServiceImpl.class);
    Runtime.getRuntime().addShutdownHook(new Thread() {

      @Override
      public void run() {
        synchronized (self) {
          self.notifyAll();
        }
      }
    });
    context.start();
    sLogger.info("Service started.");
    try {
      synchronized (self) {
        self.wait();
      }
      context.stop();
    } catch (InterruptedException ex) {
      // Ignore
    }
    sLogger.info("Service terminating...");
    context.close();
    sLogger.info("Service terminated.");
    System.exit(0);
  }
}
