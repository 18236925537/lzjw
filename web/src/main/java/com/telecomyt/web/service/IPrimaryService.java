package com.telecomyt.web.service;

import com.telecomyt.web.entity.Organization;

import java.util.List;

public interface IPrimaryService {

    List<Organization> queryTopOrgas(String orgaCode) throws Exception;

}
