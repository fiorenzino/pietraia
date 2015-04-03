package org.angcms.core.util;

import org.angcms.api.management.AppProperties;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class WebTargetClosable implements AutoCloseable
{
   public WebTarget webTarget;
   private Client client;
   public Response response;

   public WebTargetClosable()
   {

   }

   /*
    * targetHost + targetPath togheter
    */
   public WebTargetClosable(String targetHostPath) throws Exception
   {
      if (targetHostPath == null || targetHostPath.trim().isEmpty())
         throw new Exception("targetHostPath is null");
      client = new ResteasyClientBuilder().disableTrustManager()
               .build();
      webTarget = client.target(targetHostPath);
   }

   /*
    * if targetHost is null or empty, we use AppProperties.baseUrl
    */
   public WebTargetClosable(String targetHost, String targetPath) throws Exception
   {
      if (targetPath == null || targetPath.trim().isEmpty())
         throw new Exception("targetPath is null");
      client = new ResteasyClientBuilder().disableTrustManager()
               .build();
      if (targetHost == null || targetHost.isEmpty())
         targetHost = AppProperties.baseUrl.value();
      webTarget = client.target(targetHost + targetPath);
   }

   @Override
   public void close() throws Exception
   {
      // System.out.println("WebTargetClosable CLOSE");
      if (response != null)
      {
         response.close();
      }
      if (client != null)
      {
         client.close();
      }
   }

}
