package com.coc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CocAuthorizationInterceptor implements ClientHttpRequestInterceptor {

    private final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjgxODU3MmQ0LThiZmEtNDI0Zi1hOTc2LTBmNThjYzUxNjQ1ZCIsImlhdCI6MTY0MDU4ODY0NSwic3ViIjoiZGV2ZWxvcGVyLzNhOTMyOTBmLTIzN2UtMTA1NS03OTc0LTYxODA2Y2NiMmE5NSIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjQyLjE5Mi4xMzMuNTciXSwidHlwZSI6ImNsaWVudCJ9XX0.sxDerlvjzfhPRrYzeUSA0zblBQ1XREM7gCC0g-UKX2gOCg9S6HXy8Tp28IVe7jjzsj_owIrOtPmtG92sYBTj-A";

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        HttpHeaders headers = request.getHeaders();
        headers.add("authorization", "Bearer " + TOKEN);
//        headers.setBearerAuth(TOKEN);

        return execution.execute(request, body);
    }
}