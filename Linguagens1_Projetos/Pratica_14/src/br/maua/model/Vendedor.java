package br.maua.model;

import br.maua.interfaces.Validator;

import java.util.Objects;

public class Vendedor implements Validator {
    private String id;
    private String name;
    private String password;

    public Vendedor(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode();
    }

    public String  getSenhaHash() {
        return Objects.hash(id,)
    }

    @Override
    public boolean validate(String pass) {
        return this.password.equals(pass);
    }
}
