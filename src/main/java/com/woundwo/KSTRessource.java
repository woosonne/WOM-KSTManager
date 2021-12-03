package com.woundwo;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/kst")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KSTRessource {

	@GET
	public List<KST> list() {
		return KST.listAll();
	}

	@GET
	@Path("/{id}")
	public KST get(@PathParam("id") Long id) {
		return KST.findById(id);
	}

	@POST
	@Transactional
	public Response create(KST kst) {
		kst.persist();
		return Response.created(URI.create("/kst/" + kst.id)).build();
	}

	@PUT
	@Path("/{id}")
	@Transactional
	public KST update(@PathParam("id") Long id, KST kst) {
		KST entity = KST.findById(id);
		if (entity == null) {
			throw new NotFoundException();
		}

		// map all fields from the person parameter to the existing entity
		entity.newkst=kst.newkst;

		return entity;
	}
	
	@DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
		KST entity = KST.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
    }

    @GET
    @Path("/search/{name}")
    public KST search(@PathParam("name") String name) {
        return KST.findByPNumber(name);
    }

    @GET
    @Path("/count")
    public Long count() {
        return KST.count();
    }
}
