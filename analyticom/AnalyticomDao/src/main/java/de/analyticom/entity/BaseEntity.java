package de.analyticom.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<PK> {

    abstract public PK getId();

}
