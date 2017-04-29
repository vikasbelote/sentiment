package com.bigdata.solution.app;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configurable
@EnableWebMvc
@ComponentScan(basePackages = "com.bigdata.solution")
//@Import({RepositoryConfig.class})
public class SolutionConfig extends WebMvcConfigurerAdapter {
	
	 /**
     * Configure TilesConfigurer.
     */
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }
 
    /**
     * Configure ViewResolvers to deliver preferred views.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }
     
    /**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
	
	
	
//	@Bean
//    public static PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer()
//    {
//        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
//        ppc.setLocation(new ClassPathResource("application.properties"));
//        ppc.setIgnoreUnresolvablePlaceholders(true);
//        return ppc;
//    }
	
	
//    @Bean
//    public ConnectionFactoryLocator connectionFactoryLocator() {
//        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
//        registry.addConnectionFactory(new TwitterConnectionFactory("fOmjY6ch8VoTSHHy8PulNgrTE","7EjouPuIDPQsh0Tf7z93ZXetVGs0niXqrWmUyL5vT613q8acwL"));
//            
//            
//         registry.getConnectionFactory(Twitter.class).createConnection(arg0);
//         
//         return null;
//    }


}
