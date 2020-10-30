package com.test.client;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
  private Logger LOG = LogManager.getLogger(CustomClientHttpRequestInterceptor.class);
  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
    // log the http request
    LOG.info("URI: {}", request.getURI());
    LOG.info("HTTP Method: {}", request.getMethodValue());
    LOG.info("HTTP Headers: {}", request.getHeaders());
    return execution.execute(request, body);
  }
}