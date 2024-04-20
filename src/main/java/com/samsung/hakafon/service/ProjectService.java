package com.samsung.hakafon.service;

import com.samsung.hakafon.domain.Project;
import com.samsung.hakafon.domain.User;

import java.util.List;

public interface ProjectService {

    Project create(Project pj, User user);

    List<Project> getAll();

    Project findById(Long id);

    Project update(Long id, Project pj);

    void deleteById(Long id);

}
