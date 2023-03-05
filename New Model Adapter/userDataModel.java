package com.example.retrofit_crud.Model; ;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class userDataModel {


    private List<User> user;

    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();


    public List<User> getUser() {
        return user;
    }


    public void setUser(List<User> user) {
        this.user = user;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }


    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    public class User {


        private String id;

        private String name;

        private String job;

        private String imglink;

        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();


        public String getId() {
            return id;
        }


        public void setId(String id) {
            this.id = id;
        }


        public String getName() {
            return name;
        }


        public void setName(String name) {
            this.name = name;
        }


        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getImglink() {
            return imglink;
        }

        public void setImglink(String imglink) {
            this.imglink = imglink;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
}
