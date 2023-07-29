package com.example.application.data.generator;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.application.data.entity.Status;
import com.example.application.data.repository.StatusRepository;

@Order(1)
@Component
public class StatusGenerator implements CommandLineRunner {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {

        List<Status> statuses = statusRepository.findAll();

        if (statuses.size() == 0) {
            List<Status> newStatuses = new LinkedList<>();

            Status status1 = new Status();
            status1.setName("Active");

            Status status2 = new Status();
            status2.setName("Not Active");

            newStatuses.add(status1);
            newStatuses.add(status2);

            statusRepository.saveAll(newStatuses);
        }
    }

}
