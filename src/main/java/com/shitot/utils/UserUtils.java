package com.shitot.utils;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Next on 23.08.2016.
 */
public class UserUtils {
    public static String getLoggedUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
