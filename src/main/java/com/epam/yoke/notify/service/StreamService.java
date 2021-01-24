package com.epam.yoke.notify.service;

import com.epam.yoke.notify.NotifierProcessor;
import com.epam.yoke.notify.model.rq.AttenderEventBody;
import com.epam.yoke.notify.model.rq.EventBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(NotifierProcessor.class)
public class StreamService {

    @Autowired
    NotifyService notifyService;

    @StreamListener(NotifierProcessor.INPUT_CREATE_EVENT)
    public void createEvent(EventBody event) {
        notifyService.saveEvent(event);
    }

    @StreamListener(NotifierProcessor.INPUT_DELETE_EVENT)
    public void createEvent(String eventId) {
        notifyService.deleteEvent(eventId);
    }

    @StreamListener(NotifierProcessor.INPUT_ADD_EVENT_ATTENDER)
    public void addEventAttender(AttenderEventBody eventAttender) {
        notifyService.saveEvent(eventAttender);
    }

    @StreamListener(NotifierProcessor.INPUT_DELETE_EVENT_ATTENDER)
    public void deleteEventAttender(AttenderEventBody eventAttender) {
        notifyService.deleteAttender(eventAttender.getEventId(), eventAttender.getEmails().get(0));
    }
}
