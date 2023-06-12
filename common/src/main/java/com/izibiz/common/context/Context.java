package com.izibiz.common.context;

import org.springframework.stereotype.Repository;

@Repository
public class Context {

    private static ThreadLocal<RequestContext> currentUser = new ThreadLocal<>();

    public static RequestContext getCurrentUser() {
        return currentUser.get();
    }

    public static void setCurrentUser(RequestContext requestContext) {
        currentUser.set(requestContext);
    }

}

