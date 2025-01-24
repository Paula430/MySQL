package com.solvd.daos;

import com.solvd.models.Department;

import java.util.List;

public interface IDepartmentDAO extends IBaseDAO<Department> {
    @Override
    boolean removeById(int id);

    @Override
    Department update(int id, Department department);

    @Override
    Department insert(Department department);

    @Override
    List<Department> getEntities();

    @Override
    Department getEntityById(int id);
}
