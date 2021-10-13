package com.jalasoft.evaluation.evaluationtest.datafake;

import java.util.List;

public interface CrudRepository<Type> {
    List<Type> getAll();
}
