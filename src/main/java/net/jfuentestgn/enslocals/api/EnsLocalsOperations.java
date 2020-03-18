package net.jfuentestgn.enslocals.api;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.validation.Validated;

import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@Validated
public interface EnsLocalsOperations {

//    @Get("{?page,size,sort}")
//    PagedResult<EnsLocal> listAll(@QueryValue @Nullable  int page, @QueryValue @Nullable int size, @QueryValue("sort") @Nullable List<String> sortParams);

    @Get("{?searchCommand*}")
    PagedResult<EnsLocal> search(@Valid @Nullable SearchCommand searchCommand);

    @Get("/{id}")
    EnsLocal find(@PathVariable @Valid @Pattern(regexp = "\\d{10}") String id);
}
