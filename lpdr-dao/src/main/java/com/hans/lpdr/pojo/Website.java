package com.hans.lpdr.pojo;

import javax.persistence.*;

public class Website {
    private Integer id;

    private String name;

    private String url;

    private Integer alexa;

    private String country;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return alexa
     */
    public Integer getAlexa() {
        return alexa;
    }

    /**
     * @param alexa
     */
    public void setAlexa(Integer alexa) {
        this.alexa = alexa;
    }

    /**
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }
}