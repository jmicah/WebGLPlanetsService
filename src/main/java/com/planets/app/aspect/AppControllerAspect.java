/* 
 * AppControllerAspect.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */
package com.planets.app.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import edu.tamu.framework.aspect.CoreControllerAspect;

/**
 * Application Controller Aspect
 * 
 */
@Component
@Aspect
public class AppControllerAspect extends CoreControllerAspect {

}