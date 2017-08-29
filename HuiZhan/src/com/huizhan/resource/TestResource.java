package com.huizhan.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.huizhan.service.TestService;

/**
 * Created by jll on 2017/5/16.
 */
@Controller
@Path("/test")
@Scope("prototype")
public class TestResource {
    @Autowired
    private TestService rs;
    @GET
    @Path("/test1")
    @Produces(MediaType.TEXT_PLAIN)
    public String findProvice(){
    	rs.test();
        JSONObject resp = new JSONObject();
        resp.put("code","0");
        resp.put("msg","查询成功");
        
        return JSONObject.toJSONString(resp, SerializerFeature.WriteMapNullValue);
    }

 

  
}
