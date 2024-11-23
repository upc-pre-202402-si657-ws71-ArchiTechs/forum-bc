package com.microservice.foroum.forum.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import com.microservice.foroum.forum.domain.model.commands.CreateCategoryCommand;
import com.microservice.foroum.shared.domain.model.entities.AuditableModel;
import org.apache.logging.log4j.util.Strings;

@Getter
@Entity
public class Category extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public Category(){
        this.name = Strings.EMPTY;
    }

    public Category(String name){
        this();
        this.name = name;
    }

    public Category(CreateCategoryCommand command){
        this();
        this.name = command.name();
    }

    public Category updateInformation(String name){
        this.name = name;
        return this;
    }
}
