package com.epam.yoke.notify;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface NotifierProcessor {
    String INPUT_CREATE_EVENT = "createEvent";
    String INPUT_DELETE_EVENT = "deleteEvent";
    String INPUT_ADD_EVENT_ATTENDER = "addEventAttender";
    String INPUT_DELETE_EVENT_ATTENDER = "deleteEventAttender";

    @Input(INPUT_CREATE_EVENT)
    SubscribableChannel createEvent();

    @Input(INPUT_DELETE_EVENT)
    SubscribableChannel deleteEvent();

    @Input(INPUT_ADD_EVENT_ATTENDER)
    SubscribableChannel addEventAttender();

    @Input(INPUT_DELETE_EVENT_ATTENDER)
    SubscribableChannel deleteEventAttender();
}
