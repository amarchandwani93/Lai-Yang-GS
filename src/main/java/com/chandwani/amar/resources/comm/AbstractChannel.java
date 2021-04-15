package com.chandwani.amar.resources.comm;

import com.chandwani.amar.message.Message;
import com.chandwani.amar.resources.compute.Process;
import com.chandwani.amar.utilities.Messages;

public abstract class AbstractChannel implements Channel{
    private String id;
    private Process process1;
    private Process process2;
    AbstractChannel (Process process1, Process process2) {
        this.id = process1.getProcessID() +":"+process2.getProcessID();
        this.process1 = process1;
        this.process2 = process2;
    }

    public String getChannelID() {
        return this.id;
    }

    public Process getProcess1() {
        return process1;
    }

    public Process getProcess2  () {
        return process2;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Channel ID : ")
                .append(getChannelID())
                .append(Messages.SPACE)
                .append("and Processes are ")
                .append(process1.getProcessID())
                .append(" and ")
                .append(process2.getProcessID())
                .toString();
    }

	public boolean hasMessage() {
		// TODO Auto-generated method stub
		return false;
	}

	public Message readMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void sendMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

}
