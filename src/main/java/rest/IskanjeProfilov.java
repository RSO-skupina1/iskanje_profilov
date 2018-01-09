package rest;

import bean.ProfilBean;
import config.ConfigurationData;
import pojo.Profil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("iskanje_profilov")
public class IskanjeProfilov {
    @Inject
    private ProfilBean profilBean;

    @Context
    protected UriInfo uriInfo;

    @GET
    @Path("/test")
    public Response test() {
        return Response.ok("OK").build();
    }

    @Inject
    private ConfigurationData configurationData;

    @GET
    @Path("/{profilId}")
    public Response getProfil(@PathParam("profilId") String profilId) {

        Profil profil = profilBean.getProfil(profilId);

        if (profil == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(profil).build();
    }

}
