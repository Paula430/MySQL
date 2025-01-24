package com.solvd.daos;
import java.util.List;

public interface IBaseDAO<T> {
    T getEntityById(int id);
    List<T> getEntities();
    T insert(T t);
    T update(int id,T t);
    boolean removeById(int id);
}