package com.lsm.ws.offer.context.offer;

import com.lsm.ws.offer.context.offer.dto.AddOfferRequest;
import com.lsm.ws.offer.context.offer.dto.OfferDetailsDto;
import com.lsm.ws.offer.context.offer.dto.OfferDto;
import com.lsm.ws.offer.domain.offer.OfferFilter;
import com.lsm.ws.offer.domain.offer.OfferStatus;
import com.lsm.ws.offer.infrastructure.rest.PaginationSpecification;
import com.lsm.ws.offer.infrastructure.rest.context.RequestContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Tag(name = "Offer services")
@RestController
@RequestMapping("/v1/api/offer")
public class OfferInfoEndpoint {

    private static final String ADD_SUMMARY = "Add offer";
    private static final String ADD_DESC = "adds new offer, requires jwt token";
    private static final String SEARCH_SUMMARY = "Search offers";
    private static final String SEARCH_DESC = "searches for offers, returns paginated list of offers";
    private static final String DELETE_OFFER_SUMMARY = "Delete offer";
    private static final String DELETE_OFFER_DESC = "searches for offers, returns paginated list of offers";
    private static final String PUBLISH_OFFER_SUMMARY = "Publish offer";
    private static final String PUBLISH_OFFER_DESC = "publishes offer, requires offer owner's jwt token";

    private final OfferService offerService;
    private final RequestContext requestContext;

    public OfferInfoEndpoint(OfferService offerService, RequestContext requestContext) {
        this.offerService = offerService;
        this.requestContext = requestContext;
    }

    @Operation(summary = ADD_SUMMARY, description = ADD_DESC)
    @PostMapping
    public ResponseEntity<OfferDto> addOffer(@Valid @RequestBody AddOfferRequest request) {
        // TODO: 23/10/2024 map request to domain object e.g. AddOfferCommand
        var offer = offerService.add(request);
        return ResponseEntity.ok(OfferDto.from(offer));
    }

    @Operation(summary = SEARCH_SUMMARY, description = SEARCH_DESC)
    @GetMapping("/available/search")
    public ResponseEntity<List<OfferDto>> searchOffers(@RequestParam(required = false) String country,
                                                       @RequestParam(required = false) String city,
                                                       @RequestParam(required = false) LocalDate availableFrom,
                                                       @RequestParam(required = false) LocalDate availableTo,
                                                       @RequestParam(required = false) BigDecimal rentFrom,
                                                       @RequestParam(required = false) BigDecimal rentTo,
                                                       @RequestParam(required = false) Double surfaceAreaFrom,
                                                       @RequestParam(required = false) Double surfaceAreaTo,
                                                       @ParameterObject
                                                       PaginationSpecification paginationSpecification) {
        var filter = OfferFilter.builder()
                                .withStatus(OfferStatus.PUBLISHED)
                                .withCountry(country)
                                .withCity(city)
                                .withAvailableFrom(availableFrom)
                                .withAvailableTo(availableTo)
                                .withRentFrom(rentFrom)
                                .withRentTo(rentTo)
                                .withSurfaceAreaFrom(surfaceAreaFrom)
                                .withSurfaceAreaTo(surfaceAreaTo)
                                .build();

        var response = offerService.search(filter, paginationSpecification)
                                   .stream()
                                   .map(OfferDto::from)
                                   .toList();

        return ResponseEntity.ok(response);
    }

    @Operation(summary = DELETE_OFFER_SUMMARY, description = DELETE_OFFER_DESC)
    @DeleteMapping("/{offerId}")
    public ResponseEntity<Void> deleteOffer(@PathVariable String offerId) {
        offerService.delete(offerId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = SEARCH_SUMMARY, description = SEARCH_DESC)
    @GetMapping("/user/search")
    public ResponseEntity<List<OfferDetailsDto>> userOffersSearch(@ParameterObject
                                                                  PaginationSpecification paginationSpecification) {
        var filter = OfferFilter.builder()
                                .withUserId(requestContext.userId())
                                .build();

        var response = offerService.search(filter, paginationSpecification)
                                   .stream()
                                   .map(OfferDetailsDto::from)
                                   .toList();

        return ResponseEntity.ok(response);
    }

    @Operation(summary = PUBLISH_OFFER_SUMMARY, description = PUBLISH_OFFER_DESC)
    @PostMapping("/{offerId}/publish")
    public ResponseEntity<OfferDetailsDto> publishOffer(@PathVariable String offerId) {
        var response = OfferDetailsDto.from(offerService.publish(offerId));
        return ResponseEntity.ok(response);
    }
}
