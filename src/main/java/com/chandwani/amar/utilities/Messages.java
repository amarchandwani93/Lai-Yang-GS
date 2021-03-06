package com.chandwani.amar.utilities;

public interface Messages {
    String SPACE = " ";
    String NEWLINE = "\n";

    String DIVIDER = "======================================";
    String ENTER_VALID_NUMBER = "Enter valid number";
    String ENTER_INITIAL_AMOUNT = "Enter initial amount : ";
    String ENTER_INITIAL_AMOUNT_FOR_PROCESS = "Enter initial amount for process ";
    String TYPE_CHANNEL_TYPE = "Type must be 1 or 2";
    String ENTER_FROM = "Enter Source Process ID : ";
    String ENTER_TO = "Enter Destination Process ID : ";
    String ENTER_AMOUNT = "Enter amount : ";
    String ENTER_PROCESS_ID = "Get Snapshot from ";
    String RECORD_SNAPSHOT_AT = "Record Snapshot at : ";
    String ENTER_NO_OF_PROCESS = "Enter no of process : ";
    String SNAPSHOT_DOES_NOT_EXIST = "Snapshot(s) does not exist";
    String ENTER_PROPER_CHANNEL = "Enter proper channel\n";
    String ENTER_CHANNEL_TYPE = "Enter Channel Type :\n1. FIFO\n2. Non-FIFO\n";
    String ENTER_FIXED_VARIABLE = "Enter  :\n1. To initiate all process with single value\n2. To initiate all process with different values";
    String LAI_YANG_TESTER_CHOICE = "Enter operation type :\n1.Send White Message\n2.Snapshot\n3.Print Snapshot\n4.Exit\n";

    String INVALID_TYPE = "Invalid Type";
    String INVALID_CHANNEL_TYPE = "Invalid Channel Type";
    String TRANSACTION_COMPLETE = "Transaction complete";
    String SNAPSHOT_IS_IN_PROGRESS = "Snapshot is in progress";

    String INVALID_PROCESS_ID = "In-valid process id";
    String PROCESSES_ARE_IN_GLOBAL_CONSISTENT_STATE = "The Processes are in global consistent state";
    String PROCESSES_ARE_NOT_IN_GLOBAL_CONSISTENT_STATE = "The Processes are not in global consistent state";
    String INVALID_PROCESS_ID_FOR_WRITE_CHANNEL = "In-valid process id for access write channel";
}