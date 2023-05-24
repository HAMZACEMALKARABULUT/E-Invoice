package com.izibiz.api.context;

import java.net.InetAddress;

public class RequestContext {

    private Long userId;
    private String ipAdress;

    public Long getUserId() {
        return userId;
        
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {

        this.ipAdress = ipAdress;
    }

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
