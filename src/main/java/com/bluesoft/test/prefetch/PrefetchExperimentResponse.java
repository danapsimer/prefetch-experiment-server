package com.bluesoft.test.prefetch;

import java.util.Date;

/**
 *
 * @author danap
 */
public class PrefetchExperimentResponse {

  private String message;
  private Date requestSent;
  private Date requestReceived;
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

  public Date getRequestSent() {
    return requestSent;
  }

  public void setRequestSent(Date requestSent) {
    this.requestSent = requestSent;
  }

  public Date getSent() {
    return sent;
  }

  public void setSent(Date sent) {
    this.sent = sent;
  }

  public Date getRequestReceived() {
    return requestReceived;
  }

  public void setRequestReceived(Date requestReceived) {
    this.requestReceived = requestReceived;
  }

  @Override
  public String toString() {
    return "PrefetchExperimentResponse{message=" + message 
            + ", requestReceived = " + requestReceived
            + ", requestSent=" + requestSent
            + ", sent=" + sent
            + ", junkPayload=" + junkPayload + '}';
  }
}
