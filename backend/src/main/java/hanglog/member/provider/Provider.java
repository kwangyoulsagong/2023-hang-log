package hanglog.member.provider;


import static hanglog.global.exception.ExceptionCode.NOT_SUPPORTED_OAUTH_SERVICE;

import hanglog.global.exception.AuthException;
import hanglog.member.dto.GoogleUserInfoResponse;
import hanglog.member.dto.KakaoUserInfoResponse;
import jakarta.annotation.PostConstruct;
import java.util.Arrays;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
public enum Provider {

    GOOGLE("google", GoogleUserInfoResponse.class),
    KAKAO("kakao", KakaoUserInfoResponse.class);

    private final String provider;
    private final Class<?> responseDto;
    private ProviderProperties properties;

    Provider(final String provider, final Class<?> responseDto) {
        this.provider = provider;
        this.responseDto = responseDto;
    }

    public static Provider mappingProvider(final String provider) {
        return Arrays.stream(values())
                .filter(value -> value.provider.equals(provider))
                .findAny()
                .orElseThrow(() -> new AuthException(NOT_SUPPORTED_OAUTH_SERVICE));
    }

    @Component
    private static class PropertiesConfig {

        private final ProviderProperties googleProperties;
        private final ProviderProperties kakaoProperties;

        public PropertiesConfig(
                final ProviderProperties googleProperties,
                final ProviderProperties kakaoProperties
        ) {
            this.googleProperties = googleProperties;
            this.kakaoProperties = kakaoProperties;
        }

        @PostConstruct
        public void postConstruct() {
            GOOGLE.properties = googleProperties;
            KAKAO.properties = kakaoProperties;
        }
    }
}
