package com.kata.cinema.base.webapp.controllers.user;

import org.apache.commons.httpclient.HttpStatus;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


class UserFolderMovieRestControllerTest {

    @Test
    void getOneFolderMovies() throws IOException {
        HttpUriRequest request = new HttpGet( "http://127.0.0.1:5432/api/user/foldermovies/" + 1 );

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_OK));
    }

    @Test
    void getByUserId() throws IOException {
        HttpUriRequest request = new HttpGet( "http://127.0.0.1:5432/api/user/foldermovies/userId");

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_OK));
    }
}