package com.chandwani.amar.resources.comm;


import com.chandwani.amar.message.Message;
import com.chandwani.amar.resources.compute.Process;
import com.chandwani.amar.utilities.Messages;

public interface Channel {
    enum ChannelType {
        FIFO(1) ,
        NON_FIF0(2);

        private int type;

        ChannelType (int type) {
            this.type = type;
        }

        public int getTypeInt() {
            return this.type;
        }

        public static ChannelType getChannelByInt(int type) {
            for (ChannelType channel : ChannelType.values()) {
                if (type == channel.getTypeInt()) {
                    return channel;
                }
            }

            throw new IllegalArgumentException(Messages.TYPE_CHANNEL_TYPE);
        }
    }

    public static Channel createChannel(ChannelType type, Process process_1, Process process_2) {
    	Channel channel;
        switch (type) {
            case FIFO:
                channel = new FifoChannel(process_1, process_2);
                break;
            case NON_FIF0:
                channel = new NonFifoChannel(process_1, process_2);
                break;
            default:
                throw new IllegalArgumentException(Messages.INVALID_CHANNEL_TYPE);
        }
        return channel;
    }
    
    

    Process getProcess1();
    Process getProcess2();

    String getChannelID();

    boolean hasMessage();
    Message readMessage();
    void sendMessage(Message message);
}