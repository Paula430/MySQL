package com.solvd.daos;

import com.solvd.models.Client;

import java.util.List;

public interface IClientDAO extends IBaseDAO<Client> {
    @Override
    Client getEntityById(int id);

    @Override
    List<Client> getEntities();

    @Override
    Client insert(Client client);

    @Override
    Client update(int id, Client client);

    @Override
    boolean removeById(int id);
}
