package com.chandwani.amar.resources;

import com.chandwani.amar.resources.compute.LaiYangProcess;
import com.chandwani.amar.resources.compute.Process;
import com.chandwani.amar.snapshot.Snapshot;
import com.chandwani.amar.utilities.Messages;

import java.util.logging.Logger;

public class LaiYangOrchestration extends Orchestration {
    public LaiYangOrchestration() {
        super();
    }

    protected Process createAProcess(long processID, long initialValue) {
        return new LaiYangProcess(processID, initialValue);
    }

    public void recordGlobalStateFrom(long processID) {
        LaiYangProcess process = (LaiYangProcess) this.getProcess(processID);
        process.snapshotGlobalState();
    }

    public Snapshot getLastGlobalSnapshotFromProcess(Long processID){
        LaiYangProcess process = (LaiYangProcess) this.getProcess(processID);
        if (process == null) {
            throw new IllegalArgumentException(Messages.INVALID_PROCESS_ID);
        }

        return process.getLastSnapshot();
    }
}
