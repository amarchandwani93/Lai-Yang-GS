package com.chandwani.amar.tester;

import com.chandwani.amar.algorithms.LaiYangSnapshotAlgorithm;
import com.chandwani.amar.message.LaiYangMessage;
import com.chandwani.amar.message.Message;
import com.chandwani.amar.resources.LaiYangOrchestration;
import com.chandwani.amar.resources.Orchestration.ProcessInitMeta;
import com.chandwani.amar.resources.Orchestration.ProcessInitMeta.ProcessInitMetaType;
import com.chandwani.amar.resources.comm.Channel.ChannelType;
import com.chandwani.amar.snapshot.LaiYangSnapshot;
import com.chandwani.amar.utilities.Messages;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LaiYangTester {
    private static final Logger LOGGER = Logger.getLogger(LaiYangTester.class.getName());

    public static void main (String[] arg) {
        test();
    }

    public static void test() {
        System.out.println("Start !");
        LaiYangOrchestration orchestration = null;
        try {
            orchestration = new LaiYangOrchestration();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(Messages.ENTER_NO_OF_PROCESS);
            int noOfProcesses = Integer.parseInt(reader.readLine().trim());

            System.out.println(Messages.ENTER_CHANNEL_TYPE);
            ChannelType channel = ChannelType.getChannelByInt(Integer.parseInt(reader.readLine().trim()));

            System.out.println(Messages.ENTER_FIXED_VARIABLE);
            ProcessInitMetaType processInitMetaType = ProcessInitMetaType.getTypeFromInt( Integer.parseInt(reader.readLine().trim()));

            if (processInitMetaType == ProcessInitMetaType.FIXED) {
                System.out.println(Messages.ENTER_INITIAL_AMOUNT);
                long initialValue = Long.parseLong(reader.readLine().trim());
                orchestration.createProcess(noOfProcesses, initialValue, channel);
            } else {
                int process = 1;
                ProcessInitMeta meta = new ProcessInitMeta(noOfProcesses);
                do {
                    System.out.print(Messages.ENTER_INITIAL_AMOUNT_FOR_PROCESS + process + " : ");
                    meta.addInitialValue(Long.parseLong(reader.readLine().trim()));
                } while (process ++ < noOfProcesses);

                orchestration.createProcess(meta, channel);
            }
            boolean flag = false;

            while (true) {
                try {
                    System.out.println(Messages.LAI_YANG_TESTER_CHOICE);
                    String command = reader.readLine().trim();
                    switch (Integer.parseInt(command)) {
                        case 1 :
                            System.out.print(Messages.ENTER_FROM);
                            long from = Long.parseLong(reader.readLine().trim());

                            System.out.print(Messages.ENTER_TO);
                            long to = Long.parseLong(reader.readLine().trim());

                            System.out.print(Messages.ENTER_AMOUNT);
                            long amount = Long.parseLong(reader.readLine().trim());

                            Message message = new LaiYangMessage(LaiYangSnapshotAlgorithm.MessageColor.WHITE, amount, from, to);
                            orchestration.sendMessage(message);

                            System.out.println(Messages.TRANSACTION_COMPLETE);
                            break;
                        case 2 :
                            System.out.print(Messages.RECORD_SNAPSHOT_AT);
                            long at = Long.parseLong(reader.readLine().trim());

                            orchestration.recordGlobalStateFrom(at);
                            break;
                        case 3 :
                            System.out.print(Messages.ENTER_PROCESS_ID);
                            long processID = Long.parseLong(reader.readLine().trim());
                            LaiYangSnapshot snapshot = (LaiYangSnapshot) orchestration.getLastGlobalSnapshotFromProcess(processID);

                            if (snapshot != null) {
                                System.out.println(snapshot+"");
                            } else {
                                System.out.println(Messages.SNAPSHOT_DOES_NOT_EXIST);
                            }
                            break;
                        case 4 :
                            flag = true;
                            break;
                        default :
                            continue;
                    }
                    System.out.println("");
                    if (flag) {
                        break;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println(Messages.ENTER_VALID_NUMBER);
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        } 
        System.out.println("You have reached the end, please close the window. Thank you :)");
    }
}
