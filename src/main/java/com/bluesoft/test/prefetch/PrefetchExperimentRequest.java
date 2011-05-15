package com.bluesoft.test.prefetch;

import java.util.Date;

/**
 *
 * @author danap
 */
public class PrefetchExperimentRequest {

  private String message;
  private Date sent;
  private String junkPayload;

  public String getJunkPayload() {
    return junkPayload;
  }

  public void setJunkPayload(String junkPayload) {
    this.junkPayload = junkPayload;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Date getSent() {
    return sent;
  }

  public void setSent(Date sent) {
    this.sent = sent;
  }

  @Override
  public String toString() {
    return "PrefetchExperimentRequest{message=" + message + ", sent=" + sent + ", junkPayload=" + junkPayload + '}';
  }
}
