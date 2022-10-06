package com.desarrollo.sem.servlet;

public class ResponseMessage {

  static public String message(int code, String text) {
    return "{\"StatusCode\":" + code +", \"StatusText\":\"" + text + "\"}";
  }


  static public String message(int code, String text, String json) {
    return "{\"StatusCode\":" + code + 
      ", \"StatusText\":\"" + text + "\"" +
      ", \"data\":" + json + 
      "}";
  }

}