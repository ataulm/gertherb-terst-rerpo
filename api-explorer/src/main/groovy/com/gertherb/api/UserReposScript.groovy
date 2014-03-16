package com.gertherb.api

import com.gertherb.api.shared.ApiScript
import com.gertherb.api.shared.Credentials
import com.gertherb.api.shared.OAuthCredentials
import groovyx.net.http.ContentType

class UserReposScript extends ApiScript {

    Credentials credentials = OAuthCredentials.load()

    @Override
    String description() {
        return  "List repositories for the authenticated user. Note that this does not include repositories " +
                "owned by organizations which the user can access. You can list user organizations and list " +
                "organization repositories separately."
    }

    @Override
    String path() {
        return "/user/repos"
    }

    @Override
    ContentType contentType() {
        return ContentType.JSON
    }

    @Override
    def String authorization() {
        return credentials.getBasicAuthorizationValue()
    }

    static void main(String[] args) {
        new UserReposScript().execute()
    }

}
