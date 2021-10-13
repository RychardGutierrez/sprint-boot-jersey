package com.jalasoft.evaluation.home.datafake;

import java.util.List;

public interface CrudRepository<Type> {
    List<Type> getAll();
}
