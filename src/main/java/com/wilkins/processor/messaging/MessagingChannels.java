package com.wilkins.processor.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessagingChannels {
    String DEMO_REQUEST = "demo-request";
    String DEMO_RESPONSE = "demo-response";

    @Input(DEMO_REQUEST)
    SubscribableChannel demoRequest();

    @Output(DEMO_RESPONSE)
    MessageChannel demoResponse();
}
