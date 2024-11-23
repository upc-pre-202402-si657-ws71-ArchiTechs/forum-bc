package com.microservice.foroum.forum.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import com.microservice.foroum.forum.domain.model.commands.DeleteAnswerCommand;
import com.microservice.foroum.forum.domain.model.queries.GetAllAnswersByQuestionIdQuery;
import com.microservice.foroum.forum.domain.model.queries.GetAllAnswersQuery;
import com.microservice.foroum.forum.domain.model.queries.GetAnswerByIdQuery;
import com.microservice.foroum.forum.domain.services.AnswerCommandService;
import com.microservice.foroum.forum.domain.services.AnswerQueryService;
import com.microservice.foroum.forum.interfaces.rest.resources.AnswerResource;
import com.microservice.foroum.forum.interfaces.rest.resources.CreateAnswerResource;
import com.microservice.foroum.forum.interfaces.rest.resources.UpdateAnswerResource;
import com.microservice.foroum.forum.interfaces.rest.transform.AnswerResourceFromEntityAssembler;
import com.microservice.foroum.forum.interfaces.rest.transform.CreateAnswerCommandFromResourceAssembler;
import com.microservice.foroum.forum.interfaces.rest.transform.UpdateAnswerCommandFromResourceAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Answer Controller.
 * <p>
 * This class is the entry point for all the REST API calls related to answers.
 * It is responsible for handling the requests and delegating the processing to the appropriate services.
 * It also transforms the data from the request to the appropriate commands and vice versa.
 * <ul>
 *     <li>POST /api/v1/forum/answers</li>
 *     <li>GET /api/v1/forum/answers/{answerId}</li>
 *     <li>GET /api/v1/forum/answers</li>
 *     <li>PUT /api/v1/forum/answers/{answerId}</li>
 *     <li>DELETE /api/v1/forum/answers/{answerId}</li>
 *     <li>GET /api/v1/forum/answers/question/{questionId}</li>
 * </ul>
 * </p>
 *
 *
 */
@RestController
@RequestMapping(value = "/api/v1/forum/answers")
@Tag(name = "Answers", description = "Answers Management Endpoints")
public class AnswersController {
    private final AnswerCommandService answerCommandService;
    private final AnswerQueryService answerQueryService;

    public AnswersController(AnswerCommandService answerCommandService, AnswerQueryService answerQueryService) {
        this.answerCommandService = answerCommandService;
        this.answerQueryService = answerQueryService;
    }

    @PostMapping
    public ResponseEntity<AnswerResource> createAnswer(@RequestBody CreateAnswerResource resource){
        var createAnswerCommand = CreateAnswerCommandFromResourceAssembler.toCommandFromResource(resource);
        var answerId = answerCommandService.handle(createAnswerCommand);
        if(answerId == 0L) return ResponseEntity.badRequest().build();
        var getAnswerByIdQuery = new GetAnswerByIdQuery(answerId);
        var answer = answerQueryService.handle(getAnswerByIdQuery);
        if(answer.isEmpty()) return ResponseEntity.badRequest().build();
        var answerResource =  AnswerResourceFromEntityAssembler.toResourceFromEntity(answer.get());
        return ResponseEntity.ok(answerResource);
    }

    @PutMapping("/{answerId}")
    public ResponseEntity<AnswerResource> updateAnswer(@PathVariable Long answerId, @RequestBody UpdateAnswerResource resource){
        var updateAnswerCommand = UpdateAnswerCommandFromResourceAssembler.toCommandFromResource(answerId, resource);
        var updatedAnswer = answerCommandService.handle(updateAnswerCommand);
        if(updatedAnswer.isEmpty()) return ResponseEntity.badRequest().build();
        var answerResource = AnswerResourceFromEntityAssembler.toResourceFromEntity(updatedAnswer.get());
        return ResponseEntity.ok(answerResource);
    }

    @DeleteMapping("/{answerId}")
    public ResponseEntity<?> deleteAnswer(@PathVariable Long answerId){
        var deleteAnswerCommand = new DeleteAnswerCommand(answerId);
        answerCommandService.handle(deleteAnswerCommand);
        return ResponseEntity.ok("Answer with given id successfully deleted.");
    }

    @GetMapping
    public ResponseEntity<List<AnswerResource>> getAllAnswers(){
        var getAnswersQuery = new GetAllAnswersQuery();
        var answers = answerQueryService.handle(getAnswersQuery);
        var answerResource = answers.stream()
                .map(AnswerResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(answerResource);
    }

    @GetMapping("/{answerId}")
    public ResponseEntity<AnswerResource> getAnswersById(@PathVariable Long answerId){
        var getAnswerByIdQuery = new GetAnswerByIdQuery(answerId);
        var answer = answerQueryService.handle(getAnswerByIdQuery);
        if(answer.isEmpty()) return ResponseEntity.badRequest().build();
        var answerResource = AnswerResourceFromEntityAssembler.toResourceFromEntity(answer.get());
        return ResponseEntity.ok(answerResource);
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<AnswerResource>> getAllAnswersByQuestionId(@PathVariable Long questionId){
        var getAnswersByQuestionIdQuery = new GetAllAnswersByQuestionIdQuery(questionId);
        var answers = answerQueryService.handle(getAnswersByQuestionIdQuery);
        var answerResource = answers.stream()
                .map(AnswerResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(answerResource);
    }
}
