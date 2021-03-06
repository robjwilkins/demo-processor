package com.wilkins.processor.messaging;

import brave.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Processor.class)
@Slf4j
@RequiredArgsConstructor
public class MessageHandler {

    private final Tracer tracer;

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Message<String> handleMessage(Message<String> message) {
        log.info("Message Handled: {}, headers: {}", message.getPayload(), message.getHeaders());
        String traceId = tracer.currentSpan().context().traceIdString();
        log.info("traceId: {}", traceId);
        return message;
    }
}
