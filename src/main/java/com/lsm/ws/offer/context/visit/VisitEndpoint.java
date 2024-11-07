package com.lsm.ws.offer.context.visit;

import com.lsm.ws.offer.domain.reservation.Visit;
import com.lsm.ws.offer.infrastructure.rest.PaginationSpecification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Visit services")
@RestController
@RequestMapping("/v1/api/offer/visit")
public class VisitEndpoint {

    private static final String GET_USER_VISITS = "Get user visits";
    private static final String GET_USER_VISITS_DESC = "returns logged user accepted visits";
    private final VisitService visitService;

    public VisitEndpoint(VisitService visitService) {
        this.visitService = visitService;
    }

    @Operation(summary = GET_USER_VISITS, description = GET_USER_VISITS_DESC)
    @GetMapping
    public ResponseEntity<List<Visit>> getUserVisits(@ParameterObject PaginationSpecification paginationSpecification) {
        var visits = visitService.getUserAcceptedVisits(paginationSpecification);
        return ResponseEntity.ok(visits);
    }

}
