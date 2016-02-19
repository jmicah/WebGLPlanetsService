/* 
 * AppWebSocketConfig.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */
package com.planets.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import com.planets.app.controller.interceptor.AppStompInterceptor;

import edu.tamu.framework.config.CoreWebSocketConfig;

/**
 * Application Web Socket Configuration.
 * 
 */
@Configuration
@EnableWebSocketMessageBroker
public class AppWebSocketConfig extends CoreWebSocketConfig {

    /**
     * {@inheritDoc}
     */
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.setInterceptors(appStompInterceptor());
    }

    /**
     * Stomp interceptor bean.
     * 
     * @return StompInterceptor
     * 
     */
    @Bean
    public AppStompInterceptor appStompInterceptor() {
        return new AppStompInterceptor();
    }

}