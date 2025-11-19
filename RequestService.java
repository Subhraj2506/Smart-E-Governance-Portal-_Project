package com.egov.service;

import com.egov.entity.ServiceRequest;
import com.egov.entity.ServiceRequest.RequestStatus;
import com.egov.entity.User;
import com.egov.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RequestService {

    @Autowired
    private ServiceRequestRepository requestRepository;

    public ServiceRequest createRequest(ServiceRequest request, User user) {
        request.setUser(user);
        return requestRepository.save(request);
    }

    public List<ServiceRequest> getUserRequests(User user) {
        return requestRepository.findByUser(user);
    }

    public List<ServiceRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    public ServiceRequest updateStatus(Long id, String status) {
        ServiceRequest request = requestRepository.findById(id).orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus(RequestStatus.valueOf(status));
        return requestRepository.save(request);
    }
}

