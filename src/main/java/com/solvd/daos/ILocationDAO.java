package com.solvd.daos;

import com.solvd.models.Location;

import java.util.List;

public interface ILocationDAO extends IBaseDAO<Location>{
    @Override
    Location getEntityById(int id);

    @Override
    List<Location> getEntities();

    @Override
    Location insert(Location location);

    @Override
    Location update(int id, Location location);

    @Override
    boolean removeById(int id);
}
