package com.chandwani.amar.algorithms;

import com.chandwani.amar.algorithms.SnapshotAlgorithm;

public interface LaiYangSnapshotAlgorithm extends SnapshotAlgorithm {
    enum MessageColor {
        RED, WHITE
    }

    class WhiteMessageLog {
        public enum MessageBoundType {
            INBOUND, OUTBOUND
        }

        private Long data;
        private Long timestamp;
        private Long processID;
        private MessageBoundType boundType;

        public WhiteMessageLog(Long data, Long timestamp, MessageBoundType boundType, Long processID) {
            this.data = data;
            this.boundType = boundType;
            this.timestamp = timestamp;
            this.processID = processID;
        }

        public Long getData() { return this.data; }
        public Long getTimestamp() {
            return this.timestamp;
        }
    }
}
