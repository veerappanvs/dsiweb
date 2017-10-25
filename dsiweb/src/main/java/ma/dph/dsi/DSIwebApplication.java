package ma.dph.dsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DSIwebApplication {

    public static void main( String[] args )
    {
        System.out.println( "EI Web application using Spring!" );
        SpringApplication.run(DSIwebApplication.class, args);
    }
     
 /*   @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DsiwebApplication.class);
    }*/
    
/*    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(App.class); //.bannerMode(null);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return configureApplication(builder);
    }

    public static void main(String[] args) {
        configureApplication(new SpringApplicationBuilder()).run(args);
    }*/
}
