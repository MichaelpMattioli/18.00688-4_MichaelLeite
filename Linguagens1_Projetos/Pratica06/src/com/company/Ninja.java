package com.company;

public class Ninja {
    private String name, family;
    private String[] justsus;

    //Construtor da classe ninja
    public Ninja(String name, String family) {
        this.name = name;
        this.family = family;
        justsus = new String[5];
    }

    public void train(){
        System.out.println("Hoho!");
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }
}
