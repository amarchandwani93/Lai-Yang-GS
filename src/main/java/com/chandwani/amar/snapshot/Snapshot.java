package com.chandwani.amar.snapshot;

import com.chandwani.amar.message.Message;

public interface Snapshot {
    int totalNoOfRecordedProcess();
    void processMessage(Message message);
}
