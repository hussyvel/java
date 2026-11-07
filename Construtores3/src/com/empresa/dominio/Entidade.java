package com.empresa.dominio;

public abstract class Entidade {

    public abstract Long getId();

    public interface Entidade<ID> {
        ID getId();
    }

}
