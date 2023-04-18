package com.staj.proje.context;

import com.staj.proje.entity.User;
import lombok.Data;

import java.net.InetAddress;

public@Data class RequestContext {

    private User user;
    private String ipAdress;

   public  RequestContext(){

       InetAddress ip;
       try {

           ip = InetAddress.getLocalHost();

           this.ipAdress= ip.getHostAddress();

       } catch (Exception e) {

           System.out.print(e);

       }



   }

}
