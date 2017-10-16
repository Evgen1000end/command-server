package com.moex.eif.esb.dispatcher.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import java.util.concurrent.Executor
import java.util.concurrent.Executors

@SpringBootApplication
@EnableScheduling
@EnableAsync
class DispatcherServerApplication

fun main(args: Array<String>) {
  SpringApplication.run(DispatcherServerApplication::class.java, *args)

  @Bean(destroyMethod = "shutdown")
  fun taskScheduler() : Executor {
    return Executors.newScheduledThreadPool(5);
  }

}
