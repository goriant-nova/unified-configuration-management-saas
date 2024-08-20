package com.goriant.nova.ucm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String data;


    public Configuration() {
    }

    public Configuration(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String key) {
        this.name = key;
    }

    public String getData() {
        return data;
    }

    public void setData(String value) {
        this.data = value;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "key='" + name + '\'' +
                ", value='" + data + '\'' +
                '}';
    }
}
