// Source code is decompiled from a .class file using FernFlower decompiler.
package com.desarrollo.sem.servlet;

class EmailRequest {
   private String[] recipients;
   private String subject;
   private String body;

   EmailRequest() {
   }

   public String[] getRecipients() {
      return this.recipients;
   }

   public void setRecipients(String[] recipients) {
      this.recipients = recipients;
   }

   public String getSubject() {
      return this.subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }

   public String getBody() {
      return this.body;
   }

   public void setBody(String body) {
      this.body = body;
   }
}