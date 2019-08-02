package com.rabbitmq.rabbitmq.work;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

@Component
public class WorkService {
    @Autowired
    private AmqpTemplate template;

    @PostConstruct
    public void init() {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(new WorkRun(template, i));
        }
    }
}

class WorkRun implements Runnable {

    private AmqpTemplate template;
    private int index;

    public WorkRun(AmqpTemplate template, int index) {
        this.template = template;
        this.index = index;
    }

    @Override
    public void run() {
        template.convertAndSend("queue", index);
    }
}