package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.service","com.aspect"})
@PropertySource(value = {"jdbc.properties"})
@EnableAspectJAutoProxy
public class SpringConfig {

}
