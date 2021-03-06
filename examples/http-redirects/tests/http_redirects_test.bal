import ballerina/test;
import ballerina/io;
import ballerina/http;

boolean serviceStarted;

function startService() {
    //serviceStarted = test:startServices("http-redirects");
}

@test:Config {
    before: "startService",
    after: "stopService"
}
function testFunc() returns error? {
    // Invoking the main function
    http:Client httpEndpoint = new("http://localhost:9090", config = {
            followRedirects: { enabled: true, maxCount: 5 }
    });
    // Check whether the server is started
    //test:assertTrue(serviceStarted, msg = "Unable to start the service");

    string response1 = "Hello World!";

    // Send a GET request to the specified endpoint
    var response = httpEndpoint->get("/redirect1");
    if (response is http:Response) {
        var res = check response.getTextPayload();
        test:assertEquals(res, response1);
    } else {
        test:assertFail(msg = "Failed to call the endpoint:");
    }
    return;
}

function stopService() {
    //test:stopServices("http-redirects");
}