package com.test.client;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class CustomClientErrorHandler implements ResponseErrorHandler {
	
  private final Logger LOG = LogManager.getLogger(CustomClientErrorHandler.class);
  
  @Override
  public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
    return clientHttpResponse.getStatusCode().is4xxClientError();
  }
  
  @Override
  public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
    LOG.error("HTTP Status Code: " + clientHttpResponse.getStatusCode().value());
  }
}