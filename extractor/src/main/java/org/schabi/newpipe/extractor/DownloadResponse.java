package org.schabi.newpipe.extractor;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

public class DownloadResponse {
    private final int responseCode;
    private final String responseBody;
    private final Map<String, List<String>> responseHeaders;

    public DownloadResponse(int responseCode, String responseBody, Map<String, List<String>> headers) {
        super();
        this.responseCode = responseCode;
        this.responseBody = responseBody;
        this.responseHeaders = headers;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return responseHeaders;
    }
    
    @Nonnull
    public List<String> getResponseCookies(){
        if(null == responseHeaders) return Collections.emptyList();
        List<String> cookies = responseHeaders.get("Set-Cookie");
        if(null == cookies)
            return Collections.emptyList();
        else
            return cookies;
    }
}
