package com.huizhan.config;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class APIApplication extends ResourceConfig{
	 public APIApplication(){  
	     packages("com.huizhan.resource");
	     register(JacksonJsonProvider.class);
	    }


}
