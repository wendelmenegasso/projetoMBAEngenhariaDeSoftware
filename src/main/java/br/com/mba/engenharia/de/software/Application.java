package br.com.mba.engenharia.de.software;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;

@ConstructorBinding
@SpringBootApplication
public class Application{
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
    @GetMapping("/cookie")
    String cookie(@AuthenticationPrincipal OidcUser principal) {
        return "<h1>Oauth2  </h1>"+
				"<h3>"+principal+"</h3>"+
				"<h3>"+principal.getAttribute("email")+"</h3>"+
				"<h3>"+principal.getAuthorities()+"</h3>"+
				"<h3>"+principal.getIdToken().getTokenValue()+"</h3>";
    }
}
