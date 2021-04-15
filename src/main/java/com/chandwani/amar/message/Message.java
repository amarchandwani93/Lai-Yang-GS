package com.chandwani.amar.message;

import com.chandwani.amar.resources.comm.Channel;
import com.chandwani.amar.resources.compute.Process;

public interface Message {
    enum MessageType {
        DATA, SPECIAL
    }

    Long getTo();
    Long getFrom();
    Long getInTransitMessage();
    MessageType getMessageType();
    void processAtSender(Process process, Channel channel);
    void processAtReceiver(Process process, Channel channel);
}
