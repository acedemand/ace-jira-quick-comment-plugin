package com.acedemand.jira.plugins.rest;

import com.acedemand.api.QuickComment;
import com.acedemand.service.QuickCommentService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * Created by Pamir on 3/30/2017.
 */
@Path("/")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class QuickCommentController {

    @Autowired
    private QuickCommentService quickCommentService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{key}")
    public Response getMessageFromPath(@PathParam("key") String key)
    {
        return Response.ok(getMessageFromKey(key)).build();
    }

    private QuickComment getMessageFromKey(String key){
        Collection<QuickComment> quickCommentCollection = quickCommentService.findAll();
        for(QuickComment quickComment : quickCommentCollection){
            if(quickComment.getName().equalsIgnoreCase(key))
                return quickComment;
        }
        return QuickComment.EMPTY;
    }

}
