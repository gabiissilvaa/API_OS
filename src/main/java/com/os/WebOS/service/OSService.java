package com.os.WebOS.service;

import com.os.WebOS.dto.OSDto;
import com.os.WebOS.repository.OSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OSService {
    @Autowired
    private OSRepository osRepository;


}
