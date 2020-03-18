package net.jfuentestgn.enslocals;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriMatchTemplate;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class EnsLocalsControllerTest {

//    @Inject
//    EmbeddedServer server;
//
//    @Inject
//    @Client("/")
//    HttpClient client;


    @Test
    void testFindUriPaths() {
        UriMatchTemplate template = UriMatchTemplate.of("/enslocals{?searchCommand*}");
        assertTrue(template.match("/enslocals").isPresent());
        assertTrue(template.match("/enslocals?q=tarragona&page=1&size=10").isPresent());
//        assertEquals("/enslocals?q=tarragona", template.expand(Collections.singletonMap("q", "tarragona")));
    }

//    @Test
//    void search() {
//    }
//
//    @Test
//    void find() {
//    }
}