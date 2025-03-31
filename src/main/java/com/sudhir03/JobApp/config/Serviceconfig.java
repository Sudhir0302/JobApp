package com.sudhir03.JobApp.config;

import com.sudhir03.JobApp.service.JobService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Serviceconfig {

    @Bean
    public JobService getSerivce(){
        return new JobService();
    }
}
