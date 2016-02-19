/* 
 * AppWebConfigSupport.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */
package com.planets.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.planets.app.controller.interceptor.AppRestInterceptor;

import edu.tamu.framework.config.CoreWebConfigSupport;

/**
 * Application We Configuration Support.
 */
@Configuration
public class AppWebConfigSupport extends CoreWebConfigSupport {

    @Autowired
    private AppRestInterceptor appRestInterceptor;

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getRestInterceptor() {
        return appRestInterceptor;
    }

}