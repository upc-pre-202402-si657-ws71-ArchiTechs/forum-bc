package com.microservice.foroum.forum.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import com.microservice.foroum.forum.domain.model.commands.CreateQuestionCommand;
import com.microservice.foroum.forum.domain.model.entities.Category;
import com.microservice.foroum.forum.domain.model.valueobjects.UserId;
import com.microservice.foroum.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Entity
public class Question extends AuditableAbstractAggregateRoot<Question> {

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @JoinColumn(name = "user_id")
    private UserId userId;

    @NotNull
    private String questionText;


    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    public Question() {
        this.category = new Category();
        this.userId = new UserId();
        this.questionText = Strings.EMPTY;
    }

    public Question(Category category, Long userId, String questionText) {
        this();
        this.category = category;
        this.userId = new UserId(userId);
        this.questionText = questionText;
    }

    public Question(CreateQuestionCommand command, Category category) {
        this();
        this.category = category;
        this.userId = new UserId(command.userId());
        this.questionText = command.questionText();
    }

    public Question updateInformation(Category category, String question) {
        this.category = category;
        this.questionText = question;
        return this;
    }
}
