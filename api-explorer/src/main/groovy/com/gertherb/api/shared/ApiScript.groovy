package com.gertherb.api.shared
import groovy.json.JsonBuilder
import groovy.time.TimeCategory
import groovy.time.TimeDuration
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

abstract class ApiScript {

    void execute() {
        HTTPBuilder http = new HTTPBuilder('https://api.github.com');
        def method = method()
        def contentType = contentType()
        http.request(method, contentType) {
            println 'R E Q U E S T:\n-------------------------------'

            println "${description()}\n"

            uri.path = path()
            println "URL:\n\t${method} ${uri}"

            headers['Accept'] = 'application/vnd.github.v3+json'
            headers['User-Agent'] = 'Gertherb'
            headers['Authorization'] = "Basic ${authorization()}"
            println "\nHEADERS:"
            headers.collect {
                println "\t${it.getKey()} : ${it.getValue()}"
            }

            body = body()
            println '\nBODY:\n' + new JsonBuilder(body).toPrettyString()

            println '\n\nL O A D I N G . . .\n-------------------------------'
            long startAt = System.currentTimeMillis()

            response.success = { resp, json -> onSuccess(resp, json, startAt) }

            response.failure = { resp, json -> onFailure(resp, json, startAt) }

        }
    }

    String description() {
        ''
    }

    abstract String path()

    Method method() {
        return Method.GET
    }

    ContentType contentType() {
        return ContentType.JSON
    }

    abstract String authorization()

    Object body() {
        return null
    }

    void onSuccess(resp, json, long startAt) {
        printResponseDetails(resp, "SUCCESS", startAt)
        printResponseContent(json)
    }

    void onFailure(resp, json, long startAt) {
        printResponseDetails(resp, "FAILURE", startAt)
        printResponseContent(json)
    }

    void printResponseDetails(resp, label, long startAt) {
        TimeDuration duration = TimeCategory.minus(new Date(), new Date(startAt));

        println '\n\nR E S P O N S E:\n-------------------------------'
        println "${label}:\n\t${resp.statusLine} after ${duration}, response length: ${resp.headers.'Content-Length'}"
    }

    private printResponseContent(json) {
        println "\nCONTENT:\n${new JsonBuilder(json).toPrettyString()}"
    }

}