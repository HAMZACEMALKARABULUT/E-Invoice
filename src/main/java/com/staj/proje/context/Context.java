package com.staj.proje.context;

import org.springframework.stereotype.Repository;

@Repository
public class Context {

    private static ThreadLocal<RequestContext> currentUser = new ThreadLocal<>();

    public ThreadLocal<RequestContext> getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(RequestContext requestContext) {

        currentUser.set(requestContext);

    }

}

