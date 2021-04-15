package com.chandwani.amar.resources.comm;

import com.chandwani.amar.message.Message;
import com.chandwani.amar.resources.compute.Process;

import java.util.LinkedList;
import java.util.Queue;

public class FifoChannel extends AbstractChannel {
    private Queue<Message> queue;
    public FifoChannel(Process process1, Process process2) {
        super(process1, process2);
        queue = new LinkedList<Message>();
    }

    @Override
    public boolean hasMessage() {
        synchronized (queue) {
            return queue.size() > 0;
        }
    }

    @Override
    public Message readMessage() {
        Message message;
        synchronized (queue) {
            message = queue.poll();
        }
        return message;
    }

    @Override
    public void sendMessage(Message message) {
        synchronized (queue) {
            queue.offer(message);
        }
    }

	public Channel createChannel(ChannelType type, Process process_1, Process process_2) {
		// TODO Auto-generated method stub
		return null;
	}
}
