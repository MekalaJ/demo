package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.JobExecution;

@RestController
public class BatchetController {

    @PostMapping("/job")
    private void submit(@RequestBody String jobRequest) throws  Exception{
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        long excutionId = jobOperator.start(jobRequest,null);
        JobExecution execution = jobOperator.getJobExecution(excutionId);
        BatchStatus status = BatchRuntime.getJobOperator().getJobExecution(excutionId).getBatchStatus();
        while(status != BatchStatus.COMPLETED && status != BatchStatus.FAILED)
        {
            System.out.println(status);
            status = BatchRuntime.getJobOperator().getJobExecution(excutionId).getBatchStatus();
        }
    }
}
