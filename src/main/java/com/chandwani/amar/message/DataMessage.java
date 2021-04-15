package com.chandwani.amar.message;

import com.chandwani.amar.resources.comm.Channel;
import com.chandwani.amar.resources.compute.Process;

public class DataMessage implements Message {
    private Long to;
    private Long from;
    private Long inTransit;
    private static final MessageType MESSAGE_TYPE = MessageType.DATA;

    public DataMessage(Long data, Long from, Long to) {
        this.to = to;
        this.from = from;
        this.inTransit = data;
    }

    public MessageType getMessageType() {
        return MESSAGE_TYPE;
    }

    public Long getTo() {
        return this.to;
    }

    public Long getFrom() {
        return this.from;
    }

    public Long getInTransitMessage() {
        return this.inTransit;
    }

    public void processAtSender(Process process, Channel channel) {
        process.updateData(-inTransit);
        channel.sendMessage(this);
    }

    public void processAtReceiver(Process process, Channel channel) {
        process.updateData(inTransit);
    }
}
