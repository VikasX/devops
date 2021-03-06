package com.devops.backend.persistence.domain.backend;

import com.devops.enums.PlanEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by XxX on 7/21/2017.
 */
@Entity
public class Plan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private String name;

    public Plan(){

    }

    public Plan(PlanEnum e){
        this.id= e.getId();
        this.name = e.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plan plan = (Plan) o;

        if (id != plan.id) return false;
        return name != null ? name.equals(plan.name) : plan.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
