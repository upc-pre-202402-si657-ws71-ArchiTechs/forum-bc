package com.microservice.foroum.forum.domain.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import com.microservice.foroum.forum.domain.model.commands.CreateAnswerCommand;
import com.microservice.foroum.forum.domain.model.valueobjects.UserId;
import com.microservice.foroum.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.apache.logging.log4j.util.Strings;

@Getter
@Entity
public class Answer extends AuditableAbstractAggregateRoot<Answer>{

    @JoinColumn(name = "user_id")
    private UserId userId;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column
    private String answerText;

    public Answer(){
        this.userId = new UserId();
        this.question = new Question();
        this.answerText = Strings.EMPTY;
    }

    public Answer(Long userId, Question question, String answerText){
        this();
        this.userId = new UserId(userId);
        this.question = question;
        this.answerText = answerText;
    }
    public Answer(CreateAnswerCommand command, Question question){
        this();
        this.userId = new UserId(command.userId());
        this.question = question;
        this.answerText = command.answerText();
    }
    public Answer updateInformation(String answer){
        this.answerText = answer;
        return this;
    }
}
