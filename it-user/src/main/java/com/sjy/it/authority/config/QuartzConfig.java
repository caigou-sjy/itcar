package com.sjy.it.authority.config;

import com.sjy.it.authority.job.QuartzJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(QuartzJob.class)
        .withIdentity("myJob")
                .storeDurably().build();
    }

    @Bean
    public Trigger jobTrigger(){
        SimpleScheduleBuilder ssb = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever();

        return TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("myJob").withSchedule(ssb).build();

    }
}
