package com.coc.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

@Component
public class CocRequestInterceptor implements RequestInterceptor {

    private final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjgxODU3MmQ0LThiZmEtNDI0Zi1hOTc2LTBmNThjYzUxNjQ1ZCIsImlhdCI6MTY0MDU4ODY0NSwic3ViIjoiZGV2ZWxvcGVyLzNhOTMyOTBmLTIzN2UtMTA1NS03OTc0LTYxODA2Y2NiMmE5NSIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjQyLjE5Mi4xMzMuNTciXSwidHlwZSI6ImNsaWVudCJ9XX0.sxDerlvjzfhPRrYzeUSA0zblBQ1XREM7gCC0g-UKX2gOCg9S6HXy8Tp28IVe7jjzsj_owIrOtPmtG92sYBTj-A";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Map<String, Collection<String>> headers = requestTemplate.headers();
        requestTemplate.header("authorization", "Bearer " + TOKEN);
    }
}
